package ys.project.model.etalon;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Yuriy Smirnov on 30.01.2020.
 *
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "action")
public class Action {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nameRecord;

    @Column
    private String nameAppendDoc;

    @Column
    private String nameAction;

    @Column
    private String userName;

    @Column
    private Date actionDate;

    public Action() {
        this.actionDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameRecord() {
        return nameRecord;
    }

    public void setNameRecord(String nameRecord) {
        this.nameRecord = nameRecord;
    }

    public String getNameAppendDoc() {
        return nameAppendDoc;
    }

    public void setNameAppendDoc(String nameAppendDoc) {
        this.nameAppendDoc = nameAppendDoc;
    }

    public String getNameAction() {
        return nameAction;
    }

    public void setNameAction(String nameAction) {
        this.nameAction = nameAction;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
