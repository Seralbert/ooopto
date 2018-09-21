package ys.project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * Created by zorrax on 13.09.2018.
 */
@Setter @Getter @NoArgsConstructor
public class CustomDoc {
    @Id
    private String id;

    private String originalDocName;
    private String discription;
    private String fileName;
}
