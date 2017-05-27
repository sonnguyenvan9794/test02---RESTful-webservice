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

import restfulwebservice.DAO.PlannedPaymentsDAO;
import restfulwebservice.model.PlannedPayments;

 
@Path("/plannedPayments")
public class PlannedPaymentsService {
 
    // URI:
    // /contextPath/servletPath/plannedPayments
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getPlannedPaymentss_JSON() {
        List<PlannedPayments> list = PlannedPaymentsDAO.getPlannedPayments();
        if(list == null){
        	return Response.status(200).entity(null).build();
        }
        GenericEntity<List<PlannedPayments>> entity = new GenericEntity<List<PlannedPayments>>( list){};
        return Response.status(201).entity(entity).build();
    }
 
    // URI:
    // /contextPath/servletPath/plannedPayments/{plannedPaymentNo}
    @GET
    @Path("/{plannedPaymentNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getPlannedPayments(@PathParam("plannedPaymentNo") String plannedPaymentNo) {
    	PlannedPayments plannedPayment = PlannedPaymentsDAO.getPlannedPaymentsById(plannedPaymentNo);
    	if (plannedPayment == null){
    		return Response.status(200).entity(null).build();
    	}
    	return Response.status(201).entity(plannedPayment).build();
    }
    
    // URI:
    // /contextPath/servletPath/plannedPayments
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addPlannedPaymentsThuocTinh( PlannedPayments plannedPayment) {
        int result = PlannedPaymentsDAO.addPlannedPayments(plannedPayment);
        if (result < 0){
        	return Response.status(200).entity(null).build();
        }
        return Response.status(201).entity(plannedPayment).build();
    }
    
//     URI:
//     /contextPath/servletPath/plannedPayments
    @PUT
    @Path("/{plannedPaymentNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updatePlannedPayments(PlannedPayments plannedPayment) {
        Boolean result = PlannedPaymentsDAO.updatePlannedPayments(plannedPayment);
        
        if (result){
        	return Response.status(200).entity(plannedPayment).build();
        }
        return Response.status(200).entity(null).build();
    }
 
    @DELETE
    @Path("/{plannedPaymentNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deletePlannedPayments(@PathParam("plannedPaymentNo") String plannedPayment) {
        boolean result = PlannedPaymentsDAO.deletePlannedPayments(plannedPayment);
        if (result){
        	return Response.status(200).entity(true).build();
        }
        return Response.status(200).entity(false).build();
    }
 
}