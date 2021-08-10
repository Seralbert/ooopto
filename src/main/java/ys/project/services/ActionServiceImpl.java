package ys.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ys.project.model.etalon.Action;
import ys.project.repository.ActionRepo;

import java.util.List;

/**
 * Created by Yuriy Smirnov on 30.01.2020.
 * реализация журнала действий
 */
@Service
public class ActionServiceImpl {

    @Autowired
    private ActionRepo repository;

    public Action findById(Long id) { return repository.getOne(id); }
    public List<Action> findAll(){return repository.findAll();}
    public void save(Action o){repository.save(o);}
}
