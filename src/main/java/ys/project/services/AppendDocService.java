package ys.project.services;

import ys.project.model.AppendDoc;
import ys.project.model.GFDDoc;

import java.util.List;

/**
 * Created by User on 25.11.2019.
 * Сервис работы с вложенными документами
 */
public interface AppendDocService {
    List<AppendDoc> findByDescription(String s);

    void addAppendDoc(AppendDoc o);
}
