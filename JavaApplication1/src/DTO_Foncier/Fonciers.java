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
public class Fonciers implements Serializable{
    private int id;
    private int id_prop;
    private int id_ancien_prop;
    private double prix_m2;
    private double prix_total;
    private double surface;
    
    private int id_plus;
    private double latitude;
    private double longitude;
    
    private int id_geom;
    private String geom_surface;
    
    public Fonciers(int id, int id_prop, int id_ancien_prop, double prix_m2, double prix_total, double surface) {
        this.id = id;
        this.id_prop = id_prop;
        this.id_ancien_prop = id_ancien_prop;
        this.prix_m2 = prix_m2;
        this.prix_total = prix_total;
        this.surface = surface;
    }
    
    public Fonciers(int id_plus, double latitude, double longitude) {
        this.id_plus = id_plus;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public Fonciers(int id_geom, String geom_surface) {
        this.id_geom = id_geom;
        this.geom_surface = geom_surface;
    }

    public Fonciers() {
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

    public double getPrix_m2() {
        return prix_m2;
    }

    public void setPrix_m2(double prix_m2) {
        this.prix_m2 = prix_m2;
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

    public int getId_plus() {
        return id_plus;
    }

    public void setId_plus(int id_plus) {
        this.id_plus = id_plus;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getId_geom() {
        return id_geom;
    }

    public void setId_geom(int id_geom) {
        this.id_geom = id_geom;
    }

    public String getGeom_surface() {
        return geom_surface;
    }

    public void setGeom_surface(String geom_surface) {
        this.geom_surface = geom_surface;
    }
 
}
