package data.models;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "officers")
public class Officer {
    @Id
    private int id;
    private String name;
    private String rank;
    private String address;
    private  String offNumber;


}
