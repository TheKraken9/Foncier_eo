/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO_Foncier;

import java.io.Serializable;
import net.postgis.jdbc.geometry.Geometry;
/**
 *
 * @author 26134
 */
public class Geom_foncier implements Serializable{
    private int id;
    private Geometry geom_surface;

    public Geom_foncier() {
    }

    public Geom_foncier(int id) {
        this.id = id;
    }

    public Geom_foncier(Geometry geom_surface) {
        this.geom_surface = geom_surface;
    }

    public Geom_foncier(int id, Geometry geom_surface) {
        this.id = id;
        this.geom_surface = geom_surface;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Geometry getGeom_surface() {
        return geom_surface;
    }

    public void setGeom_surface(Geometry geom_surface) {
        this.geom_surface = geom_surface;
    }
    
}
