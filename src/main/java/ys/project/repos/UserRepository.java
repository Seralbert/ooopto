package ys.project.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import ys.project.model.User;

import java.util.Optional;

/**
 * Created by zorrax on 26.09.2018.
 *
 */
public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByUsername(String s);
}
