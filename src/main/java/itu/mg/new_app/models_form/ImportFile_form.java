package itu.mg.new_app.models_form;


import org.springframework.web.multipart.MultipartFile;

public class ImportFile_form {
    
    private MultipartFile fichier1;
    private MultipartFile fichier2;
    private MultipartFile fichier3;


    public ImportFile_form () {}


    public MultipartFile getFichier3() { return fichier3; }
    public void setFichier3(MultipartFile fichier3) { this.fichier3 = fichier3; }

    public MultipartFile getFichier1() { return fichier1; }
    public MultipartFile getFichier2() { return fichier2; }

    public void setFichier1(MultipartFile fichier1) { this.fichier1 = fichier1; }
    public void setFichier2(MultipartFile fichier2) { this.fichier2 = fichier2; }
}
