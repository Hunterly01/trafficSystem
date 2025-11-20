package data.models;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "Tickets")
public class Ticket {
    @Id
    private int id;
    private Vehicle vehicle;
    private Offence offence;
    private boolean hasPaid;
    private Officer issuer;
    private LocalDateTime date = LocalDateTime.now();
    private int amount;

}
