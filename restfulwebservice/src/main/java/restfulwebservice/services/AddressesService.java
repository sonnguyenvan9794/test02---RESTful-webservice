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

import restfulwebservice.DAO.AddressesDAO;
import restfulwebservice.model.Addresses;

 
@Path("/addresses")
public class AddressesService {
 
    // URI:
    // /contextPath/servletPath/addresses
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAddressess_JSON() {
        List<Addresses> list = AddressesDAO.getAddresses();
        if(list == null){
        	return Response.status(200).entity(null).build();
        }
        GenericEntity<List<Addresses>> entity = new GenericEntity<List<Addresses>>( list){};
        return Response.status(201).entity(entity).build();
    }
 
    // URI:
    // /contextPath/servletPath/addresses/{addressNo}
    @GET
    @Path("/{addressNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAddresses(@PathParam("addressNo") String addressNo) {
    	Addresses address = AddressesDAO.getAddressesById(addressNo);
    	if (address == null){
    		return Response.status(200).entity(null).build();
    	}
    	return Response.status(201).entity(address).build();
    }
    
    // URI:
    // /contextPath/servletPath/addresses
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addAddressesThuocTinh( Addresses address) {
        int result = AddressesDAO.addAddresses(address);
        if (result < 0){
        	return Response.status(200).entity(null).build();
        }
        return Response.status(201).entity(address).build();
    }
    
//     URI:
//     /contextPath/servletPath/addresses
    @PUT
    @Path("/{addressNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateAddresses(Addresses address) {
        Boolean result = AddressesDAO.updateAddresses(address);
        
        if (result){
        	return Response.status(200).entity(address).build();
        }
        return Response.status(200).entity(null).build();
    }
 
    @DELETE
    @Path("/{addressNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteAddresses(@PathParam("addressNo") String address) {
        boolean result = AddressesDAO.deleteAddresses(address);
        if (result){
        	return Response.status(200).entity(true).build();
        }
        return Response.status(200).entity(false).build();
    }
 
}