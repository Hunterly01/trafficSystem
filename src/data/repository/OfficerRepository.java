package data.repository;

import data.models.Officer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface OfficerRepository extends MongoRepository<Officer, String> {
    Officer save(Officer officer);
    Officer findById(int id);
    List<Officer> findAll();
    void deleteById(int id);
    void delete(Officer officer);
    void deleteAll();
    long count();
    Officer findByOffNumber(String offNumber);


}
