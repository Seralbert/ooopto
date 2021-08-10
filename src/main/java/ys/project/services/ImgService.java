package ys.project.services;

import ys.project.model.ImageDoc;

import java.util.List;

/**
 * Created by Yuriy Smirnov on 14.12.2019.
 * сервис работы с образом докуента, хранящимся в БД
 * в настоящее время не используется
 */
public interface ImgService {
    List<ImageDoc> findAll();
    void save(ImageDoc o);

}
