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

import restfulwebservice.DAO.StudentLoansDAO;
import restfulwebservice.model.StudentLoans;

 
@Path("/studentLoanLoans")
public class StudentLoansService {
 
    // URI:
    // /contextPath/servletPath/studentLoanLoans
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getStudentLoanss_JSON() {
        List<StudentLoans> list = StudentLoansDAO.getStudentLoans();
        if(list == null){
        	return Response.status(200).entity(null).build();
        }
        GenericEntity<List<StudentLoans>> entity = new GenericEntity<List<StudentLoans>>( list){};
        return Response.status(201).entity(entity).build();
    }
 
    // URI:
    // /contextPath/servletPath/studentLoanLoans/{studentLoanNo}
    @GET
    @Path("/{studentLoanNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getStudentLoans(@PathParam("studentLoanNo") String studentLoanNo) {
    	StudentLoans studentLoan = StudentLoansDAO.getStudentLoansById(studentLoanNo);
    	if (studentLoan == null){
    		return Response.status(200).entity(null).build();
    	}
    	return Response.status(201).entity(studentLoan).build();
    }
    
    // URI:
    // /contextPath/servletPath/studentLoanLoans
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addStudentLoansThuocTinh( StudentLoans studentLoan) {
        int result = StudentLoansDAO.addStudentLoans(studentLoan);
        if (result < 0){
        	return Response.status(200).entity(null).build();
        }
        return Response.status(201).entity(studentLoan).build();
    }
    
//     URI:
//     /contextPath/servletPath/studentLoanLoans
    @PUT
    @Path("/{studentLoanNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateStudentLoans(StudentLoans studentLoan) {
        Boolean result = StudentLoansDAO.updateStudentLoans(studentLoan);
        
        if (result){
        	return Response.status(200).entity(studentLoan).build();
        }
        return Response.status(200).entity(null).build();
    }
 
    @DELETE
    @Path("/{studentLoanNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteStudentLoans(@PathParam("studentLoanNo") String studentLoan) {
        boolean result = StudentLoansDAO.deleteStudentLoans(studentLoan);
        if (result){
        	return Response.status(200).entity(true).build();
        }
        return Response.status(200).entity(false).build();
    }
 
}