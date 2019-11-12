package ys.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ys.project.model.GFDDoc;
import ys.project.repository.DocRepo;

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
    public void addDoc(GFDDoc o) {
        repository.save(o);
    }
    @Override
    public List<GFDDoc> findAll() {
        return repository.findAll();
    }
}
