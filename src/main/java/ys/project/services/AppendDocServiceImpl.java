package ys.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ys.project.model.AppendDoc;
import ys.project.repository.AppendDocRepo;

import java.util.List;

/**
 * Created by User on 25.11.2019.
 * Реализация метода
 */
@Service
public class AppendDocServiceImpl implements AppendDocService {
    private AppendDocRepo appendDocRepo;
    @Autowired
    public AppendDocServiceImpl(AppendDocRepo appendDocRepo) {
        this.appendDocRepo = appendDocRepo;
    }


    @Override
    public List<AppendDoc> findByDescription(String s) {
        return appendDocRepo.findByDescription(s);
    }

    @Override
    public List<AppendDoc> findByParentId(Long id) {
        return appendDocRepo.findAppendDocByParentId(id);
    }

    @Override
    public void addAppendDoc(AppendDoc o) {
        appendDocRepo.save(o);
    }


}
