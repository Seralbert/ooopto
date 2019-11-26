package ys.project.services;

import ys.project.model.GFDDoc;

import java.util.List;

/**
 * Created by User on 08.11.2019.
 * сервис-интерфейс
 */

public interface DocService {


    List<GFDDoc> findAll();

    void addDoc(GFDDoc o);
}
