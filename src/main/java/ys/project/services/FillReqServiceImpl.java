package ys.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ys.project.model.FillReq;
import ys.project.repository.FillReqRepo;

import java.util.List;

/**
 * Created by Smirnov Yury on 08.09.2020.
 *
 */
@Service
public class FillReqServiceImpl {
    @Autowired
    private FillReqRepo fillReqRepo;

    public List<FillReq> findAll(){
        return fillReqRepo.findAll();
    }
    public void save(FillReq o){
        fillReqRepo.save(o);
    }
    public void delete(FillReq o){
        fillReqRepo.delete(o);
    }
}
