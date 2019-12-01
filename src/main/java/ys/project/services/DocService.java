package ys.project.services;

import ys.project.model.GFDDoc;

import java.util.Date;
import java.util.List;

/**
 * Created by User on 08.11.2019.
 * сервис-интерфейс
 */

public interface DocService {

    GFDDoc findById(Long id);
    GFDDoc findByNameDoc(String name);

    List<GFDDoc> findByFild(String numDoc, String nameDoc,String authorDoc, String nameRP);
    List<GFDDoc> findByFild(String numDoc, String nameDoc,String authorDoc, String nameRP, Date startDate, Date endDate);


    List<GFDDoc> findGFDDocByNameDocContains(String name);
    List<GFDDoc> findByPattern(String nameDoc, String numDoc, Date docDateStart, Date docDateStop, String authorDoc, String nameTO);
    List<GFDDoc> findAll();

    void save(GFDDoc o);
    void update(GFDDoc o);
}
