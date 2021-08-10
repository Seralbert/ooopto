package ys.project.model;

import lombok.*;
import ys.project.model.etalon.BookRecord;

import java.util.List;

/**
 * Created by Smirnov Yury on 09.09.2020.
 *
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Fond {
    String orgName;
    String bookName;
    List<BookRecord> allEntry;
}
