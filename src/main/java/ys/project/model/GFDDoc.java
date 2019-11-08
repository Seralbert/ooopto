package ys.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 07.11.2019.
 * Представляет сущность - документ
 */

@Entity

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class GFDDoc {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "nameTO")
    private String nameTO;
    @Column(name = "numDoc")
    private String numDoc;
    @Column(name = "dateDoc")
    private Date dateDoc;
    @Column(name = "numList")
    private int numList;
    @Column(name = "coord")
    private String coord;
    @Column(name = "nameDoc")
    private String nameDoc;
    @Column(name = "authorDoc")
    private String authorDoc;
    //@Column(name = "attachment")
    //private List<AppendDoc> attachment;
}
