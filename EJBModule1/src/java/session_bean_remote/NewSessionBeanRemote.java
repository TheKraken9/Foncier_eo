/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package session_bean_remote;

import DTO_Devise.Devise;
import DTO_Foncier.Foncier;
import DTO_Foncier.Geom_foncier;
import DTO_Foncier.Plus_foncier;
import connecting.FoncierEntity;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author 26134
 */
@Stateless
public class NewSessionBeanRemote implements NewSessionBeanRemoteRemote {

    @Override
    public String akory(String hafatra) {
        return hafatra;
    }

    @Override
    public String test_coonection(){
        String rs = null;
        return rs;
    }
    
    @Override
    public ArrayList<Foncier> all_foncier() throws Exception{
        ArrayList<Foncier> listes = null;
        try{
            listes = FoncierEntity.getAll(null);
        }catch(Exception e){
            e.getMessage();
        }
        return listes;
    }
    
    @Override
    public ArrayList<Foncier> foncierById(int id) throws Exception{
        ArrayList<Foncier> listes = null;
        try{
            listes = FoncierEntity.getById(null, id);
        }catch(Exception e){
            e.getMessage();
        }
        return listes;
    }
    
    @Override
    public ArrayList<Geom_foncier> foncier(int id) throws Exception{
        ArrayList<Geom_foncier> listes = null;
        try{
            listes = FoncierEntity.getGeom(null, id);
        }catch(Exception e){
            e.getMessage();
        }
        return listes;
    }
    
    @Override
    public ArrayList<Plus_foncier> plus_foncier(int id) throws Exception{
        ArrayList<Plus_foncier> listes = null;
        try{
            listes = FoncierEntity.getGeom_info(null, id);
        }catch(Exception e){
            e.getMessage();
        }
        return listes;
    }
    
  
    @Override
    public ArrayList<Plus_foncier> all_plus_foncier() throws Exception{
        ArrayList<Plus_foncier> listes = null;
        try{
            listes = FoncierEntity.getAllGeom_info(null);
        }catch(Exception e){
            e.getMessage();
        }
        return listes;
    }
    
    @Override
    public void new_foncier(ArrayList<Plus_foncier> plus_foncier, Foncier foncier) throws Exception{
        int generatedId = -1;
        System.out.println(plus_foncier + " et " + foncier);
        try{
            generatedId = FoncierEntity.newParcelle(null, foncier);
            FoncierEntity.newPlusParcelle(null, plus_foncier, generatedId);
        }catch(Exception e){
            System.out.println("Erreur au niveau insertion de parcelle : " + e.getMessage());
        }
    }
    
    @Override
    public Devise get_devise(int id) throws Exception{
        Devise devises = null;
        try{
            devises = FoncierEntity.getDevise(null,id);
            System.out.println(devises.getValeur() + " valeur");
        }catch(Exception e){
            e.getMessage();
        }
        return devises;
    } 
    
    @Override
     public ArrayList<Devise> devises() throws Exception {
        ArrayList<Devise> listes = null;
        try{
            listes = FoncierEntity.getAllDevises(null);
        }catch(Exception e){
            e.getMessage();
        }
        return listes;
    }
     
     @Override
     public void sell(int id1, int id2, int partielle) throws Exception {
         double prix = 0.0;double sold1 = 0.0;double sold2 = 0.0;
         try{
            prix = FoncierEntity.is_ok(null, partielle, id1);
            if(prix == 0.0){
                throw new Exception("L acheteur ne possede pas ce bien");
            }
            sold1 = FoncierEntity.getPrice(null, id1);
            sold2 = FoncierEntity.getPrice(null, id2);
             System.out.println("sold1 ="+sold1 + " et sold2="+sold2);
             System.out.println("prix ="+prix);
            if(sold2 < prix){
                throw new Exception("solde insuffisant pour l acheteur");
            }else{
                double prix1 = (double)(sold1 + prix);
                double prix2 = (double)(sold2 - prix);
                System.out.println("prix1="+prix1 + " et prix2="+prix2);
                FoncierEntity.updateParcelle(null, partielle, id2, id1);
                
                FoncierEntity.updateSomme(null, prix1, id1);
                FoncierEntity.updateSomme(null, prix2, id2);
            }
         }catch(Exception e){
             System.out.println("Erreur de vente de bien : " + e.getMessage());
         }
         
     }
     
     @Override
     public void sell_part(int id1, int id2, int partielle, double surface, ArrayList<Plus_foncier> plus_foncier) throws Exception {
         double prix = 0.0;double sold1 = 0.0;double sold2 = 0.0;double surfaces=0.0;double prix_m2 = 0.0;
         int generatedId = 0;
         try{
            prix_m2 = FoncierEntity.prix_m2(null, partielle, id1);
            prix = (prix_m2 * surface);
            surfaces = FoncierEntity.is_ok_surface(null, partielle, id2);
            if(prix == 0.0){
                throw new Exception("L acheteur ne possede pas ce bien");
            }
            if(surfaces < surface){
                throw new Exception("L acheteur ne possede pas cette surface demandee");
            }
            sold1 = FoncierEntity.getPrice(null, id1);
            sold2 = FoncierEntity.getPrice(null, id2);
             System.out.println("sold1 ="+sold1 + " et sold2="+sold2);
             System.out.println("prix ="+prix);
            if(sold2 < prix){
                throw new Exception("solde insuffisant pour l acheteur");
            }else{
                double prix1 = (double)(sold1 + prix);
                double prix2 = (double)(sold2 - prix);
                System.out.println("prix1="+prix1 + " et prix2="+prix2);
                generatedId = FoncierEntity.updateParcelle_part(null, partielle, id2, id1, surface, prix_m2, prix);
                
                FoncierEntity.insert_new_parcelle(null, plus_foncier, generatedId);
                
                FoncierEntity.updateSomme(null, prix1, id1);
                FoncierEntity.updateSomme(null, prix2, id2);
            }
         }catch(Exception e){
             System.out.println("Erreur de vente de bien : " + e.getMessage());
         }
     }
}
