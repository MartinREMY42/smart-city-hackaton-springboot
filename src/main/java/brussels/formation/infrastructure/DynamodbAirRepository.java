package brussels.formation.infrastructure;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

import brussels.formation.model.Air;
import brussels.formation.model.AirRepository;


/**
 * @author abajramov
 * @since 30/08/2018
 */
@Repository
public class DynamodbAirRepository extends DynamodbRepository implements AirRepository {
    // -------------------------------------------------------------------------------Constant(s)---
    
    // -----------------------------------------------------------------------------Property(ies)---
    
    // ----------------------------------------------------------------------------Constructor(s)---
    
    // -------------------------------------------------------------------------------Override(s)---
    @Override
    public List<Air> getAllAirs() {
        DynamoDB dynamodb = new DynamoDB(getDynamodbClient());
        Table    table    = dynamodb.getTable("apollutiondb");
        ItemCollection<ScanOutcome> items = null;
        //Item item = table.getItem("deviceId", deviceId);
        items = table.scan();
        
        //Air air = null;
        Iterator<Item> iterator = items.iterator();
        Item item = null;
        Air air = null;
        List<Air> airList = new ArrayList<Air>();
        int i = 100 ; 
        while (iterator.hasNext() && (i-->0)) {
        	item = iterator.next();
			//type type = (type) en.nextElement();
        	if (item!=null) {
        		air = new Air(item.getString("deviceId"),
        					  item.getString("date"),
        					  item.getString("CO2"),
        					  item.getString("TVOC"),
        					  item.getString("long"),
        					  item.getString("lat"));
        		airList.add(air);
        		System.out.println("found this data : "+air);
        	}
        }
        return airList;
    }
}



