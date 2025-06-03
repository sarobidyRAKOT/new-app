package itu.mg.new_app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import itu.mg.new_app.config.ApiProperties;

@Service
public class Default_service {
    
    @Autowired public RestTemplate restTemplate;
    @Autowired public ApiProperties apiProperties;
    private final ObjectMapper objectMapper = new ObjectMapper();

    
    public static String generateTempName(String doctype) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            randomString.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }

        return "new-" + doctype.toLowerCase() + "-" + randomString.toString();
    }

            // Créer le fichier et écrire un contenu initial
    // public void createJsonFile(Map<String, Object> data) throws IOException {
    //     objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), data);
    // }

    // // Lire le contenu JSON
    // @SuppressWarnings("unchecked")
    // public Map<String, Object> readJsonFile() throws IOException {
    //     return objectMapper.readValue(new File(FILE_PATH), Map.class);
    // }

    // // Modifier une valeur dans le JSON
    // public void updateJsonFile(String key, Object newValue) throws IOException {
    //     Map<String, Object> data = readJsonFile();
    //     data.put(key, newValue);
    //     createJsonFile(data);  // Réécrire le fichier avec la nouvelle valeur
    // }

    // // Supprimer le fichier (optionnel)
    // public void deleteJsonFile() throws IOException {
    //     Files.deleteIfExists(Paths.get(FILE_PATH));
    // }



}
