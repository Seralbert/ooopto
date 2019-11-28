package ys.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by User on 08.11.2019.
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

    @Column(name = "filePath")
    private String filePath;

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

    public void setParentId(GFDDoc parentId) {
        this.parentId = parentId.getId();
    }
}
