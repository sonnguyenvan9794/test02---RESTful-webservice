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

import restfulwebservice.DAO.RefAccountTypesDAO;
import restfulwebservice.model.RefAccountTypes;

 
@Path("/refAccountTypes")
public class RefAccountTypesService {
 
    // URI:
    // /contextPath/servletPath/refAccountTypes
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getRefAccountTypess_JSON() {
        List<RefAccountTypes> list = RefAccountTypesDAO.getRefAccountTypes();
        if(list == null){
        	return Response.status(200).entity(null).build();
        }
        GenericEntity<List<RefAccountTypes>> entity = new GenericEntity<List<RefAccountTypes>>( list){};
        return Response.status(201).entity(entity).build();
    }
 
    // URI:
    // /contextPath/servletPath/refAccountTypes/{refAccountTypeNo}
    @GET
    @Path("/{refAccountTypeNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getRefAccountTypes(@PathParam("refAccountTypeNo") String refAccountTypeNo) {
    	RefAccountTypes refAccountType = RefAccountTypesDAO.getRefAccountTypesById(refAccountTypeNo);
    	if (refAccountType == null){
    		return Response.status(200).entity(null).build();
    	}
    	return Response.status(201).entity(refAccountType).build();
    }
    
    // URI:
    // /contextPath/servletPath/refAccountTypes
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addRefAccountTypesThuocTinh( RefAccountTypes refAccountType) {
        String result = RefAccountTypesDAO.addRefAccountTypes(refAccountType);
        if (result.length() == 0){
        	return Response.status(200).entity(null).build();
        }
        return Response.status(201).entity(refAccountType).build();
    }
    
//     URI:
//     /contextPath/servletPath/refAccountTypes
    @PUT
    @Path("/{refAccountTypeNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateRefAccountTypes(RefAccountTypes refAccountType) {
        Boolean result = RefAccountTypesDAO.updateRefAccountTypes(refAccountType);
        
        if (result){
        	return Response.status(200).entity(refAccountType).build();
        }
        return Response.status(200).entity(null).build();
    }
 
    @DELETE
    @Path("/{refAccountTypeNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteRefAccountTypes(@PathParam("refAccountTypeNo") String refAccountType) {
        boolean result = RefAccountTypesDAO.deleteRefAccountTypes(refAccountType);
        if (result){
        	return Response.status(200).entity(true).build();
        }
        return Response.status(200).entity(false).build();
    }
 
}