package ys.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by User on 18.08.2020.
 *
 */
@AllArgsConstructor
@Getter
@Setter
public class Report1 {
    String orgName;
    String bookName;
    int recordCount;
    int appCount;
    public Report1(String orgName){
        this.orgName = orgName;
        recordCount = 0;
        appCount = 0;
    }
    public Report1(String orgName, String bookName){
        this.orgName = orgName;
        this.bookName = bookName;
        recordCount = 0;
        appCount = 0;
    }
}
