package ys.project.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 *
 *  Created by Yuriy Smirnov on 21.08.2020.
 * Кэш запроса пользователя для формирования GET-запроса
 */
@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "user_request")
public class UserRequest {

    @Id
    @GeneratedValue
    private Long id;

    private String orgInfo;
    private String docInvNumber;
    private String docKadastrNumber;
    private String docType;
    private String docAccessType;
    private String docName;
    private String objName;
    private String docAuthor;
    private String docComment;
    private int docCreateB;
    private int docCreateE;
    private String docTransferB;
    private String docTransferE;

    private String user;

    public UserRequest() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgInfo() {
        return orgInfo;
    }

    public void setOrgInfo(String orgInfo) {
        this.orgInfo = orgInfo;
    }

    public String getDocInvNumber() {
        return docInvNumber;
    }

    public void setDocInvNumber(String docInvNumber) {
        this.docInvNumber = docInvNumber;
    }

    public String getDocKadastrNumber() {
        return docKadastrNumber;
    }

    public void setDocKadastrNumber(String docKadastrNumber) {
        this.docKadastrNumber = docKadastrNumber;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocAccessType() {
        return docAccessType;
    }

    public void setDocAccessType(String docAccessType) {
        this.docAccessType = docAccessType;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public String getDocAuthor() {
        return docAuthor;
    }

    public void setDocAuthor(String docAuthor) {
        this.docAuthor = docAuthor;
    }

    public String getDocComment() {
        return docComment;
    }

    public void setDocComment(String docComment) {
        this.docComment = docComment;
    }

    public int getDocCreateB() {
        return docCreateB;
    }

    public void setDocCreateB(int docCreateB) {
        this.docCreateB = docCreateB;
    }

    public int getDocCreateE() {
        return docCreateE;
    }

    public void setDocCreateE(int docCreateE) {
        this.docCreateE = docCreateE;
    }

    public String getDocTransferB() {
        return docTransferB;
    }

    public void setDocTransferB(String docTransferB) {
        this.docTransferB = docTransferB;
    }

    public String getDocTransferE() {
        return docTransferE;
    }

    public void setDocTransferE(String docTransferE) {
        this.docTransferE = docTransferE;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}