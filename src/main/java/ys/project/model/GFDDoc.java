package ys.project.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by User on 07.11.2019.
 * Представляет сущность - документ
 */

@Entity

@NoArgsConstructor
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTO() {
        return nameTO;
    }

    public void setNameTO(String nameTO) {
        this.nameTO = nameTO;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public Date getDateDoc() {
        return dateDoc;
    }

    public void setDateDoc(Date dateDoc) {
        this.dateDoc = dateDoc;
    }

    public int getNumList() {
        return numList;
    }

    public void setNumList(int numList) {
        this.numList = numList;
    }

    public String getCoord() {
        return coord;
    }

    public void setCoord(String coord) {
        this.coord = coord;
    }

    public String getNameDoc() {
        return nameDoc;
    }

    public void setNameDoc(String nameDoc) {
        this.nameDoc = nameDoc;
    }

    public String getAuthorDoc() {
        return authorDoc;
    }

    public void setAuthorDoc(String authorDoc) {
        this.authorDoc = authorDoc;
    }
}
