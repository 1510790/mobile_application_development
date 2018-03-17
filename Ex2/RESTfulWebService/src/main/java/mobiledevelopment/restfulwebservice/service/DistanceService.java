package mobiledevelopment.restfulwebservice.service;
 
//import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
//import org.o7planning.restfulcrud.dao.DistanceDAO;
import mobiledevelopment.restfulwebservice.model.Distance;
 
@Path("/distances")
public class DistanceService {
 
    // URI:
    // /contextPath/servletPath/Distances
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Distance getDistances_JSON() {
        Distance listOfCountries = new Distance("2","a","director");
        return listOfCountries;
    }
    
 // URI:
    // /contextPath/servletPath/Distances/{empNo}
    @GET
    @Path("/{a}/{b}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Distance getTheDistance(@PathParam("a") String pointA, @PathParam("b") String pointB) {
        	
    	String[] PointA = pointA.split("[-]");
    	String[] PointB = pointB.split("[-]");
    	
    	double la1 = Double.parseDouble(PointA[0]);
    	double lo1 = Double.parseDouble(PointA[1]);
    	double la2 = Double.parseDouble(PointB[0]);
    	double lo2 = Double.parseDouble(PointB[1]);
    	
    	double dLat = (la2 - la1) * (Math.PI / 180);
    	double dLon = (lo2 - lo1) * (Math.PI / 180);
    	double la1ToRad = la1 * (Math.PI / 180);
    	double la2ToRad = la2 * (Math.PI / 180);
    	double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(la1ToRad)
    	* Math.cos(la2ToRad) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
    	double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    	double d = 6371 * c;
    	
    	Distance result = new Distance(pointA, pointB, String.valueOf(d));
    	
    	return result;
    	
    }
 }