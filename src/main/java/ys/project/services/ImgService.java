package ys.project.services;

import ys.project.model.ImageDoc;

import java.util.List;

/**
 * Created by User on 14.12.2019.
 *
 */
public interface ImgService {
    List<ImageDoc> findAll();
    void save(ImageDoc o);

}
