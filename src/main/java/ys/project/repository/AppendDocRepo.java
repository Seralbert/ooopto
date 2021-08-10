package ys.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ys.project.model.AppendDoc;

import java.util.List;

/**
 * Created by Yuriy Smirnov on 25.11.2019.
 * Репозиторий вложенных документов
 */
public interface AppendDocRepo extends JpaRepository<AppendDoc, Long> {
    List<AppendDoc> findByDescription(String description);
    List<AppendDoc> findAppendDocByParentId(Long id);
    AppendDoc findOnceByUuidFileAndFilePath(String uuid, String filePath);
    AppendDoc findByUuidFile(String uuid);

    /*@Query(value = "select doc from AppendDoc doc where doc.orgInfo like ?1 and doc.docInvNumber like CONCAT(?2 ,'%')")
    List<AppendDoc> getListCount(String orgName, String bookName);*/
}
