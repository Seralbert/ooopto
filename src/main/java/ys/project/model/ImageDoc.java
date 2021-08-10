package ys.project.model;

import javax.persistence.*;

/**
 * Created by Yuriy Smirnov on 14.12.2019.
 * Сущность объекта образа документа в БД
 */
@Entity
@Table(name = "img_doc")
public class ImageDoc {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "filePath")
    private String filePath;
    @Lob
    @Column(name = "file", columnDefinition = "LONGBLOB")
    private byte[] file;

    public ImageDoc() {
    }

    public ImageDoc(String filePath, byte[] file) {
        this.filePath = filePath;
        this.file = file;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
