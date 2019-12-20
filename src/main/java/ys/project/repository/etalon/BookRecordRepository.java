package ys.project.repository.etalon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ys.project.model.etalon.BookRecord;

/**
 * Created by User on 19.12.2019.
 * Реализация репозитория инвентарной книги в соостветствии с П376
 */
@Repository
public interface BookRecordRepository extends JpaRepository<BookRecord,Long>{
}
