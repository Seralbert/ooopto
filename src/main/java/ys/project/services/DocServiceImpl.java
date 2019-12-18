package ys.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ys.project.model.GFDDoc;
import ys.project.repository.DocRepo;

import java.util.Date;
import java.util.List;

/**
 * Created by User on 08.11.2019.
 * Реализация сервиса работы с документами
 */
@Service
public class DocServiceImpl implements DocService {
    private DocRepo repository;

    @Autowired
    public void setProductRepository(DocRepo repository) {
        this.repository = repository;
    }


    @Override
    public GFDDoc findById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public GFDDoc findByNameDoc(String name) {
        return repository.findGFDDocByNameDoc(name);
    }

    @Override
    public List<GFDDoc> findGFDDocByNameDocContains(String name) {
        return repository.findGFDDocByNameDocContains(name);
    }

    @Override
    public List<GFDDoc> findByFild(String numDoc, String nameDoc, String authorDoc, String nameRP, Date startDate, Date endDate) {
        return repository.findGFDDocByNumDocContainsAndNameDocContainsAndAuthorDocContainsAndNameTOContainsAndDateDocAfterAndDateDocBefore(numDoc,nameDoc,authorDoc,nameRP, startDate, endDate);
    }

    @Override
    public List<GFDDoc> findByFild(String numDoc, String nameDoc, String authorDoc, String nameRP) {
        return repository.findGFDDocByNumDocContainsAndNameDocContainsAndAuthorDocContainsAndNameTOContains(numDoc,nameDoc,authorDoc,nameRP);
    }

    @Override
    public List<GFDDoc> findByPattern(String nameDoc, String numDoc, Date docDateStart, Date docDateStop, String authorDoc, String nameTO) {
        //String nameDoc, String numDoc, Date docDateStart, Date docDateStop, String authorDoc, String nameTO
        //System.err.println(docDateStart + " " + docDateStop);
        return repository.findByPattern(nameDoc, numDoc, docDateStart, docDateStop, authorDoc, nameTO);
    }

    @Override
    public void save(GFDDoc o) {
        repository.save(o);
    }
    @Override
    public List<GFDDoc> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(GFDDoc o){
        GFDDoc updated = findById(o.getId());
        System.out.println("ID в сервисе" + o.getId());
        repository.save(updated);
    }
}
