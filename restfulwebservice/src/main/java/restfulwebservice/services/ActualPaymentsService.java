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

import restfulwebservice.DAO.ActualPaymentsDAO;
import restfulwebservice.model.ActualPayments;

 
@Path("/actualPaymentss")
public class ActualPaymentsService {
 
    // URI:
    // /contextPath/servletPath/actualPaymentss
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getActualPaymentss_JSON() {
        List<ActualPayments> list = ActualPaymentsDAO.getActualPayments();
        if(list == null){
        	return Response.status(200).entity(null).build();
        }
        GenericEntity<List<ActualPayments>> entity = new GenericEntity<List<ActualPayments>>( list){};
        return Response.status(201).entity(entity).build();
    }
 
    // URI:
    // /contextPath/servletPath/actualPaymentss/{actualPaymentNo}
    @GET
    @Path("/{actualPaymentNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getActualPayments(@PathParam("actualPaymentNo") String actualPaymentNo) {
    	ActualPayments actualPayments = ActualPaymentsDAO.getActualPaymentsById(actualPaymentNo);
    	if (actualPayments == null){
    		return Response.status(200).entity(null).build();
    	}
    	return Response.status(201).entity(actualPayments).build();
    }
    
    // URI:
    // /contextPath/servletPath/actualPaymentss
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addActualPaymentsThuocTinh( ActualPayments actualPayments) {
        int result = ActualPaymentsDAO.addActualPayments(actualPayments);
        if (result < 0){
        	return Response.status(200).entity(null).build();
        }
        return Response.status(201).entity(actualPayments).build();
    }
    
//     URI:
//     /contextPath/servletPath/actualPaymentss
    @PUT
    @Path("/{actualPaymentNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateActualPayments(ActualPayments actualPayments) {
        Boolean result = ActualPaymentsDAO.updateActualPayments(actualPayments);
        
        if (result){
        	return Response.status(200).entity(actualPayments).build();
        }
        return Response.status(200).entity(null).build();
    }
 
    @DELETE
    @Path("/{actualPaymentNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteActualPayments(@PathParam("actualPaymentNo") String actualPayments) {
        boolean result = ActualPaymentsDAO.deleteActualPayments(actualPayments);
        if (result){
        	return Response.status(200).entity(true).build();
        }
        return Response.status(200).entity(false).build();
    }
 
}