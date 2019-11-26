package ys.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ys.project.model.GFDDoc;

/**
 * Created by User on 08.11.2019.
 *  Репозиторий основных документов
 */
public interface DocRepo extends JpaRepository<GFDDoc, Integer> {
}
