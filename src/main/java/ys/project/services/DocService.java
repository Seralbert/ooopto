package ys.project.services;

import ys.project.model.GFDDoc;

import java.util.List;

/**
 * Created by User on 08.11.2019.
 * сервис-интерфейс
 */

public interface DocService {

    GFDDoc findById(Long id);
    GFDDoc findByNameDoc(String name);
    List<GFDDoc> findAll();

    void save(GFDDoc o);
    void update(GFDDoc o);
}
