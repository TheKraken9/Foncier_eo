/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connecting;

import DTO_Banque.Banque;
import DTO_Foncier.Foncier;
import DTO_Devise.Devise;
import DTO_Foncier.Fonciers;
import DTO_Foncier.Geom_foncier;
import DTO_Foncier.Plus_foncier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import javax.naming.InitialContext;
//import org.locationtech.jts.geom.Geometry;
import net.postgis.jdbc.geometry.Geometry;
import project_banque.session_bean_banque_remoteRemote;
import net.postgis.jdbc.PGgeometry;


/**
 *
 * @author 26134
 */
public class FoncierEntity {
    public static ArrayList<Foncier> getAll(Connection con) throws Exception{
        ArrayList <Foncier> liste = new ArrayList<Foncier>();
        Statement st = null;
        ResultSet res = null;
        int co = 0;
        try{
            if(con==null){
                con = Postgres.getConnect("postgres");
                co = 1;
            }
            String requete = "select * from info_foncier";
            System.out.println("zatra tsika zany");
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next()){
                System.out.println(res.getDouble("prix_m2"));
                System.out.println(res.getDouble("surface"));
                Foncier ze = new Foncier(res.getInt("id"),res.getInt("id_prop"), res.getInt("id_ancien_prop"), res.getDouble("prix_m2"), res.getDouble("prix_total"), res.getDouble("surface"));
                liste.add(ze);
            }
        }catch(Exception e){
            throw new Exception("hehehe boy");
        }
        finally{
            if(res != null){
                res.close();
            }
            if(st != null){
                st.close();
            }
            if(co == 1){
                con.close();
            }
        }
        return liste;
    }
    
    public static ArrayList<Foncier> getById(Connection con, int id) throws Exception{
        ArrayList <Foncier> liste = new ArrayList<Foncier>();
        Statement st = null;
        ResultSet res = null;
        int co = 0;
        try{
            if(con==null){
                con = Postgres.getConnect("postgres");
                co = 1;
            }
            String requete = "select * from info_foncier where id_prop="+id;
            System.out.println("zatra tsika zany");
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next()){
                System.out.println(res.getDouble("prix_m2"));
                System.out.println(res.getDouble("surface"));
                Foncier ze = new Foncier(res.getInt("id"),res.getInt("id_prop"), res.getInt("id_ancien_prop"), res.getDouble("prix_m2"), res.getDouble("prix_total"), res.getDouble("surface"));
                liste.add(ze);
            }
        }catch(Exception e){
            throw new Exception("hehehe boy");
        }
        finally{
            if(res != null){
                res.close();
            }
            if(st != null){
                st.close();
            }
            if(co == 1){
                con.close();
            }
        }
        return liste;
    }
    
    
    public static ArrayList<Geom_foncier> getGeom(Connection con, int id) throws Exception{
        ArrayList <Geom_foncier> liste = new ArrayList<Geom_foncier>();
        Statement st = null;
        ResultSet res = null;
        int co = 0;
        try{
            if(con==null){
                con = Postgres.getConnect("postgres");
                co = 1;
            }
            String requete = "select * from geom_foncier where id_foncier="+id;
            System.out.println("zatra tsika zany");
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next()){
                System.out.println(res.getInt("id_foncier"));
                System.out.println(res.getString("geom_surface"));
                int id_foncier = res.getInt("id_foncier");
                System.out.println("eeeeeeeee");
                PGgeometry geom = (PGgeometry) res.getObject("geom_surface");
                System.out.println(geom);
                Geometry geometry = geom.getGeometry();
                System.out.println(geometry);
                Geom_foncier ze = new Geom_foncier(id_foncier, geometry);
                liste.add(ze);
            }
        }catch(Exception e){
            throw new Exception("hehehe boy");
        }
        finally{
            if(res != null){
                res.close();
            }
            if(st != null){
                st.close();
            }
            if(co == 1){
                con.close();
            }
        }
        return liste;
    }
    
     public static ArrayList<Plus_foncier> getGeom_info(Connection con, int id) throws Exception{
        ArrayList <Plus_foncier> liste = new ArrayList<Plus_foncier>();
        Statement st = null;
        ResultSet res = null;
        int co = 0;
        try{
            if(con==null){
                con = Postgres.getConnect("postgres");
                co = 1;
            }
            String requete = "select * from plus_info_foncier where id_foncier="+id;
            System.out.println("zatra tsika zany");
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next()){
                System.out.println(res.getInt("id_foncier"));
                System.out.println(res.getString("lat"));
                System.out.println(res.getString("long"));
                
                Plus_foncier ze = new Plus_foncier(res.getInt("id_foncier"), res.getDouble("lat"), res.getDouble("long"));
                liste.add(ze);
            }
        }catch(Exception e){
            throw new Exception("hehehe boy");
        }
        finally{
            if(res != null){
                res.close();
            }
            if(st != null){
                st.close();
            }
            if(co == 1){
                con.close();
            }
        }
        return liste;
    }
     
     public static ArrayList<Plus_foncier> getAllGeom_info(Connection con) throws Exception{
        ArrayList <Plus_foncier> liste = new ArrayList<Plus_foncier>();
        Statement st = null;
        ResultSet res = null;
        int co = 0;
        try{
            if(con==null){
                con = Postgres.getConnect("postgres");
                co = 1;
            }
            String requete = "select * from plus_info_foncier";
            System.out.println("zatra tsika zany");
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next()){
                System.out.println(res.getInt("id_foncier"));
                System.out.println(res.getString("lat"));
                System.out.println(res.getString("long"));
                
                Plus_foncier ze = new Plus_foncier(res.getInt("id_foncier"), res.getDouble("lat"), res.getDouble("long"));
                liste.add(ze);
            }
        }catch(Exception e){
            throw new Exception("hehehe boy");
        }
        finally{
            if(res != null){
                res.close();
            }
            if(st != null){
                st.close();
            }
            if(co == 1){
                con.close();
            }
        }
        return liste;
    }
     
    public static int newParcelle(Connection con,Foncier foncier) throws Exception {
    PreparedStatement pst = null;
    int generatedId = -1;
    int co = 0;
    try {
        if (con == null) {
            con = Postgres.getConnect("postgres");
            co = 1;
        }

        String requete = "INSERT INTO info_foncier (id_prop, id_ancien_prop, prix_m2, prix_total, surface) VALUES (?, ?, ?, ?, ?)";
        pst = con.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

        pst.setInt(1, foncier.getId_prop());
        pst.setInt(2, foncier.getId_ancien_prop());
        pst.setDouble(3, foncier.getPrixM2());
        pst.setDouble(4, foncier.getPrix_total());
        pst.setDouble(5, foncier.getSurface());

        int rowsAffected = pst.executeUpdate();

        if (rowsAffected != 1) {
            throw new Exception("L'insertion a échoué pour les données : " + foncier);
        }
        
        ResultSet rs = pst.getGeneratedKeys();
        if(rs.next()){
            generatedId = rs.getInt(1);
        }

        System.out.println("Modification effectuée");

    } catch (Exception e) {
        throw new Exception("Erreur lors de l'insertion des données : " + e.getMessage());
    } finally {
        if (pst != null) {
            pst.close();
        }
        if (co == 1) {
            con.close();
        }
    }
    return generatedId;
}
     
    public static void newPlusParcelle(Connection con, ArrayList<Plus_foncier> plus_foncier, int id_foncier) throws Exception {
    PreparedStatement pst = null;
    int co = 0;
    try {
        if (con == null) {
            con = Postgres.getConnect("postgres");
            co = 1;
        }

        String requete = "INSERT INTO plus_info_foncier (id_foncier, lat, long) VALUES (?, ?, ?)";
        pst = con.prepareStatement(requete);

        for (Plus_foncier pf : plus_foncier) {
            pst.setInt(1, id_foncier);
            pst.setDouble(2, pf.getLatitude());
            pst.setDouble(3, pf.getLongitude());

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected != 1) {
                throw new Exception("L'insertion a échoué pour les données : " + pf);
            }
        }

        System.out.println("Modification effectuée");

    } catch (Exception e) {
        throw new Exception("Erreur lors de l'insertion des données : " + e.getMessage());
    } finally {
        if (pst != null) {
            pst.close();
        }
        if (co == 1) {
            con.close();
        }
    }
}

     
    public static Devise getDevise(Connection con, int id)throws Exception{
        Devise devise = new Devise();
        Statement st = null;
        ResultSet res = null;
        int co = 0;
        try{
            if(con==null){
                con = Postgres.getConnect("postgres");
                co = 1;
            }
            String requete = "select * from devise where id ="+id;
            System.out.println("zatra tsika zany");
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next()){
                System.out.println(res.getString("nom"));
                System.out.println(res.getDouble("valeur"));
                System.out.println(res.getDate("date"));
                devise = new Devise(res.getInt("id"), res.getString("nom"), res.getDouble("valeur"),res.getDouble("vente"),res.getDate("date"));
            }
        }catch(Exception e){
            throw new Exception("hehehe boy");
        }
        finally{
            if(res != null){
                res.close();
            }
            if(st != null){
                st.close();
            }
            if(co == 1){
                con.close();
            }
        }
        System.out.println(devise.getNom() + " eto");
        return devise;
    }
    
    
    public static ArrayList<Devise> getAllDevises(Connection con) throws Exception{
    ArrayList <Devise> listes = new ArrayList<Devise>();
        Statement st = null;
        ResultSet res = null;
        int co = 0;
        try{
            if(con==null){
                con = Postgres.getConnect("postgres");
                co = 1;
            }
            String requete = "SELECT DISTINCT ON (nom) id, nom, valeur, vente, date FROM devise ORDER BY nom, date DESC";
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next()){
                System.out.println(res.getString("id"));
                System.out.println(res.getString("nom"));
                Devise ze = new Devise(res.getInt("id"), res.getString("nom"), res.getDouble("valeur"),res.getDouble("vente"), res.getDate("date"));
                listes.add(ze);
            }
        }catch(Exception e){
            throw new Exception("hehehe boy");
        }
        finally{
            if(res != null){
                res.close();
            }
            if(st != null){
                st.close();
            }
            if(co == 1){
                con.close();
            }
        }
        return listes;
    }
    
    
     public static double is_ok(Connection con, int parcelle,int id) throws Exception{
        double is_ok = 0;
        double som = 0;
        Statement st = null;
        ResultSet res = null;
        int co = 0;
        try{
            if(con==null){
                con = Postgres.getConnect("postgres");
                co = 1;
            }
            String requete = "select * from info_foncier where id=" + parcelle + " and id_prop="+id;
            System.out.println(requete);
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next()){
                som = res.getDouble("prix_total");
                System.out.println(res.getInt("id"));
                System.out.println(res.getDouble("prix_total"));
                return som;
            }
        }catch(Exception e){
            throw new Exception("hehehe boy");
        }
        finally{
            if(res != null){
                res.close();
            }
            if(st != null){
                st.close();
            }
            if(co == 1){
                con.close();
            }
        }
        return is_ok;
    }
     
     
    public static double prix_m2(Connection con, int parcelle,int id) throws Exception{
        double is_ok = 0;
        double som = 0;
        Statement st = null;
        ResultSet res = null;
        int co = 0;
        try{
            if(con==null){
                con = Postgres.getConnect("postgres");
                co = 1;
            }
            String requete = "select * from info_foncier where id=" + parcelle + " and id_prop="+id;
            System.out.println(requete);
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next()){
                som = res.getDouble("prix_m2");
                System.out.println(res.getInt("id"));
                System.out.println(res.getDouble("prix_m2"));
                return som;
            }
        }catch(Exception e){
            throw new Exception("hehehe boy");
        }
        finally{
            if(res != null){
                res.close();
            }
            if(st != null){
                st.close();
            }
            if(co == 1){
                con.close();
            }
        }
        return is_ok;
    }
     
     
    public static double is_ok_surface(Connection con, int parcelle,int id) throws Exception{
        double is_ok = 0;
        double som = 0;
        Statement st = null;
        ResultSet res = null;
        int co = 0;
        try{
            if(con==null){
                con = Postgres.getConnect("postgres");
                co = 1;
            }
            String requete = "select * from info_foncier where id=" + parcelle + " and id_prop="+id;
            System.out.println(requete);
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next()){
                som = res.getDouble("surface");
                System.out.println(res.getInt("id"));
                System.out.println(res.getDouble("prix_m2"));
                return som;
            }
        }catch(Exception e){
            throw new Exception("hehehe boy");
        }
        finally{
            if(res != null){
                res.close();
            }
            if(st != null){
                st.close();
            }
            if(co == 1){
                con.close();
            }
        }
        return is_ok;
    }
    
    public static void updateParcelle(Connection con, int parcelle,int id2, int id1) throws Exception {
        PreparedStatement pst = null;
    int co = 0;
    try {
        if (con == null) {
            con = Postgres.getConnect("postgres");
            co = 1;
        }

        String requete = "update info_foncier set id_prop="+id2 + ", id_ancien_prop="+id1+ " where id="+parcelle;
        pst = con.prepareStatement(requete);
       
        int rowsAffected = pst.executeUpdate();

        if (rowsAffected != 1) {
            throw new Exception("L'insertion a échoué. Aucune ligne n'a été affectée.");
        }
           System.out.println("modification effectue");
    } catch (Exception e) {
        throw new Exception("Erreur lors de l'insertion des données : " + e.getMessage());
    } finally {
        if (pst != null) {
            pst.close();
        }
        if (co == 1) {
            con.close();
        }
    }
    }
    
    
    public static int updateParcelle_part(Connection con,int partielle, int id2, int id1, double surface, double prix_m2, double prix) throws Exception{
        PreparedStatement pst = null;
        int generatedId = 0;
        int co = 0;
        try {
            if (con == null) {
                con = Postgres.getConnect("postgres");
                co = 1;
            }

            String requete = "INSERT INTO info_foncier (id_prop, id_ancien_prop, prix_m2, prix_total, surface) VALUES (?, ?, ?, ?, ?)";
            pst = con.prepareStatement(requete,Statement.RETURN_GENERATED_KEYS);

           
            pst.setInt(1, id2);
            pst.setInt(2, id1);
            pst.setDouble(3, prix_m2);
            pst.setDouble(4, prix);
            pst.setDouble(5, surface);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected != 1) {
                throw new Exception("L'insertion a échoué pour les données : " + pst);
            }
          
             ResultSet rs = pst.getGeneratedKeys();
            if(rs.next()){
                generatedId = rs.getInt(1);
            }

            System.out.println("Modification effectuée");

        } catch (Exception e) {
            throw new Exception("Erreur lors de l'insertion des données : " + e.getMessage());
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (co == 1) {
                con.close();
            }
        }
        return generatedId;
    }
    
    public static void insert_new_parcelle(Connection con, ArrayList<Plus_foncier> plus_foncier, int generatedId) throws Exception {
        PreparedStatement pst = null;
        int co = 0;
        try {
            if (con == null) {
                con = Postgres.getConnect("postgres");
                co = 1;
            }

            String requete = "INSERT INTO plus_info_foncier (id_foncier, lat, long) VALUES (?, ?, ?)";
            pst = con.prepareStatement(requete);

            for (Plus_foncier pf : plus_foncier) {
                pst.setInt(1, generatedId);
                pst.setDouble(2, pf.getLatitude());
                pst.setDouble(3, pf.getLongitude());

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected != 1) {
                    throw new Exception("L'insertion a échoué pour les données : " + pf);
                }
            }

            System.out.println("Modification effectuée");

        } catch (Exception e) {
            throw new Exception("Erreur lors de l'insertion des données : " + e.getMessage());
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (co == 1) {
                con.close();
            }
        }
    }
    
    public static void updateSomme(Connection con, double somme,int id1) throws Exception {
        try{
            Banque data = new Banque(15,123456789,45121.2);
            Properties props2 = new Properties();
            props2.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            props2.setProperty("org.omg.CORBA.ORBInitialPort", "1234");
            InitialContext ctx2 = new InitialContext(props2);
            session_bean_banque_remoteRemote session_bean_banque = (session_bean_banque_remoteRemote) ctx2.lookup("java:global/EJBModuleBanque/session_bean_banque_remote!project_banque.session_bean_banque_remoteRemote");
            
            session_bean_banque.update_somme(somme, id1);
        }catch(Exception e){
            System.out.println("erreur dans updateSomme : " + e.getMessage());
        }
        
    }
    
    public static double getPrice(Connection con, int id) throws Exception {
        double compte = 0.0;
        try{
            Banque data = new Banque(15,123456789,45121.2);
            Properties props2 = new Properties();
            props2.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            props2.setProperty("org.omg.CORBA.ORBInitialPort", "1234");
            InitialContext ctx2 = new InitialContext(props2);
            session_bean_banque_remoteRemote session_bean_banque = (session_bean_banque_remoteRemote) ctx2.lookup("java:global/EJBModuleBanque/session_bean_banque_remote!project_banque.session_bean_banque_remoteRemote");
            
            //session_bean_banque.new_banque(data);
            compte = session_bean_banque.check_sold(id);
        
        }catch(Exception e){
            e.getMessage();
        }
        return compte;
    }
    
}
