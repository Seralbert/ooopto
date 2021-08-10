package ys.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ys.project.model.ImageDoc;

/**
 * Created by User on 14.12.2019.
 * Рпозиторий для работы с образами, хранящимися в БД
 * в настоящее время не используется
 */
@Repository
public interface ImgRepo extends JpaRepository<ImageDoc,Long>{
    //ImageDoc findById(Long id);
}
