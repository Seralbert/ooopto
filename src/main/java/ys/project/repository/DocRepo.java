package ys.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ys.project.model.GFDDoc;

import java.util.Date;
import java.util.List;

/**
 * Created by User on 08.11.2019.
 *  Репозиторий основных документов
 */
public interface DocRepo extends JpaRepository<GFDDoc, Long> {
    GFDDoc findGFDDocByNameDoc(String nameDoc);
    GFDDoc findGFDDocById(Long id);
    List<GFDDoc> findGFDDocByNameDocContains(String s);
    List<GFDDoc> findGFDDocByNumDocContainsAndNameDocContainsAndAuthorDocContainsAndNameTOContains(String numDoc,String nameDoc, String authorDoc, String nameRP);
    List<GFDDoc> findGFDDocByNumDocContainsAndNameDocContainsAndAuthorDocContainsAndNameTOContainsAndDateDocAfterAndDateDocBefore(String numDoc, String nameDoc, String authorDoc, String nameRP, Date startDate, Date endDate);

    // "and doc.dateDoc between '2019-11-26 00:00:00' and '2019-11-27 00:00:00' " +
    @Query(value = "select doc from GFDDoc doc where doc.nameDoc like CONCAT('%',?1 ,'%') " +
            "and doc.numDoc like CONCAT('%',?2 ,'%') " +
            "and doc.dateDoc between ?3 and ?4 " +
            "and doc.authorDoc like CONCAT('%',?5 ,'%') " +
            "and doc.nameTO like CONCAT('%',?6 ,'%')")
     List<GFDDoc> findByPattern(String nameDoc, String numDoc, Date docDateStart, Date docDateStop, String authorDoc, String nameTO);
}

