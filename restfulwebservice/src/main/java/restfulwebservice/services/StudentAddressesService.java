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

import restfulwebservice.DAO.StudentAddressesDAO;
import restfulwebservice.model.StudentAddresses;

 
@Path("/studentAddressAddresses")
public class StudentAddressesService {
 
    // URI:
    // /contextPath/servletPath/studentAddressAddresses
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getStudentAddressess_JSON() {
        List<StudentAddresses> list = StudentAddressesDAO.getStudentAddresses();
        if(list == null){
        	return Response.status(200).entity(null).build();
        }
        GenericEntity<List<StudentAddresses>> entity = new GenericEntity<List<StudentAddresses>>( list){};
        return Response.status(201).entity(entity).build();
    }
 
    // URI:
    // /contextPath/servletPath/studentAddressAddresses/{studentAddressNo}
    @GET
    @Path("/{studentAddressNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getStudentAddresses(@PathParam("studentAddressNo") String studentAddressNo) {
    	StudentAddresses studentAddress = StudentAddressesDAO.getStudentAddressesById(studentAddressNo);
    	if (studentAddress == null){
    		return Response.status(200).entity(null).build();
    	}
    	return Response.status(201).entity(studentAddress).build();
    }
    
    // URI:
    // /contextPath/servletPath/studentAddressAddresses
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addStudentAddressesThuocTinh( StudentAddresses studentAddress) {
        int result = StudentAddressesDAO.addStudentAddresses(studentAddress);
        if (result < 0){
        	return Response.status(200).entity(null).build();
        }
        return Response.status(201).entity(studentAddress).build();
    }
    
//     URI:
//     /contextPath/servletPath/studentAddressAddresses
    @PUT
    @Path("/{studentAddressNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateStudentAddresses(StudentAddresses studentAddress) {
        Boolean result = StudentAddressesDAO.updateStudentAddresses(studentAddress);
        
        if (result){
        	return Response.status(200).entity(studentAddress).build();
        }
        return Response.status(200).entity(null).build();
    }
 
    @DELETE
    @Path("/{studentAddressNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteStudentAddresses(@PathParam("studentAddressNo") String studentAddress) {
        boolean result = StudentAddressesDAO.deleteStudentAddresses(studentAddress);
        if (result){
        	return Response.status(200).entity(true).build();
        }
        return Response.status(200).entity(false).build();
    }
 
}