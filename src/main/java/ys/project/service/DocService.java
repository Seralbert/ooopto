package ys.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ys.project.model.CustomDoc;
import ys.project.repos.DocRepository;

import java.util.List;

/**
 * Created by zorrax on 13.09.2018.
 */
@Service
public class DocService {

    private DocRepository repo;
    @Autowired
    public void setDocRepository(DocRepository repo){
        this.repo = repo;
    }

    public void saveDoc(CustomDoc doc){
        repo.save(doc);
    }

    public CustomDoc findCustomDocById(String id){
        return repo.findCustomDocById(id);
    }

    public void deleteDoc(CustomDoc doc) {
        repo.delete(doc);
    }

    public List<CustomDoc> findAll(){
        List<CustomDoc> list;
        list = repo.findAll();
        return list;
    }
}
