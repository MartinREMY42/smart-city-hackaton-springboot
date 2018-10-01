package brussels.formation.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

/**
 * @author abajramov
 * @since 30/08/2018
 */
abstract class DynamodbRepository {
    // -------------------------------------------------------------------------------Constant(s)---
    
    // -----------------------------------------------------------------------------Property(ies)---
    private final AmazonDynamoDB dynamodbClient = AmazonDynamoDBClientBuilder.standard().build();
    
    // ----------------------------------------------------------------------------Constructor(s)---
    
    // -------------------------------------------------------------------------------Override(s)---
    
    // ---------------------------------------------------------------------------------Method(s)---
    
    // -----------------------------------------------------------------------Getter(s)/Setter(s)---
    protected AmazonDynamoDB getDynamodbClient() {
        return dynamodbClient;
    }
}
