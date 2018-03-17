package mobiledevelopment.restfulwebservice.model;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "distance")
@XmlAccessorType(XmlAccessType.FIELD)
public class Distance {
 
    private String pointA;
    private String pointB;
    private String theDistance;
 
    // This default constructor is required if there are other constructors.
    public Distance() {
 
    }
 
    public Distance(String pointA, String pointB, String theDistance) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.theDistance = theDistance;
    }
 
    public String getpointA() {
        return pointA;
    }
 
    public void setpointA(String pointA) {
        this.pointA = pointA;
    }
 
    public String getpointB() {
        return pointB;
    }
 
    public void setpointB(String pointB) {
        this.pointB = pointB;
    }
 
    public String gettheDistance() {
        return theDistance;
    }
 
    public void settheDistance(String theDistance) {
        this.theDistance = theDistance;
    }
 
}