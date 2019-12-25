package ys.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ys.project.model.GFDvoc;

/**
 * Created by User on 25.12.2019.
 *
 */
@Repository
public interface GFDVocRepo extends JpaRepository<GFDvoc, Integer>{

}
