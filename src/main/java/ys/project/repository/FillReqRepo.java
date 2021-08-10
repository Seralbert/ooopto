package ys.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ys.project.model.FillReq;

/**
 * Created by Smirnov Yury on 08.09.2020.
 *
 */
@Repository
public interface FillReqRepo extends JpaRepository<FillReq, Long>{
}
