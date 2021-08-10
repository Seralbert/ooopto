package ys.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ys.project.model.SearchEntry;
import ys.project.repository.SearchRepo;

import java.util.Date;
import java.util.List;

/**
 * Created by User on 27.08.2020.
 *
 */
@Service
public class SearchServiceImpl {
    @Autowired
    private SearchRepo repo;

    public List<SearchEntry> getByUsername(String userName){
        return repo.findByUserName(userName);
    }
    public List<SearchEntry> findList(String orgName, Date dateB, Date dateE){
        return repo.findList(orgName, dateB, dateE);
    }

    public List<SearchEntry> findList(Date dateB, Date dateE){
        return repo.findList(dateB, dateE);
    }

    public void save(SearchEntry o){
        repo.save(o);
    }

    public List<SearchEntry> findAll() {
        return repo.findAll();
    }

    public SearchEntry findById(Long id){
        return repo.getOne(id);
    }

    public void delById(Long id) {
        repo.delete(findById(id));
    }
}
