/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO_Foncier;

import java.io.Serializable;

/**
 *
 * @author 26134
 */
public class Foncier implements Serializable{
    private int id;
    private int id_prop;
    private int id_ancien_prop;
    private double prixM2;
    private double prix_total;
    private double surface;
    
    

    public Foncier(int id) {
        this.id = id;
    }

    public Foncier(double prixM2) {
        this.prixM2 = prixM2;
    }

    public Foncier() {
    }

    public Foncier(int id, int id_prop, int id_ancien_prop, double prixM2, double prix_total, double surface) {
        this.id = id;
        this.id_prop = id_prop;
        this.id_ancien_prop = id_ancien_prop;
        this.prixM2 = prixM2;
        this.prix_total = prix_total;
        this.surface = surface;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_prop() {
        return id_prop;
    }

    public void setId_prop(int id_prop) {
        this.id_prop = id_prop;
    }

    public int getId_ancien_prop() {
        return id_ancien_prop;
    }

    public void setId_ancien_prop(int id_ancien_prop) {
        this.id_ancien_prop = id_ancien_prop;
    }

    public double getPrixM2() {
        return prixM2;
    }

    public void setPrixM2(double prixM2) {
        this.prixM2 = prixM2;
    }

    public double getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(double prix_total) {
        this.prix_total = prix_total;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }
    
    
}
