package ys.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ys.project.model.ImageDoc;
import ys.project.repository.ImgRepo;

import java.util.List;

/**
 * Created by Yuriy Smirnov on 14.12.2019.
 * Реализация сервиса работы с образами документов, хранящимися в БД
 * В настоящее время не используется
 */
@Service
public class ImageServiceImpl implements ImgService{
    @Autowired
    private ImgRepo repo;

    @Override
    public List<ImageDoc> findAll() {
        return repo.findAll();
    }

    @Override
    public void save(ImageDoc o) {
        repo.save(o);
    }
    public void saveNFlush(ImageDoc o){
        repo.saveAndFlush(o);
    }
    public ImageDoc findByID(Long id){
        return repo.findById(id).orElseThrow(()-> new RuntimeException("Not Found"));
    }
}
