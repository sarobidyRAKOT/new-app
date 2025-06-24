package itu.mg.new_app.utilitaires.traitement_import;

import java.util.*;

public interface ImportExport_impl <T> {
    
    public void Import (String[] ligne, int num_ligne);
    // public void Import_ (String[] ligne, int num_ligne);
    public List <String> Export (List <T> objets);
    public T get_result ();
}
