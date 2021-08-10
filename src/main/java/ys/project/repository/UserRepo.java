package ys.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ys.project.model.User;
import ys.project.model.UserRequest;

/**
 * Created by Yuriy Smirnov on 13.03.2020.
 *
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

