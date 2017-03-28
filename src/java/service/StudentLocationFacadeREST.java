/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import MFFRest.Student;
import MFFRest.StudentFriendRelation;
import MFFRest.StudentLocation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
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
@Path("mffrest.studentlocation")
public class StudentLocationFacadeREST extends AbstractFacade<StudentLocation> {

    @PersistenceContext(unitName = "MFFPU")
    private EntityManager em;

    public StudentLocationFacadeREST() {
        super(StudentLocation.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(StudentLocation entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, StudentLocation entity) {
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
    public StudentLocation find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentLocation> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentLocation> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
    @GET 
    @Path("findByLocationId/{locationId}")     
    @Produces({"application/json"})  
    public List<StudentLocation> findByLocationId(@PathParam("locationId") String locationId) {         
        Query query = em.createNamedQuery("StudentLocation.findByLocationId");         
        query.setParameter("locationId", locationId);
        return query.getResultList();
    }
    
    @GET 
    @Path("findByLatitude/{latitude}")     
    @Produces({"application/json"})  
    public List<StudentLocation> findByLatitude(@PathParam("latitude") String latitude) {         
        Query query = em.createNamedQuery("StudentLocation.findByLatitude");         
        query.setParameter("latitude", latitude);
        return query.getResultList();
    }
    
    @GET 
    @Path("findByLongtitude/{longtitude}")     
    @Produces({"application/json"})  
    public List<StudentLocation> findByLongtitude(@PathParam("longtitude") String longtitude) {         
        Query query = em.createNamedQuery("StudentLocation.findByLongtitude");         
        query.setParameter("longtitude", longtitude);
        return query.getResultList();
    }
    
    @GET 
    @Path("findByLocationName/{locationName}")     
    @Produces({"application/json"})  
    public List<StudentLocation> findByLocationName(@PathParam("locationName") String locationName) {         
        Query query = em.createNamedQuery("StudentLocation.findByLocationName");         
        query.setParameter("locationName", locationName);
        return query.getResultList();
    }
    
    @GET 
    @Path("findByRecordDate/{recordDate}")     
    @Produces({"application/json"})  
    public List<StudentLocation> findByRecordDate(@PathParam("recordDate") String recordDate) {         
        Query query = em.createNamedQuery("StudentLocation.findByRecordDate");         
        query.setParameter("recordDate", recordDate);
        return query.getResultList();
    }
    
    @GET 
    @Path("findByRecordTime/{recordTime}")
    @Produces({"application/json"})
    public List<StudentLocation> findByRecordTime(@PathParam("recordTime") String recordTime) {         
        Query query = em.createNamedQuery("StudentLocation.findByRecordTime");         
        query.setParameter("recordTime", recordTime);
        return query.getResultList();
    }
    
//    Task2 b) 4) Static Query
//    @GET
//    @Path("findByAnyAtLeastTwoAttributeInTwoTables2/{columnName1}/{columnName2}/{attribute1}/{attribute2}")     
//    @Produces({"application/json"})  
//    public List<StudentFriendRelation> findByAnyAtLeastTwoAttributeInTwoTables2(@PathParam("columnName1")String columnName1, @PathParam("columnName2")String columnName2, @PathParam("attribute1") String attribute1, @PathParam("attribute2") String attribute2) {
//        Query q = em.createQuery("StudentFriendRelation.findByAnyAtLeastTwoAttributeInTwoTables2");
//        
//        q.setParameter("columnName1", columnName1);
//        q.setParameter("columnName2", columnName2);
//        q.setParameter("attribute1", attribute1);
//        q.setParameter("attribute2", attribute2);
//        return q.getResultList();
//    }

    
//    Task3 a) 
//    Dynamic, find record in time range
    @GET 
    @Path("findrecordByStartAndEnd/{startingDate}/{endingDate}/{sid}")     
    @Produces({"application/json"})  
    public List<StudentLocation> findrecordByStartAndEnd(@PathParam("startingDate") String startingDate, @PathParam("endingDate") String endingDate, @PathParam("sid") Integer sid) {   
        String queryString = "SELECT s FROM StudentLocation s WHERE s.recordDate < :endingDate AND s.recordDate > :startingDate AND s.sid.sid = :sid";
        TypedQuery<StudentLocation> query = em.createQuery(queryString, StudentLocation.class);         
        
        query.setParameter("startingDate", startingDate);
        query.setParameter("endingDate", endingDate);
        query.setParameter("sid", sid);
        return query.getResultList();
    }
    
//Task 3 b)
//Dynamic, find friend nearby using latitude and longtitude
    @GET 
    @Path("findNearByFriends/{latitude}/{longtitude}/{sid}")     
    @Produces({"application/json"})  
    public List<StudentLocation> findNearByFriends(@PathParam("latitude") String latitude, @PathParam("longtitude") String longtitude, @PathParam("sid") Integer sid) {   
        //Get list of other students
        String queryString = "SELECT s FROM StudentLocation s WHERE s.sid != :sid";
        TypedQuery<StudentLocation> query = em.createQuery(queryString, StudentLocation.class);
        List<StudentLocation> resultQuery =  query.getResultList();
        
        //Get the student from the sid we input
        String queryString2 = "SELECT s FROM StudentLocation s WHERE s.sid = :sid";
        TypedQuery<StudentLocation> query2 = em.createQuery(queryString2, StudentLocation.class);
        StudentLocation targetStudentRecord = query2.getSingleResult();
        
        double distance = 0.0;
        HashMap<Integer, Double> computeResult = new HashMap<>();
        
        for (StudentLocation sl : resultQuery){
            double latitude1 = Double.parseDouble(sl.getLatitude());
            double longtitude1 = Double.parseDouble(sl.getLongtitude());
            double latitude2 = Double.parseDouble(targetStudentRecord.getLatitude());
            double longtitude2 = Double.parseDouble(targetStudentRecord.getLongtitude());
            distance = Utility.computeDistance(latitude1, longtitude1, latitude2, longtitude2);
            //String distanceString = "" + distance;
            computeResult.put(sl.getSid().getSid(), distance);
        }
        //Sort the HashMap
        computeResult = Utility.sortHashMapByValues(computeResult);
        List<StudentLocation> resultList;
        HashMap.Entry<Integer, Double> entry = computeResult.entrySet().iterator().next();
        int temp = entry.getKey();
//        resultList.add()
        
        
//        for (int i = 0; i < 11 ; i++){
//            resultList = computeResult.
//        }
        
        query.setParameter("sid", sid);
        query2.setParameter("sid", sid);
        return query.getResultList();
    }
    
//Task 3 c)
//Find stuents using three attributes as criteria.
//    @GET 
//    @Path("findFriendsUsingThreeCommonAttributes/{mainKey}/{keyword1}/{keyword2}/{keyword3}")     
//    @Produces({"application/json"})  
//    public List<Student> findFriendsUsingThreeCommonAttributes(@PathParam("mainKey") String mainKey, @PathParam("keyword1") String keyword1, @PathParam("keyword2") String keyword2, @PathParam("keyword3") String keyword3){
//        String queryString = "SELECT s FROM StudentLocation s WHERE s.sid = :mainKey OR s.fName = :mainKey OR s.sid = :mainKey AND ()" ;
//        TypedQuery<StudentLocation> query = em.createQuery(queryString, StudentLocation.class);
//        List<StudentLocation> resultQuery =  query.getResultList();
//    } 
    
//    Task 3 d)
//    Updated Version of 3c) that accept any number of attributes
    
//    Task 3 e)
//    Get favourite Units and their frequency
//    @GET 
//    @Path("findPopularUnit/{locationName}")     
//    @Produces({"application/json"})  
//    public List<String> findPopularUnit(@PathParam("locationName") String locationName) { 
//        String queryString = "SELECT s FROM Student";
//        TypedQuery<Student> query = em.createQuery(queryString, Student.class);
//        List<Student> resultQuery =  query.getResultList();
//    }
}
