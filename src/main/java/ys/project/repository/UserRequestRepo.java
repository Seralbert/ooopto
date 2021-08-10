package ys.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ys.project.model.User;
import ys.project.model.UserRequest;

/**
 * Created by User on 21.08.2020.
 *
 */
@Repository
public interface UserRequestRepo extends JpaRepository<UserRequest, Long> {
    UserRequest findByUser(String userName);
}
