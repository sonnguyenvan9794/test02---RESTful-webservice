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

import restfulwebservice.DAO.RefLoanStatusDAO;
import restfulwebservice.model.RefLoanStatus;

 
@Path("/refLoanStatus")
public class RefLoanStatusService {
 
    // URI:
    // /contextPath/servletPath/refLoanStatus
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getRefLoanStatuss_JSON() {
        List<RefLoanStatus> list = RefLoanStatusDAO.getRefLoanStatus();
        if(list == null){
        	return Response.status(200).entity(null).build();
        }
        GenericEntity<List<RefLoanStatus>> entity = new GenericEntity<List<RefLoanStatus>>( list){};
        return Response.status(201).entity(entity).build();
    }
 
    // URI:
    // /contextPath/servletPath/refLoanStatus/{refLoanStatusNo}
    @GET
    @Path("/{refLoanStatusNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getRefLoanStatus(@PathParam("refLoanStatusNo") String refLoanStatusNo) {
    	RefLoanStatus refLoanStatus = RefLoanStatusDAO.getRefLoanStatusById(refLoanStatusNo);
    	if (refLoanStatus == null){
    		return Response.status(200).entity(null).build();
    	}
    	return Response.status(201).entity(refLoanStatus).build();
    }
    
    // URI:
    // /contextPath/servletPath/refLoanStatus
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addRefLoanStatusThuocTinh( RefLoanStatus refLoanStatus) {
        String result = RefLoanStatusDAO.addRefLoanStatus(refLoanStatus);
        if (result.length() == 0){
        	return Response.status(200).entity(null).build();
        }
        return Response.status(201).entity(refLoanStatus).build();
    }
    
//     URI:
//     /contextPath/servletPath/refLoanStatus
    @PUT
    @Path("/{refLoanStatusNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateRefLoanStatus(RefLoanStatus refLoanStatus) {
        Boolean result = RefLoanStatusDAO.updateRefLoanStatus(refLoanStatus);
        
        if (result){
        	return Response.status(200).entity(refLoanStatus).build();
        }
        return Response.status(200).entity(null).build();
    }
 
    @DELETE
    @Path("/{refLoanStatusNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteRefLoanStatus(@PathParam("refLoanStatusNo") String refLoanStatus) {
        boolean result = RefLoanStatusDAO.deleteRefLoanStatus(refLoanStatus);
        if (result){
        	return Response.status(200).entity(true).build();
        }
        return Response.status(200).entity(false).build();
    }
 
}