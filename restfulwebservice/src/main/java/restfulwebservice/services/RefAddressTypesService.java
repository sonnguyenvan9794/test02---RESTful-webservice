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

import restfulwebservice.DAO.RefAddressTypesDAO;
import restfulwebservice.model.RefAddressTypes;

 
@Path("/refAddressTypes")
public class RefAddressTypesService {
 
    // URI:
    // /contextPath/servletPath/refAddressTypes
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getRefAddressTypess_JSON() {
        List<RefAddressTypes> list = RefAddressTypesDAO.getRefAddressTypes();
        if(list == null){
        	return Response.status(200).entity(null).build();
        }
        GenericEntity<List<RefAddressTypes>> entity = new GenericEntity<List<RefAddressTypes>>( list){};
        return Response.status(201).entity(entity).build();
    }
 
    // URI:
    // /contextPath/servletPath/refAddressTypes/{refAddressTypeNo}
    @GET
    @Path("/{refAddressTypeNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getRefAddressTypes(@PathParam("refAddressTypeNo") String refAddressTypeNo) {
    	RefAddressTypes refAddressType = RefAddressTypesDAO.getRefAddressTypesById(refAddressTypeNo);
    	if (refAddressType == null){
    		return Response.status(200).entity(null).build();
    	}
    	return Response.status(201).entity(refAddressType).build();
    }
    
    // URI:
    // /contextPath/servletPath/refAddressTypes
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addRefAddressTypesThuocTinh( RefAddressTypes refAddressType) {
        String result = RefAddressTypesDAO.addRefAddressTypes(refAddressType);
        if (result.length() == 0){
        	return Response.status(200).entity(null).build();
        }
        return Response.status(201).entity(refAddressType).build();
    }
    
//     URI:
//     /contextPath/servletPath/refAddressTypes
    @PUT
    @Path("/{refAddressTypeNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateRefAddressTypes(RefAddressTypes refAddressType) {
        Boolean result = RefAddressTypesDAO.updateRefAddressTypes(refAddressType);
        
        if (result){
        	return Response.status(200).entity(refAddressType).build();
        }
        return Response.status(200).entity(null).build();
    }
 
    @DELETE
    @Path("/{refAddressTypeNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteRefAddressTypes(@PathParam("refAddressTypeNo") String refAddressType) {
        boolean result = RefAddressTypesDAO.deleteRefAddressTypes(refAddressType);
        if (result){
        	return Response.status(200).entity(true).build();
        }
        return Response.status(200).entity(false).build();
    }
 
}