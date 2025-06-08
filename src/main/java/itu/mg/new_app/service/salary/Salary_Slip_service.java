package itu.mg.new_app.service.salary;

import java.io.*;
import java.time.LocalDate;
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import itu.mg.new_app.model.salary.*;
import itu.mg.new_app.service.API_Service;
import itu.mg.new_app.utilitaires.*;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class Salary_Slip_service {
    
    @Autowired private API_Service api_Service;
    @Autowired private SpringTemplateEngine springTemplateEngine;
    private final String doctype = "Salary Slip";
    private final ParameterizedTypeReference <Json_Result <Salary_Slip>> ref_single = new ParameterizedTypeReference<Json_Result<Salary_Slip>>() {};
    private final ParameterizedTypeReference <Json_Result <List<Salary_Slip>>> ref_list = new ParameterizedTypeReference<Json_Result<List<Salary_Slip>>>() {};



    
    public Salary_Slip get_by (Parameters parameters) {
        
        Json_Result <Salary_Slip> result = api_Service.API_resource(doctype, null, parameters, HttpMethod.GET, ref_single);
        return result.getData();

    }

    public Salary_Slip get_by (String salary_slip, Parameters parameters) {
        
        Json_Result <Salary_Slip> result = api_Service.API_resource(doctype+"/"+salary_slip, null, parameters, HttpMethod.GET, ref_single);
        return result.getData();

    }
    

    public List <Salary_Slip> get_allWith (Parameters parameters) {
        
        Json_Result <List <Salary_Slip>> result = api_Service.API_resource(doctype, null, parameters, HttpMethod.GET, ref_list);
        return result.getData();

    }


    public Map <Month, Salary_Slip> somme_salary_slipBy (Integer annees) {
        Parameters parameters = Parameters.get_instance(); // 
        parameters.addField("fields", "[\"*\"]");

        parameters.addFilter("start_date", ">=", annees+"-01-01");
        parameters.addFilter("end_date", "<=", annees+"-12-31");
        parameters.addFilter("docstatus", "=", 1);

        List <Salary_Slip> salary_Slips = this.get_allWith(parameters);
        Map <Month, Salary_Slip> somme = new HashMap<>();
        for (Salary_Slip salary_Slip : salary_Slips) {
            LocalDate p = salary_Slip.getStart_date();
            Month m = Month.fromNumero(p.getMonthValue());
            // Salary_Slip ss = somme.getOrDefault (m, salary_Slip);
            Salary_Slip ss = somme.get(m);
            if (ss == null) {
                ss = new Salary_Slip();
            }

            salary_Slip.somme(ss);

            somme.put(m, salary_Slip);
        }

        return somme;
    }



    public void telechargerPDF_Salary_Slip(HttpServletResponse response, Salary_Slip salary_Slip) {
        try {
            // 1. Préparer HTML
            Context context = new Context();
            context.setVariable("salary_Slip", salary_Slip);
            String pathHTML = springTemplateEngine.process("pages/salary/salary-slip-PDF", context);

            // 2. Générer le PDF dans un buffer
            ByteArrayOutputStream pdfOutput = new ByteArrayOutputStream();
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withHtmlContent(pathHTML, null);
            builder.toStream(pdfOutput);
            builder.run();

            // 3. Écriture HTTP uniquement si pas d'erreur
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=fiche_de_paie.pdf");
            response.setContentLength(pdfOutput.size());

            try (OutputStream os = response.getOutputStream()) {
                pdfOutput.writeTo(os);
                os.flush();
            }

        } catch (Exception e) {
            // S'il y a une erreur, NE RIEN ÉCRIRE dans la réponse si déjà committée
            e.printStackTrace();

            if (!response.isCommitted()) {
                try {
                    response.reset(); // Efface partiellement le buffer de réponse (si possible)
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de la génération du PDF");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }


    
}