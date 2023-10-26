/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package service_foncier;

import DTO_Banque.Banque;
import DTO_Bien.Bien;
import DTO_Devise.Devise;
import DTO_Foncier.AllFoncier;
import DTO_Foncier.Foncier;
import DTO_Foncier.Geom_foncier;
import DTO_Foncier.Plus_foncier;
import DTO_Transaction.Transaction;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import project_banque.session_bean_banque_remoteRemote;
import response.ResponseData;
import session_bean_remote.NewSessionBeanRemoteRemote;

/**
 * REST Web Service
 *
 * @author 26134
 */
@Path("generic")
@RequestScoped
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of service_foncier.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/invokeall/{id}")
    public String getJson(@PathParam("id") int id) {
        
        Gson gson = new Gson();
        ArrayList<Foncier> listes_foncier = null;
        ArrayList<Banque> listes_banques = null;
        CombinedData combinedData = null;
        try{
                Properties props1 = new Properties();
                props1.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
                props1.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
                InitialContext ctx1 = new InitialContext(props1);
                NewSessionBeanRemoteRemote new_session_bean_remote = (NewSessionBeanRemoteRemote) ctx1.lookup("java:global/EJBModule1/NewSessionBeanRemote!session_bean_remote.NewSessionBeanRemoteRemote");
                
                listes_foncier = (ArrayList<Foncier>)new_session_bean_remote.all_foncier();
                ArrayList<Devise> dev = new_session_bean_remote.devises();
                
                Properties props2 = new Properties();
                props2.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
                props2.setProperty("org.omg.CORBA.ORBInitialPort", "1234");
                InitialContext ctx2 = new InitialContext(props2);
                session_bean_banque_remoteRemote session_bean_banque = (session_bean_banque_remoteRemote) ctx2.lookup("java:global/EJBModuleBanque/session_bean_banque_remote!project_banque.session_bean_banque_remoteRemote");
                
                listes_banques = (ArrayList<Banque>)session_bean_banque.banque(id);
                
                combinedData = new CombinedData(listes_foncier, listes_banques, dev);
                
            }catch(Exception e){
                System.out.println("erreur");
                System.out.println(e.getMessage());
            }
        return gson.toJson(combinedData);
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/fonciers")
    public String getJsonFoncier() {
        
        Gson gson = new Gson();
        ArrayList<Foncier> listes_foncier = null;
        ArrayList<Plus_foncier> all_listes_foncier = null;
        ArrayList<Geom_foncier> listes_geom = null;
        ArrayList<Banque> listes_banques = null;
        CombinedData combinedData = null;
        try{
                Properties props1 = new Properties();
                props1.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
                props1.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
                InitialContext ctx1 = new InitialContext(props1);
                NewSessionBeanRemoteRemote new_session_bean_remote = (NewSessionBeanRemoteRemote) ctx1.lookup("java:global/EJBModule1/NewSessionBeanRemote!session_bean_remote.NewSessionBeanRemoteRemote");
                
                all_listes_foncier = (ArrayList<Plus_foncier>)new_session_bean_remote.all_plus_foncier();                
            }catch(Exception e){
                System.out.println("erreur");
                System.out.println(e.getMessage());
            }
        return gson.toJson(all_listes_foncier);
    }
    
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/foncier/{id}")
    public String getJsonFoncier(@PathParam("id") int id) {
        
        Gson gson = new Gson();
        ArrayList<Foncier> listes_foncier = null;
        ArrayList<Geom_foncier> listes_geom = null;
        ArrayList<Banque> listes_banques = null;
        CombinedData combinedData = null;
        try{
                Properties props1 = new Properties();
                props1.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
                props1.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
                InitialContext ctx1 = new InitialContext(props1);
                NewSessionBeanRemoteRemote new_session_bean_remote = (NewSessionBeanRemoteRemote) ctx1.lookup("java:global/EJBModule1/NewSessionBeanRemote!session_bean_remote.NewSessionBeanRemoteRemote");
                
                listes_foncier = (ArrayList<Foncier>)new_session_bean_remote.foncierById(id);
                //listes_geom = (ArrayList<Geom_foncier>)new_session_bean_remote.foncier(1);
                //ArrayList<Devise> dev = new_session_bean_remote.devises();
                
                /*Properties props2 = new Properties();
                props2.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
                props2.setProperty("org.omg.CORBA.ORBInitialPort", "1234");
                InitialContext ctx2 = new InitialContext(props2);
                session_bean_banque_remoteRemote session_bean_banque = (session_bean_banque_remoteRemote) ctx2.lookup("java:global/EJBModuleBanque/session_bean_banque_remote!project_banque.session_bean_banque_remoteRemote");
                
                listes_banques = (ArrayList<Banque>)session_bean_banque.banque(id);*/
                
                //combinedData = new CombinedData(listes_foncier, listes_geom);
                
            }catch(Exception e){
                System.out.println("erreur");
                System.out.println(e.getMessage());
            }
        return gson.toJson(listes_foncier);
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/foncier/plus/{id}")
    public String getJsonFoncierPlus(@PathParam("id") int id) {
        
        Gson gson = new Gson();
        ArrayList<Foncier> listes_foncier = null;
        ArrayList<Geom_foncier> listes_geom = null;
        ArrayList<Plus_foncier> listes_geom_plus = null;
        ArrayList<Banque> listes_banques = null;
        CombinedData2 combinedData2 = null;
        try{
                Properties props1 = new Properties();
                props1.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
                props1.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
                InitialContext ctx1 = new InitialContext(props1);
                NewSessionBeanRemoteRemote new_session_bean_remote = (NewSessionBeanRemoteRemote) ctx1.lookup("java:global/EJBModule1/NewSessionBeanRemote!session_bean_remote.NewSessionBeanRemoteRemote");
                
                //listes_foncier = (ArrayList<Foncier>)new_session_bean_remote.foncierById(id);
                listes_geom_plus = (ArrayList<Plus_foncier>)new_session_bean_remote.plus_foncier(id);
                //listes_geom = (ArrayList<Geom_foncier>)new_session_bean_remote.foncier(id);
                //ArrayList<Devise> dev = new_session_bean_remote.devises();
                
                /*Properties props2 = new Properties();
                props2.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
                props2.setProperty("org.omg.CORBA.ORBInitialPort", "1234");
                InitialContext ctx2 = new InitialContext(props2);
                session_bean_banque_remoteRemote session_bean_banque = (session_bean_banque_remoteRemote) ctx2.lookup("java:global/EJBModuleBanque/session_bean_banque_remote!project_banque.session_bean_banque_remoteRemote");
                
                listes_banques = (ArrayList<Banque>)session_bean_banque.banque(id);*/
                
                //combinedData2 = new CombinedData2(listes_geom,listes_geom_plus);
                
            }catch(Exception e){
                System.out.println("erreur");
                System.out.println(e.getMessage());
            }
        return gson.toJson(listes_geom_plus);
    }
    

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/parcelle")
    public String newParcelle(String jsonData) {
        Gson gson = new Gson();
        System.out.println(jsonData);
        AllFoncier insertData = gson.fromJson(jsonData, AllFoncier.class);

        // Vous pouvez accéder aux données de insertData ici
        System.out.println("PlusFoncier : " + insertData.getPlusFoncier().toString());
        System.out.println("Foncier : " + insertData.getFoncier().toString());
        //System.out.println(gson.toJson(insertData));
        //System.out.println(gson.toJson(insertData.getPlusFoncier()) + " et " + gson.toJson(insertData.getFoncier()));
        try {
            Properties props1 = new Properties();
                props1.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
                props1.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
                InitialContext ctx1 = new InitialContext(props1);
                NewSessionBeanRemoteRemote new_session_bean_remote = (NewSessionBeanRemoteRemote) ctx1.lookup("java:global/EJBModule1/NewSessionBeanRemote!session_bean_remote.NewSessionBeanRemoteRemote");
            
            new_session_bean_remote.new_foncier(insertData.getPlusFoncier(), insertData.getFoncier());

            ResponseData responseData = new ResponseData("Insertion réussie");
            return gson.toJson(responseData);
        } catch (Exception e) {
            System.out.println("Erreur d'insertion");
            System.out.println(e.getMessage());
            ResponseData responseData = new ResponseData("Erreur d'insertion : " + e.getMessage());
            return gson.toJson(responseData);
        }
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/transaction")
    public String postData(Transaction insertData) {
        Gson gson = new Gson();
        System.out.println(insertData.getSomme() + " et " + insertData.getVente());
        try {
            // Insérez ici la logique d'insertion des données en utilisant insertData

            // Exemple de connexion à une session distante
            Properties props2 = new Properties();
            props2.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            props2.setProperty("org.omg.CORBA.ORBInitialPort", "1234");
            InitialContext ctx2 = new InitialContext(props2);
            session_bean_banque_remoteRemote session_bean_banque = (session_bean_banque_remoteRemote) ctx2.lookup("java:global/EJBModuleBanque/session_bean_banque_remote!project_banque.session_bean_banque_remoteRemote");
            
            session_bean_banque.make_transaction(insertData.getDepositaire(), insertData.getDestinataire(), insertData.getSomme(), insertData.getVente());

            // Exemple de réponse JSON
            ResponseData responseData = new ResponseData("Insertion réussie");
            return gson.toJson(responseData);
        } catch (Exception e) {
            System.out.println("Erreur d'insertion");
            System.out.println(e.getMessage());
            ResponseData responseData = new ResponseData("Erreur d'insertion : " + e.getMessage());
            return gson.toJson(responseData);
        }
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/sell")
    public String postData2(Bien insertData) {
        Gson gson = new Gson();
         try {
            // Exemple de connexion à une session distante
            Properties props = new Properties();
                props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
                props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
                InitialContext ctx = new InitialContext(props);
                NewSessionBeanRemoteRemote new_session_bean_remote = (NewSessionBeanRemoteRemote) ctx.lookup("java:global/EJBModule1/NewSessionBeanRemote!session_bean_remote.NewSessionBeanRemoteRemote");
                
            new_session_bean_remote.sell(insertData.getVendeur(), insertData.getAcheteur(), insertData.getPartielle());
            // Exemple de réponse JSON
            ResponseData responseData = new ResponseData("Insertion réussie");
            return gson.toJson(responseData);
        } catch (Exception e) {
            System.out.println("Erreur d'insertion");
            System.out.println(e.getMessage());
            ResponseData responseData = new ResponseData("Erreur d'insertion : " + e.getMessage());
            return gson.toJson(responseData);
        }
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/sellpart")
    public String postData3(Bien insertData) {
        Gson gson = new Gson();
         try {
            // Exemple de connexion à une session distante
            Properties props = new Properties();
                props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
                props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
                InitialContext ctx = new InitialContext(props);
                NewSessionBeanRemoteRemote new_session_bean_remote = (NewSessionBeanRemoteRemote) ctx.lookup("java:global/EJBModule1/NewSessionBeanRemote!session_bean_remote.NewSessionBeanRemoteRemote");
                
            //new_session_bean_remote.sell_part(insertData.getVendeur(), insertData.getAcheteur(), insertData.getPartielle(), insertData.getSurface());
            // Exemple de réponse JSON
            ResponseData responseData = new ResponseData("Insertion réussie");
            return gson.toJson(responseData);
        } catch (Exception e) {
            System.out.println("Erreur d'insertion");
            System.out.println(e.getMessage());
            ResponseData responseData = new ResponseData("Erreur d'insertion : " + e.getMessage());
            return gson.toJson(responseData);
        }
    }
    

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    private class CombinedData {
        private ArrayList<Foncier> foncierData;
        private ArrayList<Banque> banqueData;
        private ArrayList<Devise> deviseData;
        private ArrayList<Geom_foncier> geomData;
        private ArrayList<Plus_foncier> plusData;

        public CombinedData(ArrayList<Foncier> foncier, ArrayList<Banque> banque, ArrayList<Devise> devise) {
            this.foncierData = foncier;
            this.banqueData = banque;
            this.deviseData = devise;
        }

        public CombinedData(ArrayList<Foncier> foncierData, ArrayList<Geom_foncier> geom_foncier) {
            this.foncierData = foncierData;
            this.geomData = geom_foncier;
        }
       
    }
    
    private class CombinedData2 {
        private ArrayList<Geom_foncier> geomData;
        private ArrayList<Plus_foncier> plusData;
        
         public CombinedData2(ArrayList<Geom_foncier> geomData, ArrayList<Plus_foncier> plusData){
            this.geomData = geomData;
            this.plusData = plusData;
        }
    }
}
