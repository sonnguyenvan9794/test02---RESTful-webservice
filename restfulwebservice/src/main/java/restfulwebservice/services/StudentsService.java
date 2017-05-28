package restfulwebservice.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import restfulwebservice.DAO.StudentsDAO;
import restfulwebservice.model.Students;

 
@Path("/students")
public class StudentsService {
 
    // URI:
    // /contextPath/servletPath/students
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getStudentss_JSON() {
        List<Students> list = StudentsDAO.getStudents();
        if(list == null){
        	return Response.status(200).entity(null).build();
        }
        GenericEntity<List<Students>> entity = new GenericEntity<List<Students>>( list){};
        return Response.status(201).entity(entity).build();
    }
 
    // URI:
    // /contextPath/servletPath/students/{stuNo}
    @GET
    @Path("/{stuNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getStudents(@PathParam("stuNo") int stuNo) {
    	Students student = StudentsDAO.getStudentsById(stuNo);
    	if (student == null){
    		return Response.status(200).entity(null).build();
    	}
    	return Response.status(201).entity(student).build();
    }
    
    // URI:
    // /contextPath/servletPath/students
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addStudentsThuocTinh( Students student) {
        int result = StudentsDAO.addStudents(student);
        if (result < 0){
        	return Response.status(200).entity(null).build();
        }
        return Response.status(201).entity(student).build();
    }
    
//     URI:
//     /contextPath/servletPath/students
    @PUT
    @Path("/{stuNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateStudents(Students student) {
        Boolean result = StudentsDAO.updateStudents(student);
        
        if (result){
        	return Response.status(200).entity(student).build();
        }
        return Response.status(200).entity(null).build();
    }
 
    @DELETE
    @Path("/{stuNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteStudents(@PathParam("stuNo") int student) {
        boolean result = StudentsDAO.deleteStudents(student);
        if (result){
        	return Response.status(200).entity(true).build();
        }
        return Response.status(200).entity(false).build();
    }
 
}