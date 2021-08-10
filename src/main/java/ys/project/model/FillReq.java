package ys.project.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Smirnov Yury on 08.09.2020.
 *
 */
@Entity

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class FillReq {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String userName;

    @Column
    private String docNumber;

    @Column
    private String kadNumber;

    @Column
    private String docName;

}
