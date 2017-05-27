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

import restfulwebservice.DAO.GuarantorsDAO;
import restfulwebservice.model.Guarantors;

 
@Path("/guarantors")
public class GuarantorsService {
 
    // URI:
    // /contextPath/servletPath/guarantors
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getGuarantorss_JSON() {
        List<Guarantors> list = GuarantorsDAO.getGuarantors();
        if(list == null){
        	return Response.status(200).entity(null).build();
        }
        GenericEntity<List<Guarantors>> entity = new GenericEntity<List<Guarantors>>( list){};
        return Response.status(201).entity(entity).build();
    }
 
    // URI:
    // /contextPath/servletPath/guarantors/{guarantorNo}
    @GET
    @Path("/{guarantorNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getGuarantors(@PathParam("guarantorNo") String guarantorNo) {
    	Guarantors guarantor = GuarantorsDAO.getGuarantorsById(guarantorNo);
    	if (guarantor == null){
    		return Response.status(200).entity(null).build();
    	}
    	return Response.status(201).entity(guarantor).build();
    }
    
    // URI:
    // /contextPath/servletPath/guarantors
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addGuarantorsThuocTinh( Guarantors guarantor) {
        int result = GuarantorsDAO.addGuarantors(guarantor);
        if (result < 0){
        	return Response.status(200).entity(null).build();
        }
        return Response.status(201).entity(guarantor).build();
    }
    
//     URI:
//     /contextPath/servletPath/guarantors
    @PUT
    @Path("/{guarantorNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateGuarantors(Guarantors guarantor) {
        Boolean result = GuarantorsDAO.updateGuarantors(guarantor);
        
        if (result){
        	return Response.status(200).entity(guarantor).build();
        }
        return Response.status(200).entity(null).build();
    }
 
    @DELETE
    @Path("/{guarantorNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteGuarantors(@PathParam("guarantorNo") String guarantor) {
        boolean result = GuarantorsDAO.deleteGuarantors(guarantor);
        if (result){
        	return Response.status(200).entity(true).build();
        }
        return Response.status(200).entity(false).build();
    }
 
}