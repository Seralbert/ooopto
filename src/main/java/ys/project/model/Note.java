package ys.project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by zorrax on 06.09.2018.
 *
 */

@Getter @Setter @NoArgsConstructor
@Document
public class Note {
@Id
    private String id;

    private String textCaption;
    private String textMain;

    private String date;

    private String fileName;
    private String fileDocName;

    public Note(String textCaption, String textMain){
        this.textCaption = textCaption;
        this.textMain = textMain;
        this.date = String.format("%tF",new Date());
    }

}
