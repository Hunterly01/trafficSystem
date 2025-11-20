package data.models;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data

public class Owner {
    private String name;
    private String address;
    private String email;
    private String phone;
    private int id;
    private Gender gender;

}
