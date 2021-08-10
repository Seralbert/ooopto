package ys.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ys.project.model.SearchEntry;
import ys.project.model.etalon.BookRecord;

import java.util.Date;
import java.util.List;

/**
 * Created by User on 27.08.2020.
 *
 */
@Repository
public interface SearchRepo extends JpaRepository<SearchEntry, Long> {
    List<SearchEntry> findByUserName(String userName);

    SearchEntry getOne(Long id);

    @Query(value = "select doc from SearchEntry doc where doc.orgName like ?1  and doc.actionDate between ?2 and ?3")
    //@Query(value = "select doc from SearchEntry doc where doc.orgName like CONCAT('%',?1 ,'%')  and doc.actionDate between ?2 and ?3")
    List<SearchEntry> findList(String orgName, Date docTransferB, Date docTransferE);

    @Query(value = "select doc from SearchEntry doc where doc.actionDate between ?1 and ?2")
        //@Query(value = "select doc from SearchEntry doc where doc.orgName like CONCAT('%',?1 ,'%')  and doc.actionDate between ?2 and ?3")
    List<SearchEntry> findList(Date docTransferB, Date docTransferE);
}
