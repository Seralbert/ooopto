package ys.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ys.project.model.GFDvoc;
import ys.project.repository.GFDVocRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 25.12.2019.
 */
@Service
public class GFDVocServiceImpl {
    @Autowired
    private GFDVocRepo repo;

    public List<String> getAllCode(){
        List<String> req = new ArrayList<>();

        for (GFDvoc record: repo.findAll()
             ) {
            req.add(record.getCod());
        }
        return req;
    }
    public List<String> getAllDescriptions(){
        List<String> req = new ArrayList<>();

        for (GFDvoc record: repo.findAll()
             ) {
            req.add(record.getDescription());
        }
        return req;
    }
}
