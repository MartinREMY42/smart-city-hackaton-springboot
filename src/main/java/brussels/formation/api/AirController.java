package brussels.formation.api;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Time;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import brussels.formation.application.AirAction;
import brussels.formation.model.Air;
//import brussels.formation.model.Place;

/**
 * @author abajramov
 * @since 30/08/2018
 */
@RestController("/airs")
public class AirController {
    // -------------------------------------------------------------------------------Constant(s)---
    
    // -----------------------------------------------------------------------------Property(ies)---
    private final AirAction airAction;
    // ----------------------------------------------------------------------------Constructor(s)---
    @Autowired
    public AirController(AirAction airAction) {
        this.airAction = airAction;
    }
    
    // -------------------------------------------------------------------------------Override(s)---
    class Request {
    	List<Air> results;
    	int nbResults;
		public List<Air> getResults() {
			return results;
		}
		public void setResults(List<Air> results) {
			this.results = results;
		}
		public int getNbResults() {
			return nbResults;
		}
		public void setNbResults(int nbResults) {
			this.nbResults = nbResults;
		}
		public Request(List<Air> results) {
			super();
			this.results = results;
			this.nbResults = results.size();
		}
    	
    }
    // ---------------------------------------------------------------------------------Method(s)---
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Request getAir(HttpServletResponse response, @RequestParam("long") Double longi,
    													  @RequestParam("lat")  Double lat,
    													  @RequestParam("range")  Double range) {
    	if (longi==null) return null;
    	if (lat==null) return null;
    	if (range==null) return null; // if ommited, we might want to understand that as "unlimited range", but not yet
    	Double longilatByMeter = 0.006096599600594637/450; // the number left of "/" is the distance for a 450m walk
    	// expressed on a scale in the same type as the one used by longitudes and latitudes
    	
    	Predicate<Air> isThisClose = (air) -> { Double ax = Double.parseDouble(air.getLongi());
    											Double ay = Double.parseDouble(air.getLat());
    											Double dx = longi-ax;
    											Double dy = lat-ay;
    											Double distInLongilat = Math.sqrt((dx*dx)+(dy*dy));
    											// maximal distance in meter is "range"
    											Double maximalDistInLongilat = range * longilatByMeter ; 
    											return distInLongilat < maximalDistInLongilat;
    	};
    	/* DateTime d = new DateTime(Time.now());
    	Predicate<Air> isThisNow = (air) -> {
    		String date = air.getDate().substring(0, 16);
    		return false;
    	}; */
        List<Air> airList =  airAction.getAir().stream()
        		.filter(isThisClose)
        		// .filter(isThisNow) not yet functionnal
        		.collect(Collectors.toList());
        
        if (airList.size() == 0) {
        	System.out.println("IL N'Y A RIEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEN !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        
        return new Request(airList);
    }
    
    // -----------------------------------------------------------------------Getter(s)/Setter(s)---
}


