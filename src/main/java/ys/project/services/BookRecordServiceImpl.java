package ys.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ys.project.model.etalon.BookRecord;
import ys.project.repository.etalon.BookRecordRepository;

import java.util.List;

/**
 * Created by User on 19.12.2019.
 * Сервис для работы с BookRecordRepository
 */
@Service
public class BookRecordServiceImpl {
    @Autowired
    private BookRecordRepository repository;

    public BookRecord findById(Long id) { return repository.getOne(id); }

    public List<BookRecord> findAll() { return repository.findAll(); }

    /*
    public List<GFDDoc> findByPattern(String nameDoc, String numDoc, Date docDateStart, Date docDateStop, String authorDoc, String nameTO) {
        //String nameDoc, String numDoc, Date docDateStart, Date docDateStop, String authorDoc, String nameTO
        //System.err.println(docDateStart + " " + docDateStop);
        return repository.findByPattern(nameDoc, numDoc, docDateStart, docDateStop, authorDoc, nameTO);
    }
    // Create
    public void save(GFDDoc o) { repository.save(o); }
    // Update
    public void update(GFDDoc o){
        GFDDoc updated = findById(o.getId());
        System.out.println("ID в сервисе" + o.getId());
        repository.save(updated);
    }

    // Delete
    public void delete(GFDDoc o) { repository.delete(findById(o.getId())); }
    */
}
