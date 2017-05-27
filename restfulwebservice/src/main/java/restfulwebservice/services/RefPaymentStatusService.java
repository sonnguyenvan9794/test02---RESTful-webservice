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

import restfulwebservice.DAO.RefPaymentStatusDAO;
import restfulwebservice.model.RefPaymentStatus;

 
@Path("/refPaymentStatus")
public class RefPaymentStatusService {
 
    // URI:
    // /contextPath/servletPath/refPaymentStatus
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getRefPaymentStatuss_JSON() {
        List<RefPaymentStatus> list = RefPaymentStatusDAO.getRefPaymentStatus();
        if(list == null){
        	return Response.status(200).entity(null).build();
        }
        GenericEntity<List<RefPaymentStatus>> entity = new GenericEntity<List<RefPaymentStatus>>( list){};
        return Response.status(201).entity(entity).build();
    }
 
    // URI:
    // /contextPath/servletPath/refPaymentStatus/{refPaymentStatusNo}
    @GET
    @Path("/{refPaymentStatusNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getRefPaymentStatus(@PathParam("refPaymentStatusNo") String refPaymentStatusNo) {
    	RefPaymentStatus refPaymentStatus = RefPaymentStatusDAO.getRefPaymentStatusById(refPaymentStatusNo);
    	if (refPaymentStatus == null){
    		return Response.status(200).entity(null).build();
    	}
    	return Response.status(201).entity(refPaymentStatus).build();
    }
    
    // URI:
    // /contextPath/servletPath/refPaymentStatus
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addRefPaymentStatusThuocTinh( RefPaymentStatus refPaymentStatus) {
        String result = RefPaymentStatusDAO.addRefPaymentStatus(refPaymentStatus);
        if (result.length() == 0){
        	return Response.status(200).entity(null).build();
        }
        return Response.status(201).entity(refPaymentStatus).build();
    }
    
//     URI:
//     /contextPath/servletPath/refPaymentStatus
    @PUT
    @Path("/{refPaymentStatusNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateRefPaymentStatus(RefPaymentStatus refPaymentStatus) {
        Boolean result = RefPaymentStatusDAO.updateRefPaymentStatus(refPaymentStatus);
        
        if (result){
        	return Response.status(200).entity(refPaymentStatus).build();
        }
        return Response.status(200).entity(null).build();
    }
 
    @DELETE
    @Path("/{refPaymentStatusNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteRefPaymentStatus(@PathParam("refPaymentStatusNo") String refPaymentStatus) {
        boolean result = RefPaymentStatusDAO.deleteRefPaymentStatus(refPaymentStatus);
        if (result){
        	return Response.status(200).entity(true).build();
        }
        return Response.status(200).entity(false).build();
    }
 
}