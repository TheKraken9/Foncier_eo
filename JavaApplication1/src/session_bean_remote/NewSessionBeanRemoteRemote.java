/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package session_bean_remote;

import DTO_Devise.Devise;
import DTO_Foncier.Foncier;
import DTO_Foncier.Geom_foncier;
import DTO_Foncier.Plus_foncier;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author 26134
 */
@Remote
public interface NewSessionBeanRemoteRemote extends Serializable{

    public String akory(String hafatra);
     
     public String test_coonection();
     
     public ArrayList<Foncier> all_foncier() throws Exception;
     
     public ArrayList<Foncier> foncierById(int id) throws Exception;
     
     public ArrayList<Geom_foncier> foncier(int id) throws Exception;
     
     public ArrayList<Plus_foncier> plus_foncier(int id) throws Exception;
     
     public ArrayList<Plus_foncier> all_plus_foncier() throws Exception;
     
     public void new_foncier(ArrayList<Plus_foncier> plus_foncier, Foncier foncier) throws Exception;
     
     public Devise get_devise(int id) throws Exception;
     
     public ArrayList<Devise> devises() throws Exception;
     
     public void sell(int id1, int id2, int partielle) throws Exception;
     
     public void sell_part(int id1, int id2, int partielle, double surface, ArrayList<Plus_foncier> plus_foncier) throws Exception;
}
