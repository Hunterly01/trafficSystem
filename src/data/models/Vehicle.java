package data.models;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "Vehicles")
public class Vehicle {

    @Id
    private int id;
    private String name;
    private String color;
    private Owner owner;
    private Year year;
    private String chasisNumber;
    private String offense;
    private List <Ticket>  tickets = new ArrayList<>();
    private String model;


}
