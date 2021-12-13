package xyz.soulspace.connect_test.pojo;

import lombok.AllArgsConstructor;
import org.apache.ibatis.type.Alias;

@AllArgsConstructor
@Alias("Class")
public class Class {
    int cno;
    String cname;
    int cpno;
    int ccredit;
    Class(){
    }
    public void setCcredit(int ccredit) {
        this.ccredit = ccredit;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public void setCpno(int cpno) {
        this.cpno = cpno;
    }

    public int getCcredit() {
        return ccredit;
    }

    public int getCno() {
        return cno;
    }

    public int getCpno() {
        return cpno;
    }

    public String getCname() {
        return cname;
    }

    @Override
    public String toString() {
        return "Class{" +
                "cno=" + cno +
                ", cname='" + cname + '\'' +
                ", cpno=" + cpno +
                ", ccredit=" + ccredit +
                '}';
    }
}
