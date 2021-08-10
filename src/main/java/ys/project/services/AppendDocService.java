package ys.project.services;

import ys.project.model.AppendDoc;

import java.util.List;

/**
 * Created by Yuriy Smirnov on 25.11.2019.
 * Сервис работы с вложенными документами
 */
public interface AppendDocService {
    List<AppendDoc> findByDescription(String s);
    List<AppendDoc> findByParentId(Long id);

    void addAppendDoc(AppendDoc o);

    void delAppendDoc(String uuid);
}
