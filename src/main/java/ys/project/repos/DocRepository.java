package ys.project.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import ys.project.model.CustomDoc;

/**
 * Created by zorrax on 13.09.2018.
 *
 */
public interface DocRepository extends MongoRepository<CustomDoc,String>
{
    CustomDoc findCustomDocById(String id);
}

