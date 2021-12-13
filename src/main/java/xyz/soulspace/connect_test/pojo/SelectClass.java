package xyz.soulspace.connect_test.pojo;

import lombok.AllArgsConstructor;
import org.apache.ibatis.type.Alias;

@AllArgsConstructor
@Alias("SC")
public class SelectClass {
    int sclass;
    int sno;
    int cno;
    int grade;

    public void setCno(int cno) {
        this.cno = cno;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setSclass(int sclass) {
        this.sclass = sclass;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public int getCno() {
        return cno;
    }

    public int getSclass() {
        return sclass;
    }

    public int getSno() {
        return sno;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "SelectClass{" +
                "sclass=" + sclass +
                ", sno=" + sno +
                ", cno=" + cno +
                ", grade=" + grade +
                '}';
    }
}
