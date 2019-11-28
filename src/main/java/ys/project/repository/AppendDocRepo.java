package ys.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ys.project.model.AppendDoc;
import ys.project.model.GFDDoc;

import java.util.List;

/**
 * Created by User on 25.11.2019.
 * Репозиторий вложенных документов
 */
public interface AppendDocRepo extends JpaRepository<AppendDoc, Long> {
    List<AppendDoc> findByDescription(String description);
    List<AppendDoc> findAppendDocByParentId(Long id);
    //(GFDDoc doc);
}
