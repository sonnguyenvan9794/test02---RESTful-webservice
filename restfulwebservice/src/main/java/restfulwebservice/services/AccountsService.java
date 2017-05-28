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

import restfulwebservice.DAO.AccountsDAO;
import restfulwebservice.model.Accounts;

 
@Path("/accounts")
public class AccountsService {
 
    // URI:
    // /contextPath/servletPath/accounts
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAccountss_JSON() {
        List<Accounts> list = AccountsDAO.getAccounts();
        if(list == null){
        	return Response.status(200).entity(null).build();
        }
        GenericEntity<List<Accounts>> entity = new GenericEntity<List<Accounts>>(list){};
        return Response.status(201).entity(entity).build();
    }
 
    // URI:
    // /contextPath/servletPath/accounts/{accountNo}
    @GET
    @Path("/{accountNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAccounts(@PathParam("accountNo") int accountNo) {
    	Accounts account = AccountsDAO.getAccountsById(accountNo);
    	if (account == null){
    		return Response.status(200).entity(null).build();
    	}
    	return Response.status(201).entity(account).build();
    }
    
    // URI:
    // /contextPath/servletPath/accounts
    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addAccountsThuocTinh( Accounts account) {
        int result = AccountsDAO.addAccounts(account);
        if (result < 0){
        	return Response.status(200).entity(null).build();
        }
        return Response.status(201).entity(account).build();
    }
    
//     URI:
//     /contextPath/servletPath/accounts
    @PUT
    @Path("/{accountNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateAccounts(Accounts account) {
        Boolean result = AccountsDAO.updateAccounts(account);

        if (result){
        	return Response.status(200).entity(account).build();
        }
        return Response.status(200).entity(null).build();
    }
 
    @DELETE
    @Path("/{accountNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteAccounts(@PathParam("accountNo") int account) {
        boolean result = AccountsDAO.deleteAccounts(account);
        if (result){
        	return Response.status(200).entity(true).build();
        }
        return Response.status(200).entity(false).build();
    }
 
}