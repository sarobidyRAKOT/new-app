package itu.mg.new_app.utilitaires;

import java.util.*;

public interface ImportExport_impl <T> {
    
    public T Import (String[] ligne, int num_ligne) throws Exception;
    public List <String> Export (List <T> objets);
    public String translate (Map <String, String> data, String input);
    public String generateTempName(String doctype);
    public String abbreviate(String input);
}
