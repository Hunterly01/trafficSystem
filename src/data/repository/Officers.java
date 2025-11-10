package data.repository;

import data.models.Officer;
import exceptions.IdNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Officers implements OfficerRepository {
    private List<Officer> officers = new ArrayList<>();
    private int count = 0;


    @Override
    public Officer save(Officer officer) {
        officers.add(officer);
        count++;
        return officer;
    }

    @Override
    public Officer findById(int id) {
        for (Officer officer : officers) {
            if (officer.getId() == id) {
                return officer;
            }
        }
        throw new IdNotFoundException("Officer with id " + id + " not found");

    }

    @Override
    public List<Officer> findAll() {
        return officers;
    }

    @Override
    public void deleteById(int id) {
        officers.removeIf(officer -> officer.getId() == id);
        }


    @Override
    public void delete(Officer officer) {
        officers.remove(officer);

    }

    @Override
    public void deleteAll() {
        officers.clear();

    }

    @Override
    public long count() {
        return count;
    }
}
