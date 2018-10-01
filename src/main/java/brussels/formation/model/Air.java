package brussels.formation.model;

/**
 * @author abajramov
 * @since 30/08/2018
 */
public class Air {
    // -------------------------------------------------------------------------------Constant(s)---
    
    // -----------------------------------------------------------------------------Propertlat(ies)---
    private String deviceId;
    private String date;
    private String co2;
    private String TVOC;
    private String longiR;
    private String lat;
    
    // ----------------------------------------------------------------------------Constructor(s)---
    public Air(String deviceId, String date, String co2, String TVOC, String longi,
            String lat) {
        this.deviceId = deviceId;
        this.date = date;
        this.co2 = co2;
        this.TVOC = TVOC;
        this.longiR = longi;
        this.lat = lat;
    }
    
    // -------------------------------------------------------------------------------Override(s)---
    
    // ---------------------------------------------------------------------------------Method(s)---
    
    // -----------------------------------------------------------------------Getter(s)/Setter(s)---
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getCO2() {
        return co2;
    }
    
    public void setCO2(String co2) {
        this.co2 = co2;
    }
    
    public String getTVOC() {
        return TVOC;
    }
    
    public void setTVOC(String TVOC) {
        this.TVOC = TVOC;
    }
   
    public String getDeviceId() {
        return deviceId;
    }
    
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    
   
    
    public String getLongi() {
        return longiR;
    }
    
    public void setLongi(String longi) {
        this.longiR = longi;
    }
    
    public String getLat() {
        return lat;
    }
    
    public void setLat(String lat) {
        this.lat = lat;
    }

	@Override
	public String toString() {
		return "Air [deviceId=" + deviceId + ", date=" + date + ", co2=" + co2 + ", TVOC=" + TVOC + ", longi=" + longiR
				+ ", lat=" + lat + "]";
	}
    
}
