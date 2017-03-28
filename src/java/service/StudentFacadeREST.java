/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import MFFRest.Student;
import MFFRest.StudentFriendRelation;
import MFFRest.StudentLocation;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Richard's Surface
 */
@Stateless
@Path("mffrest.student")
public class StudentFacadeREST extends AbstractFacade<Student> {

    @PersistenceContext(unitName = "MFFPU")
    private EntityManager em;

    public StudentFacadeREST() {
        super(Student.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Student entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Student entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Student find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Student> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Student> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    //GET method below
    
    @GET 
    @Path("findByFName/{fName}")     
    @Produces({"application/json"})  
    public List<Student> findByFName(@PathParam("fName") String fName) {         
        Query query = em.createNamedQuery("Student.findByFName");         
        query.setParameter("fName", fName);
        return query.getResultList();
    }
    
    @GET 
    @Path("findByLName/{lName}")     
    @Produces({"application/json"})  
    public List<Student> findByLName(@PathParam("lName") String lName) {         
        Query query = em.createNamedQuery("Student.findByLName");         
        query.setParameter("lName", lName);
        return query.getResultList();
    }
    
    @GET 
    @Path("findByDob/{dob}")     
    @Produces({"application/json"})  
    public List<Student> findByDob(@PathParam("dob") String dob) {         
        Query query = em.createNamedQuery("Student.findByDob");         
        query.setParameter("dob", dob);
        return query.getResultList();
    }
    
    @GET 
    @Path("findByGender/{gender}")     
    @Produces({"application/json"})  
    public List<Student> findByGender(@PathParam("gender") String gender) {         
        Query query = em.createNamedQuery("Student.findByGender");         
        query.setParameter("gender", gender);
        return query.getResultList();
    }
    
    @GET 
    @Path("findByStudyMode/{studyMode}")     
    @Produces({"application/json"})  
    public List<Student> findByStudyMode(@PathParam("studyMode") String studyMode) {         
        Query query = em.createNamedQuery("Student.findByStudyMode");         
        query.setParameter("studyMode", studyMode);
        return query.getResultList();
    }
    
    @GET 
    @Path("findByCourse/{course}")     
    @Produces({"application/json"})  
    public List<Student> findByCourse(@PathParam("course") String course) {         
        Query query = em.createNamedQuery("Student.findByCourse");         
        query.setParameter("course", course);
        return query.getResultList();
    }
    
    @GET 
    @Path("findByAddress/{address}")     
    @Produces({"application/json"})  
    public List<Student> findByAddress(@PathParam("address") String address) {         
        Query query = em.createNamedQuery("Student.findByAddress");         
        query.setParameter("address", address);
        return query.getResultList();
    }
    
    @GET 
    @Path("findBySubrub/{subrub}")     
    @Produces({"application/json"})  
    public List<Student> findBySubrub(@PathParam("subrub") String subrub) {         
        Query query = em.createNamedQuery("Student.findBySubrub");         
        query.setParameter("subrub", subrub);
        return query.getResultList();
    }
    
    @GET 
    @Path("findByNationality/{nationality}")     
    @Produces({"application/json"})  
    public List<Student> findByNationality(@PathParam("nationality") String nationality) {         
        Query query = em.createNamedQuery("Student.findByNationality");         
        query.setParameter("nationality", nationality);
        return query.getResultList();
    }
    
    @GET 
    @Path("findByNativeLanguage/{nativeLanguage}")     
    @Produces({"application/json"})  
    public List<Student> findByNativeLanguage(@PathParam("nativeLanguage") String nativeLanguage) {         
        Query query = em.createNamedQuery("Student.findByNativeLanguage");         
        query.setParameter("nativeLanguage", nativeLanguage);
        return query.getResultList();
    }
    
    @GET 
    @Path("findByFavouriteSport/{favouriteSport}")     
    @Produces({"application/json"})  
    public List<Student> findByFavouriteSport(@PathParam("favouriteSport") String favouriteSport) {         
        Query query = em.createNamedQuery("Student.findByFavouriteSport");         
        query.setParameter("favouriteSport", favouriteSport);
        return query.getResultList();
    }
    
    @GET 
    @Path("findByFavouriteMovie/{favouriteMovie}")     
    @Produces({"application/json"})  
    public List<Student> findByFavouriteMovie(@PathParam("favouriteMovie") String favouriteMovie) {         
        Query query = em.createNamedQuery("Student.findByFavouriteMovie");         
        query.setParameter("favouriteMovie", favouriteMovie);
        return query.getResultList();
    }
    
    @GET 
    @Path("findByFavouriteUnit/{favouriteUnit}")     
    @Produces({"application/json"})  
    public List<Student> findByFavouriteUnit(@PathParam("favouriteUnit") String favouriteUnit) {         
        Query query = em.createNamedQuery("Student.findByFavouriteUnit");         
        query.setParameter("favouriteUnit", favouriteUnit);
        return query.getResultList();
    }
    
    @GET 
    @Path("findByCurrentJob/{currentJob}")     
    @Produces({"application/json"})  
    public List<Student> findByCurrentJob(@PathParam("currentJob") String currentJob) {         
        Query query = em.createNamedQuery("Student.findByCurrentJob");         
        query.setParameter("currentJob", currentJob);
        return query.getResultList();
    }
    
    @GET 
    @Path("findByMonashEmail/{monashEmail}")     
    @Produces({"application/json"})  
    public List<Student> findByMonashEmail(@PathParam("monashEmail") String monashEmail) {         
        Query query = em.createNamedQuery("Student.findByMonashEmail");         
        query.setParameter("monashEmail", monashEmail);
        return query.getResultList();
    }
    
    @GET 
    @Path("findByPassword/{password}")     
    @Produces({"application/json"})  
    public List<Student> findByPassword(@PathParam("password") String password) {         
        Query query = em.createNamedQuery("Student.findByPassword");         
        query.setParameter("password", password);
        return query.getResultList();
    }
    
    @GET 
    @Path("findBySubscriptionDate/{subscriptionDate}")     
    @Produces({"application/json"})  
    public List<Student> findBySubscriptionDate(@PathParam("subscriptionDate") String subscriptionDate) {         
        Query query = em.createNamedQuery("Student.findBySubscriptionDate");         
        query.setParameter("subscriptionDate", subscriptionDate);
        return query.getResultList();
    }
    
    @GET 
    @Path("findBySubscriptionTime/{subscriptionTime}")     
    @Produces({"application/json"})  
    public List<Student> findBySubscriptionTime(@PathParam("subscriptionTime") String subscriptionTime) {         
        Query query = em.createNamedQuery("Student.findBySubscriptionTime");         
        query.setParameter("subscriptionTime", subscriptionTime);
        return query.getResultList();
    }
    
    //Dynamic Query
    //Task2 b) 2)
    @GET 
    @Path("findByAnyTwoAttribute/{columnName1}/{columnName2}/{attribute1}/{attribute2}")     
    @Produces({"application/json"})  
    public List<Student> findByAnyTwoAttribute(@PathParam("columnName1")String columnName1, @PathParam("columnName2")String columnName2, @PathParam("attribute1") String attribute1, @PathParam("attribute2") String attribute2) {
        //How to find the attribute we need?
        String joinQuery = "SELECT s FROM Student s WHERE s." + columnName1 + " = :attribute1 AND s." + columnName2 + " = :attribute2";
        TypedQuery<Student> q = em.createQuery(joinQuery, Student.class);
        
        //q.setParameter("columnName1", columnName1);
        //q.setParameter("columnName2", columnName2);
        q.setParameter("attribute1", attribute1);
        q.setParameter("attribute2", attribute2);
        return q.getResultList();
    }
    
    //Dynamic Query
    //Task2 b) 3)
    @GET
    @Path("findByAnyAtLeastTwoAttributeInTwoTables/{columnName1}/{columnName2}/{attribute1}/{attribute2}")     
    @Produces({"application/json"})  
    public List<StudentLocation> findByAnyAtLeastTwoAttributeInTwoTables(@PathParam("columnName1")String columnName1, @PathParam("columnName2")String columnName2, @PathParam("attribute1") String attribute1, @PathParam("attribute2") String attribute2) {
        String joinQuery = "SELECT s FROM StudentLocation s WHERE s." + columnName1 + " = :attribute1 AND s.sid." + columnName2 + " = :attribute2";
//        String joinQuery = "SELECT s FROM StudentLocation s WHERE s.:columnName1 = :attribute1 AND s.sid.:columnName2 = :attribute2";
        TypedQuery<StudentLocation> q = em.createQuery(joinQuery, StudentLocation.class);
        
        //q.setParameter("columnName1", columnName1);
        //q.setParameter("columnName2", columnName2);
        q.setParameter("attribute1", attribute1);
        q.setParameter("attribute2", attribute2);
        return q.getResultList();
    }
    
//    Task2 b) 4) Static Query
//    @GET
//    @Path("findByAnyAtLeastTwoAttributeInTwoTables2/{columnName1}/{columnName2}/{attribute1}/{attribute2}")     
//    @Produces({"application/json"})  
//    public List<StudentFriendRelation> findByAnyAtLeastTwoAttributeInTwoTables2(@PathParam("columnName1")String columnName1, @PathParam("columnName2")String columnName2, @PathParam("attribute1") String attribute1, @PathParam("attribute2") String attribute2) {
//        Query q = em.createNamedQuery("StudentFriendRelation.findByAnyAtLeastTwoAttributeInTwoTables2");
//        
//        q.setParameter("columnName1", columnName1);
//        q.setParameter("columnName2", columnName2);
//        q.setParameter("attribute1", attribute1);
//        q.setParameter("attribute2", attribute2);
//        return q.getResultList();
//    }
}
