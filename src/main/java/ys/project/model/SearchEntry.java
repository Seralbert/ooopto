package ys.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by User on 26.08.2020.
 *
 */
@Entity

@AllArgsConstructor
@Getter @Setter
@Table(name = "search_entry")
public class SearchEntry {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String kadNumber;

    @Column
    private String orgName;

    @Column
    private String docNumber;

    @Column
    private Date actionDate;

    @Column
    private String userName;



    public SearchEntry() {
        this.actionDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKadNumber() {
        return kadNumber;
    }

    public void setKadNumber(String kadNumber) {
        this.kadNumber = kadNumber;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
