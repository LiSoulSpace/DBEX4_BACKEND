package xyz.soulspace.connect_test.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@AllArgsConstructor
@NoArgsConstructor
@Alias("Student")
public class Student {
    int sclass;
    int sno;
    String sname;
    String ssex;
    int sage;

    @JsonProperty
    String Sdept;

    public String getSsex() {
        return ssex;
    }

    public String getSname() {
        return sname;
    }

    public String getSdept() {
        return Sdept;
    }

    public int getSno() {
        return sno;
    }

    public int getSclass() {
        return sclass;
    }

    public int getSage() {
        return sage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sclass=" + sclass +
                ", sno=" + sno +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sage=" + sage +
                ", Sdept='" + Sdept + '\'' +
                '}';
    }
}
