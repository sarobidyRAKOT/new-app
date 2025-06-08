package itu.mg.new_app.utilitaires;

public enum Month {
    
    JANVIER(1, "Janvier"),
    FEVRIER(2, "Février"),
    MARS(3, "Mars"),
    AVRIL(4, "Avril"),
    MAI(5, "Mai"),
    JUIN(6, "Juin"),
    JUILLET(7, "Juillet"),
    AOUT(8, "Août"),
    SEPTEMBRE(9, "Septembre"),
    OCTOBRE(10, "Octobre"),
    NOVEMBRE(11, "Novembre"),
    DECEMBRE(12, "Décembre");

    private final int numero;
    private final String nom;

    Month (int numero, String nom) {
        this.numero = numero;
        this.nom = nom;
    }

    public int getNumero() {
        return numero;
    }
    

    public String getNom() {
        return nom;
    }

    public static Month fromNumero(int numero) {
        for (Month m : values()) {
            if (m.getNumero() == numero) return m;
        }
        throw new IllegalArgumentException("Mois invalide: " + numero);
    }
}
