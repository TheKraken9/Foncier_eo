/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO_Bien;

import java.io.Serializable;

/**
 *
 * @author 26134
 */
public class Bien implements Serializable{
    private int vendeur;
    private int acheteur;
    private int partielle;
    private double surface;

    public Bien() {
    }

    public Bien(int vendeur) {
        this.vendeur = vendeur;
    }

    public Bien(double surface) {
        this.surface = surface;
    }

    public Bien(int vendeur, int acheteur, int partielle, double surface) {
        this.vendeur = vendeur;
        this.acheteur = acheteur;
        this.partielle = partielle;
        this.surface = surface;
    }
    

    public int getVendeur() {
        return vendeur;
    }

    public void setVendeur(int vendeur) {
        this.vendeur = vendeur;
    }

    public int getAcheteur() {
        return acheteur;
    }

    public void setAcheteur(int acheteur) {
        this.acheteur = acheteur;
    }

    public int getPartielle() {
        return partielle;
    }

    public void setPartielle(int partielle) {
        this.partielle = partielle;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }
    
    
    
}
