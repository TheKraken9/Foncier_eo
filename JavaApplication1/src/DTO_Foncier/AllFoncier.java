/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO_Foncier;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author 26134
 */
public class AllFoncier implements Serializable {
    private ArrayList<Plus_foncier> plusFoncier;
    private Foncier foncier;

    public AllFoncier() {
    }

    public AllFoncier(ArrayList<Plus_foncier> plusFoncier, Foncier foncier) {
        this.plusFoncier = plusFoncier;
        this.foncier = foncier;
    }

    public ArrayList<Plus_foncier> getPlusFoncier() {
        return plusFoncier;
    }

    public void setPlusFoncier(ArrayList<Plus_foncier> plusFoncier) {
        this.plusFoncier = plusFoncier;
    }

    public Foncier getFoncier() {
        return foncier;
    }

    public void setFoncier(Foncier foncier) {
        this.foncier = foncier;
    }
    
}
