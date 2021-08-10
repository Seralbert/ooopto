package ys.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ys.project.model.etalon.BookRecord;
import ys.project.repository.etalon.BookRecordRepository;
import ys.project.utils.DataHandler;

import java.util.Date;
import java.util.List;

/**
 * Created by Yuriy Smirnov on 19.12.2019.
 * Сервис для работы с BookRecordRepository
 */
@Service
public class BookRecordServiceImpl {
    @Autowired
    private BookRecordRepository repository;

    public BookRecord findById(Long id) { return repository.getOne(id); }

   // public List<BookRecord> findAll() {
    public Page<BookRecord> findAll(Pageable pageable) {
        return repository.findAllByIdGreaterThan(0l,pageable);

    //    return repository.findAll();
    }

    public List<BookRecord> getAll(){
        return repository.findAll();
    }

    public void save(BookRecord r){
        repository.save(r);
    }

    public List<BookRecord> findByPattern(String orgInfo, String docInvNumber, String docKadastrNumber, String docType,
                                   String docAccessType, String docName, String objName, String docAuthor, String docComment,
                                   int docCreateB, int docCreateE, Date docTransferB, Date docTransferE,
                                   double scaleB, double scaleE, String objPrice){
        return repository.findByPattern(orgInfo, docInvNumber, docKadastrNumber, docType,
                docAccessType, docName, objName, docAuthor, docComment,
                docCreateB, docCreateE, docTransferB, docTransferE,
                scaleB, scaleE,  objPrice);
    }
   /* // @TODO -----------------------
    public Page<BookRecord> findByPattern(String orgInfo, String docInvNumber, String docKadastrNumber, String docType,
                                   String docAccessType, String docName, String objName, String docAuthor, String docComment,
                                   int docCreateB, int docCreateE, Date docTransferB, Date docTransferE,
                                   double scaleB, double scaleE, String objPrice, Pageable pageable){
      return repository.findByPattern(orgInfo,  docInvNumber, docKadastrNumber,  docType,
               docAccessType,  docName, objName, docAuthor, docComment,
        docCreateB, docCreateE, docTransferB, docTransferE,
        scaleB, scaleE, objPrice, pageable);
    }
*/

    // -----------------------------
    public List<BookRecord> findByPattern(String orgInfo, String docInvNumber, String docKadastrNumber, String docType,
                                          String docAccessType, String docName, String objName, String docAuthor, String docComment,
                                          int docCreateB, int docCreateE, Date docTransferB, Date docTransferE
                                          ){
        return repository.findByPattern(orgInfo, docInvNumber, docKadastrNumber, docType,
                docAccessType, docName, objName, docAuthor, docComment,
                docCreateB, docCreateE, docTransferB, docTransferE);
    }
    public Page<BookRecord> findByPatternPage(String orgInfo, String docInvNumber, String docKadastrNumber, String docType,
                                     String docAccessType, String docName, String objName, String docAuthor, String docComment,
                                     int docCreateB, int docCreateE, Date docTransferB, Date docTransferE, Pageable pageable){
        //System.err.println(docTransferB + " " + docTransferE);
        return repository.findByPattern(orgInfo, docInvNumber, docKadastrNumber, docType,
                docAccessType, docName, objName, docAuthor, docComment,
                docCreateB, docCreateE, docTransferB, docTransferE, pageable);
    }

    public void delete(Long id) {
        repository.delete(repository.findById(id).orElseThrow(() -> new IllegalArgumentException("NULL")));
    }
    public List<BookRecord> getList(String orgName){
        return repository.getListCount(orgName);
    }

    public int getCount(String orgName, String bookName){
        return repository.getListCount(orgName,bookName).size();
    }

    public int getCountWAppend(String orgName, String bookName){
        List<BookRecord> list = repository.getListCount(orgName,bookName);
        int res = 0;
        for (BookRecord br: list
             ) {
            if (!br.getListDoc().isEmpty()) res++;
        }
        return res;
    }
    public int getCount(String orgName){
        return repository.getListCount(orgName).size();
    }

    public List<BookRecord> getByOrgInfoAndInvNumber(String orgInfo, String iNumber) {
        return repository.getListCount(orgInfo,iNumber);
    }

    public BookRecord getOneByOrgInfoAndInvNumber(String orgInfo, String iNumber) {
        BookRecord res = null;
        List<BookRecord> list = repository.getListCount(orgInfo,iNumber);
        if (!list.isEmpty()) res = repository.getListCount(orgInfo,iNumber).get(0);
        return res;
    }

    public int getCountByCode(String rs, String book, String s) {
        return repository.findByOrgInfoAndBookNameAndDocCode(rs,book,s).size();
    }
}
