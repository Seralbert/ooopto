package ys.project.model;

import ys.project.model.etalon.BookRecord;

import javax.persistence.*;

/**
 * Created by Yuriy Smirnov on 08.11.2019.
 * Реализация файл-объекта
 */
@Entity
@Table(name = "append_doc")
public class AppendDoc {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "file_path")
    private String filePath;

    @Column(name="org_name")
    private String orgName;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "uuid")
    private String uuidFile;

    public BookRecord getCurrent_record() {
        return current_record;
    }

    public void setCurrent_record(BookRecord current_record) {
        this.current_record = current_record;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookRecord_id")
    private BookRecord current_record;

    /*@Column(name ="unit")
    private String unit;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
*/
    public String getUuidFile() {
        return uuidFile;
    }

    public void setUuidFile(String uuidFile) {
        this.uuidFile = uuidFile;
    }

    public AppendDoc() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
