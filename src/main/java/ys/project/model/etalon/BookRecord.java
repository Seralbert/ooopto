package ys.project.model.etalon;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by User on 18.12.2019.
 * Реализация записи инфвентарной книги в соответствии с регламетом
 */
@Entity
@Table
public class BookRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /*
    * Обязательные поля
    * */
    // фондодержатель, организация субъекта Российской Федерации
    @Column
    private String orgInfo;
    // тип документа, в соответссвии с классификатором
    @Column
    private String docType;
    // наименование документа
    @Column
    private String docName;
    // инвентарный номер документа
    @Column
    private String docInvNumber;
    // режимные ограничения
    @Column
    private String docAccessType;
    /*
    * Информационные поля. При наличичи информации, обязательны для заполнения
    * */
    // кадастровый нормер, при инвентаризации является обязательным полем
    @Column
    private String docKadastrNumber;
    // наименование объекта
    @Column
    private String objName;
    // Год создания документа
    @Column
    private Date docCreate;
    // масштаб картографической основы
    @Column
    private String scale;
    // система координат картографической основы
    @Column
    private String sysCoord;
    // количество носителей или страниц картографического или текстового документа
    @Column
    private int pageCount;
    // площадь объекта
    @Column
    private double objArea;
    // реквизиты автора документа
    @Column
    private String docAuthor;
    // дата передачи документв в фонд
    @Column
    private Date docTransfer;
    // характеристика ценности
    @Column
    private double objPrice;

    /*
    * Дополнительные поля. Не обязательные
    * */
    // председатель экспертной комиссии
    private String commissionLeader;
    // члены экспертной комиссии
    // перечень и характеристика материалов
    // примечания
    @Column
    private String docComment;

    public BookRecord() {
    }

    public BookRecord(String orgInfo, String docType, String docName, String docInvNumber, String docAccessType, String docKadastrNumber, String objName, Date docCreate, String scale, String sysCoord, int pageCount, double objArea, String docAuthor, Date docTransfer, double objPrice, String commissionLeader, String docComment) {
        this.orgInfo = orgInfo;
        this.docType = docType;
        this.docName = docName;
        this.docInvNumber = docInvNumber;
        this.docAccessType = docAccessType;
        this.docKadastrNumber = docKadastrNumber;
        this.objName = objName;
        this.docCreate = docCreate;
        this.scale = scale;
        this.sysCoord = sysCoord;
        this.pageCount = pageCount;
        this.objArea = objArea;
        this.docAuthor = docAuthor;
        this.docTransfer = docTransfer;
        this.objPrice = objPrice;
        this.commissionLeader = commissionLeader;
        this.docComment = docComment;
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

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocInvNumber() {
        return docInvNumber;
    }

    public void setDocInvNumber(String docInvNumber) {
        this.docInvNumber = docInvNumber;
    }

    public String getDocAccessType() {
        return docAccessType;
    }

    public void setDocAccessType(String docAccessType) {
        this.docAccessType = docAccessType;
    }

    public String getDocKadastrNumber() {
        return docKadastrNumber;
    }

    public void setDocKadastrNumber(String docKadastrNumber) {
        this.docKadastrNumber = docKadastrNumber;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public Date getDocCreate() {
        return docCreate;
    }

    public void setDocCreate(Date docCreate) {
        this.docCreate = docCreate;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getSysCoord() {
        return sysCoord;
    }

    public void setSysCoord(String sysCoord) {
        this.sysCoord = sysCoord;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public double getObjArea() {
        return objArea;
    }

    public void setObjArea(double objArea) {
        this.objArea = objArea;
    }

    public String getDocAuthor() {
        return docAuthor;
    }

    public void setDocAuthor(String docAuthor) {
        this.docAuthor = docAuthor;
    }

    public Date getDocTransfer() {
        return docTransfer;
    }

    public void setDocTransfer(Date docTransfer) {
        this.docTransfer = docTransfer;
    }

    public double getObjPrice() {
        return objPrice;
    }

    public void setObjPrice(double objPrice) {
        this.objPrice = objPrice;
    }

    public String getCommissionLeader() {
        return commissionLeader;
    }

    public void setCommissionLeader(String commissionLeader) {
        this.commissionLeader = commissionLeader;
    }

    public String getDocComment() {
        return docComment;
    }

    public void setDocComment(String docComment) {
        this.docComment = docComment;
    }
}
