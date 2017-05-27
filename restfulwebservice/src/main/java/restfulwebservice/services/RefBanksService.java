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

import restfulwebservice.DAO.RefBanksDAO;
import restfulwebservice.model.RefBanks;

 
@Path("/refBanks")
public class RefBanksService {
 
    // URI:
    // /contextPath/servletPath/refBanks
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getRefBankss_JSON() {
        List<RefBanks> list = RefBanksDAO.getRefBanks();
        if(list == null){
        	return Response.status(200).entity(null).build();
        }
        GenericEntity<List<RefBanks>> entity = new GenericEntity<List<RefBanks>>( list){};
        return Response.status(201).entity(entity).build();
    }
 
    // URI:
    // /contextPath/servletPath/refBanks/{refBankNo}
    @GET
    @Path("/{refBankNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getRefBanks(@PathParam("refBankNo") String refBankNo) {
    	RefBanks refBank = RefBanksDAO.getRefBanksById(refBankNo);
    	if (refBank == null){
    		return Response.status(200).entity(null).build();
    	}
    	return Response.status(201).entity(refBank).build();
    }
    
    // URI:
    // /contextPath/servletPath/refBanks
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addRefBanksThuocTinh( RefBanks refBank) {
    	String result = RefBanksDAO.addRefBanks(refBank);
    	if (result.length() == 0){
        	return Response.status(200).entity(null).build();
        }
        return Response.status(201).entity(refBank).build();
    }
    
//     URI:
//     /contextPath/servletPath/refBanks
    @PUT
    @Path("/{refBankNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateRefBanks(RefBanks refBank) {
        Boolean result = RefBanksDAO.updateRefBanks(refBank);
        
        if (result){
        	return Response.status(200).entity(refBank).build();
        }
        return Response.status(200).entity(null).build();
    }
 
    @DELETE
    @Path("/{refBankNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteRefBanks(@PathParam("refBankNo") String refBank) {
        boolean result = RefBanksDAO.deleteRefBanks(refBank);
        if (result){
        	return Response.status(200).entity(true).build();
        }
        return Response.status(200).entity(false).build();
    }
 
}