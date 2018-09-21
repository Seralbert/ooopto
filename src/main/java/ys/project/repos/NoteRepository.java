package ys.project.repos;


import org.springframework.data.mongodb.repository.MongoRepository;
import ys.project.model.Note;

/**
 * Created by zorrax on 07.09.2018.
 *
 * Надо быть очень осторожным с mongod.conf разметкой проверить мм можно на YAML parser
 * http://yaml-online-parser.appspot.com
 */

public interface NoteRepository extends MongoRepository<Note,String>
{
    Note findNoteById(String id);
}
