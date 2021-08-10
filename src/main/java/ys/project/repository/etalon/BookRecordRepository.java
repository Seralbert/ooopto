package ys.project.repository.etalon;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ys.project.model.etalon.BookRecord;

import java.util.Date;
import java.util.List;

/**
 * Created by Yuriy Smirnov on 19.12.2019.
 * Реализация репозитория инвентарной книги в соостветствии с П376
 */
@Repository
public interface BookRecordRepository extends JpaRepository<BookRecord,Long>{

/*    // @TODO --------------------------
    // Паджинация
    @Query(value =  "select doc from BookRecord doc where doc.orgInfo like CONCAT('%',?1 ,'%') " +
            "and doc.docInvNumber like CONCAT('%',?2 ,'%') " +
            "and doc.docKadastrNumber like CONCAT('%',?3 ,'%') and doc.docType like CONCAT('%',?4 ,'%')" +
            "and doc.docAccessType like CONCAT('%',?5 ,'%') and doc.docName like CONCAT('%',?6 ,'%')" +
            "and doc.objName like CONCAT('%',?7 ,'%') and doc.docAuthor like CONCAT('%',?8 ,'%')" +
            "and doc.docComment like CONCAT('%',?9 ,'%') " +
            "and  doc.docCreate >= ?10 and doc.docCreate <= ?11 and doc.docTransfer between ?12 and ?13 " +
            "and doc.scale >= ?14 and doc.scale <= ?15 " +
            "and doc.objPrice like CONCAT('%',?16 ,'%')")
    Page<BookRecord> findByPattern(String orgInfo, String docInvNumber, String docKadastrNumber, String docType,
                                   String docAccessType, String docName, String objName, String docAuthor, String docComment,
                                   int docCreateB, int docCreateE, Date docTransferB, Date docTransferE,
                                   double scaleB, double scaleE, String objPrice, Pageable pageable);

    //----------------------------------*/


    @Query(value =  "select doc from BookRecord doc where doc.orgInfo like CONCAT('%',?1 ,'%') " +
                    "and doc.docInvNumber like CONCAT('%',?2 ,'%') " +
                    "and doc.docKadastrNumber like CONCAT('%',?3 ,'%') and doc.docType like CONCAT('%',?4 ,'%')" +
                    "and doc.docAccessType like CONCAT('%',?5 ,'%') and doc.docName like CONCAT('%',?6 ,'%')" +
                    "and doc.objName like CONCAT('%',?7 ,'%') and doc.docAuthor like CONCAT('%',?8 ,'%')" +
                    "and doc.docComment like CONCAT('%',?9 ,'%') " +
                    "and  doc.docCreate >= ?10 and doc.docCreate <= ?11 and doc.docTransfer between ?12 and ?13 " +
                    "and doc.scale >= ?14 and doc.scale <= ?15 " +
                    "and doc.objPrice like CONCAT('%',?16 ,'%')")
    List<BookRecord> findByPattern(String orgInfo, String docInvNumber, String docKadastrNumber, String docType,
                                   String docAccessType, String docName, String objName, String docAuthor, String docComment,
                                   int docCreateB, int docCreateE, Date docTransferB, Date docTransferE,
                                   double scaleB, double scaleE, String objPrice);


    @Query(value =  "select doc from BookRecord doc where doc.orgInfo like CONCAT('%',?1 ,'%') " +
            "and doc.docInvNumber like CONCAT('%',?2 ,'%') " +
            "and doc.docKadastrNumber like CONCAT('%',?3 ,'%') and doc.docType like CONCAT('%',?4 ,'%')" +
            "and doc.docAccessType like CONCAT('%',?5 ,'%') and doc.docName like CONCAT('%',?6 ,'%')" +
            "and doc.objName like CONCAT('%',?7 ,'%') and doc.docAuthor like CONCAT('%',?8 ,'%')" +
            "and doc.docComment like CONCAT('%',?9 ,'%') " +
            "and  doc.docCreate >= ?10 and doc.docCreate <= ?11 and doc.docTransfer between ?12 and ?13 ")
    List<BookRecord> findByPattern(String orgInfo, String docInvNumber, String docKadastrNumber, String docType,
                                   String docAccessType, String docName, String objName, String docAuthor, String docComment,
                                   int docCreateB, int docCreateE, Date docTransferB, Date docTransferE
                                   );
    @Query(value =  "select doc from BookRecord doc where doc.orgInfo like CONCAT('%',?1 ,'%') " +
            "and doc.docInvNumber like CONCAT('%',?2 ,'%') " +
            "and doc.docKadastrNumber like CONCAT('%',?3 ,'%') and doc.docType like CONCAT('%',?4 ,'%')" +
            "and doc.docAccessType like CONCAT('%',?5 ,'%') and doc.docName like CONCAT('%',?6 ,'%')" +
            "and doc.objName like CONCAT('%',?7 ,'%') and doc.docAuthor like CONCAT('%',?8 ,'%')" +
            "and doc.docComment like CONCAT('%',?9 ,'%') " +
            "and  doc.docCreate >= ?10 and doc.docCreate <= ?11 and doc.docTransfer between ?12 and ?13 ")
    Page<BookRecord> findByPattern(String orgInfo, String docInvNumber, String docKadastrNumber, String docType,
                                   String docAccessType, String docName, String objName, String docAuthor, String docComment,
                                   int docCreateB, int docCreateE, Date docTransferB, Date docTransferE
                                   , Pageable pageable
    );


    @Query(value = "select doc from BookRecord doc where doc.orgInfo like CONCAT('%',?1 ,'%') and doc.docCreate >= ?2 and doc.docCreate <= ?3 and doc.docTransfer between ?4 and ?5")
    List<BookRecord> findLine(String orgInfo, int docCreateB, int docCreateE, Date docTransferB, Date docTransferE);




    @Query(value = "select doc from BookRecord doc where doc.orgInfo like ?1 and doc.docInvNumber like CONCAT(?2 ,'%')")
    List<BookRecord> getListCount(String orgInfo, String bookName);

    @Query(value = "select doc from BookRecord doc where doc.orgInfo like ?1")
    List<BookRecord> getListCount(String orgInfo);

    //Page<BookRecord> findByPattern(String , String , String , String , String , String , String , String , String , int , int , Date , Date , Pageable );

    //List<BookRecord> findByOrgInfo();
    Page<BookRecord> findAllByIdGreaterThan(Long id, Pageable pageable);


    @Query(value = "select doc from BookRecord doc where doc.orgInfo like ?1 and doc.docInvNumber like CONCAT(?2 ,'%') and doc.docType like ?3")
    List<BookRecord> findByOrgInfoAndBookNameAndDocCode(String orgInfo, String bookName, String docType);
}
