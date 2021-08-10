package ys.project.model.etalon;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ys.project.model.AppendDoc;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Yuriy Smirnov on 18.12.2019.
 * Реализация записи инвентарной книги в соответствии с регламетом
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_record")
public class BookRecord {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    /*
    * Обязательные поля
    * */
    @Column(name = "org_info")
    // фондодержатель, организация субъекта Российской Федерации
    private String orgInfo;
    @Column(name="doc_type")
    // тип документа, в соответссвии с классификатором
    private String docType;
    @Column(name = "doc_name", length = 2048)
    // наименование документа
    private String docName;
    @Column(name="doc_inv_number")
    // инвентарный номер документа
    private String docInvNumber;
    @Column(name="doc_access_type")
    // режимные ограничения
    private String docAccessType;
    /*
    * Информационные поля. При наличичи информации, обязательны для заполнения
    * */
    @Column(name="doc_kadastr_number", length = 600)
    // кадастровый нормер, при инвентаризации является обязательным полем
    private String docKadastrNumber;
    @Column(name = "obj_name")
    // наименование объекта
    private String objName;
    @Column(name="doc_create")
    // Год создания документа
    private int docCreate = 0;
    @Column(name = "scale")
    // масштаб картографической основы
    private String scale;
    @Column(name="sys_coord")
    // система координат картографической основы
    private String sysCoord;
    @Column(name = "page_count")
    // количество носителей или страниц картографического или текстового документа
    private int pageCount;
    @Column(name = "obj_area")
    // площадь объекта
    private double objArea;
    @Column(name = "doc_author", length = 600)
    // реквизиты автора документа
    private String docAuthor;
    @Column(name = "doc_transfer")
    // дата передачи документв в фонд
    private Date docTransfer;
    @Column(name = "obj_price")
    // характеристика ценности
    private String objPrice;

    /*
    * Дополнительные поля. Не обязательные
    * */
    // председатель экспертной комиссии
    //private String commissionLeader;
    // члены экспертной комиссии
    // перечень и характеристика материалов
    @Column(name = "doc_comment", length = 600)
    // примечания
    private String docComment;

    @Column(name= "doc_place")
    private String docPlace;

    @Column(name = "fond_empl")
    private String fondEmpl;

    public String getDocPlace() {
        return docPlace;
    }

    public void setDocPlace(String docPlace) {
        this.docPlace = docPlace;
    }

    public String getFondEmpl() {
        return fondEmpl;
    }

    public void setFondEmpl(String fondEmpl) {
        this.fondEmpl = fondEmpl;
    }

    @OneToMany(mappedBy = "current_record", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<AppendDoc> listDoc;

    public List<AppendDoc> getListDoc() {
        return listDoc;
    }

    public void setListDoc(List<AppendDoc> listDoc) {
        this.listDoc = listDoc;
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

    public int getDocCreate() {
        return docCreate;
    }

    public void setDocCreate(int docCreate) {
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

    public String getObjPrice() {
        return objPrice;
    }

    public void setObjPrice(String objPrice) {
        this.objPrice = objPrice;
    }

    public String getDocComment() {
        return docComment;
    }

    public void setDocComment(String docComment) {
        this.docComment = docComment;
    }
}
