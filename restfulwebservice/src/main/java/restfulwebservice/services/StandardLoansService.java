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

import restfulwebservice.DAO.StandardLoansDAO;
import restfulwebservice.model.StandardLoans;

 
@Path("/standardLoans")
public class StandardLoansService {
 
    // URI:
    // /contextPath/servletPath/standardLoans
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getStandardLoanss_JSON() {
        List<StandardLoans> list = StandardLoansDAO.getStandardLoans();
        if(list == null){
        	return Response.status(200).entity(null).build();
        }
        GenericEntity<List<StandardLoans>> entity = new GenericEntity<List<StandardLoans>>( list){};
        return Response.status(201).entity(entity).build();
    }
 
    // URI:
    // /contextPath/servletPath/standardLoans/{standardLoanNo}
    @GET
    @Path("/{standardLoanNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getStandardLoans(@PathParam("standardLoanNo") String standardLoanNo) {
    	StandardLoans standardLoan = StandardLoansDAO.getStandardLoansById(standardLoanNo);
    	if (standardLoan == null){
    		return Response.status(200).entity(null).build();
    	}
    	return Response.status(201).entity(standardLoan).build();
    }
    
    // URI:
    // /contextPath/servletPath/standardLoans
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addStandardLoansThuocTinh( StandardLoans standardLoan) {
        int result = StandardLoansDAO.addStandardLoans(standardLoan);
        if (result < 0){
        	return Response.status(200).entity(null).build();
        }
        return Response.status(201).entity(standardLoan).build();
    }
    
//     URI:
//     /contextPath/servletPath/standardLoans
    @PUT
    @Path("/{standardLoanNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateStandardLoans(StandardLoans standardLoan) {
        Boolean result = StandardLoansDAO.updateStandardLoans(standardLoan);
        
        if (result){
        	return Response.status(200).entity(standardLoan).build();
        }
        return Response.status(200).entity(null).build();
    }
 
    @DELETE
    @Path("/{standardLoanNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteStandardLoans(@PathParam("standardLoanNo") String standardLoan) {
        boolean result = StandardLoansDAO.deleteStandardLoans(standardLoan);
        if (result){
        	return Response.status(200).entity(true).build();
        }
        return Response.status(200).entity(false).build();
    }
 
}