package be.bruxelleformation.demo.employe;

import java.util.Objects;

public class Employe {
    protected String nom;
    private String prenom;

    public static void main(String[] args) {
        Employe p = new Employe();
        Employe c = new Cadre();

        p.sayHello();
        c.sayHello();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void sayHello() {
        System.out.println("Hello there!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return Objects.equals(nom, employe.nom) && Objects.equals(prenom, employe.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom);
    }
}
