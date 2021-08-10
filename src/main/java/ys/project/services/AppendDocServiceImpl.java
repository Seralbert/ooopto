package ys.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ys.project.model.AppendDoc;
import ys.project.model.etalon.BookRecord;
import ys.project.repository.AppendDocRepo;
import ys.project.repository.etalon.BookRecordRepository;

import java.util.List;

/**
 * Created by Yuriy Smirnov on 25.11.2019.
 * Реализация метода
 */
@Service
public class AppendDocServiceImpl implements AppendDocService {
    @Autowired
    private BookRecordRepository bookRecordRepository;

    private AppendDocRepo appendDocRepo;
    @Autowired
    public AppendDocServiceImpl(AppendDocRepo appendDocRepo) {
        this.appendDocRepo = appendDocRepo;
    }


    @Override
    public List<AppendDoc> findByDescription(String s) {
        return appendDocRepo.findByDescription(s);
    }

    @Override
    public List<AppendDoc> findByParentId(Long id) {
        return appendDocRepo.findAppendDocByParentId(id);
    }

    @Override
    public void addAppendDoc(AppendDoc o) {
        appendDocRepo.save(o);
    }

    @Override
    public void delAppendDoc(String uuid) {
        appendDocRepo.delete(appendDocRepo.findByUuidFile(uuid));
    }

    public int getCount(String orgName, String bookName){
        List<BookRecord> list = bookRecordRepository.getListCount(orgName,bookName);
        int res = 0;
        for (BookRecord o: list
             ) {
            res += appendDocRepo.findAppendDocByParentId(o.getId()).size();
        }
        System.out.println(res);
        return res;
    }

    public int getCount(String orgName){
        List<BookRecord> list = bookRecordRepository.getListCount(orgName);
        int res = 0;
        for (BookRecord o: list
                ) {
            res += appendDocRepo.findAppendDocByParentId(o.getId()).size();
        }
        //System.out.println(res);
        return res;
    }

}
