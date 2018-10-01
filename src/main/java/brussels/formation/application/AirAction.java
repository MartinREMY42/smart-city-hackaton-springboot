package brussels.formation.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import brussels.formation.model.Air;
import brussels.formation.model.AirRepository;
//import brussels.formation.model.Place;

/**
 * @author abajramov
 * @since 30/08/2018
 */
@Component
public class AirAction {
    // -------------------------------------------------------------------------------Constant(s)---
    
    // -----------------------------------------------------------------------------Property(ies)---
    private AirRepository airRepository;
    
    // ----------------------------------------------------------------------------Constructor(s)---
    @Autowired
    public AirAction(AirRepository airRepository) {
        this.airRepository = airRepository;
    }
    
    // -------------------------------------------------------------------------------Override(s)---
    
    // ---------------------------------------------------------------------------------Method(s)---
    public java.util.List<Air> getAir() {
        return airRepository.getAllAirs();
    }
    
    // -----------------------------------------------------------------------Getter(s)/Setter(s)---
}


