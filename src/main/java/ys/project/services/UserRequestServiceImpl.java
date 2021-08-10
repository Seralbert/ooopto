package ys.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ys.project.model.User;
import ys.project.model.UserRequest;
import ys.project.repository.UserRequestRepo;

/**
 * Created by User on 21.08.2020.
 *
 */
@Service
public class UserRequestServiceImpl {
    @Autowired
    private UserRequestRepo repo;

    public UserRequest getRequestByUsername(String userName){
        return repo.findByUser(userName);
    }
   public void save(UserRequest o){
        repo.save(o);
    }
}
