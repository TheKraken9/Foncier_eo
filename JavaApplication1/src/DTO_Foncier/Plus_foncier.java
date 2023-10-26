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
public class Plus_foncier implements Serializable{
    private int id;
    private double latitude;
    private double longitude;

    public Plus_foncier(int id) {
        this.id = id;
    }

    public Plus_foncier(double latitude) {
        this.latitude = latitude;
    }

    public Plus_foncier(int id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Plus_foncier() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    
}
