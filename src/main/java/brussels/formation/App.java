package brussels.formation;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import brussels.formation.infrastructure.DynamodbAirRepository;
import brussels.formation.model.Air;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {
    
    public static void main(String[] args) {
//    	System.out.println("coucou étape 2");
    	SpringApplication.run(App.class, args);
//    	System.out.println("Hello");
//    	DynamodbAirRepository a = new DynamodbAirRepository();
//    	List<Air> b = a.getAllAirs();
    	System.out.println("Fini");
    }

}
