package ys.project.model;

import javax.persistence.*;

/**
 * Created by Yuriy Smirnov on 25.12.2019.
 * Классификатор
 */
@Entity
@Table(name = "gfdvoc")
public class GFDvoc {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "cod")
    private String cod;

    @Column(name = "description")
    private String description;

    public GFDvoc() {
    }

    public GFDvoc(String cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
