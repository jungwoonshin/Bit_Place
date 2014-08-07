package bitplace.vo;

import java.io.Serializable;
import java.util.Date;

public class Score implements Serializable{
	 
private static final long serialVersionUID = 1L;

private String name; 
private int no, kor, eng, math;
private Date execDate;

transient private int total;
transient private float avg;

public Score(){

}


@Override
public String toString() {
return "Score [name=" + name + ", no=" + no + ", kor=" + kor + ", eng="
  + eng + ", math=" + math + ", execDate=" + execDate + ", total="
  + total + ", avg=" + avg + "]";
}



public Score(int kor, int eng, int math){
this.kor = kor;
this.eng = eng;
this.math = math;

compute();
}


public void compute(){
this.total=this.eng+this.kor+this.math;
this.avg = this.total/3.0f;
}



public Date getExecDate() {
return execDate;
}

public Score setExecDate(Date execDate) {
this.execDate = execDate;
return this;
}

public int getNo() {
return no;
}

public Score setNo(int no) {
this.no = no;

return this;
}

public String getName() {
return name;
}
public Score setName(String name) {
this.name = name;
return this;
}
public int getKor() {
return kor;
}
public Score setKor(int kor) {
this.kor = kor;
compute();
return this;
}
public int getEng() {
return eng;
}
public Score setEng(int eng) {
this.eng = eng;
compute();
return this;
}
public int getMath() {
return math;
}
public Score setMath(int math) {
this.math = math;
compute();
return this;
}
public int getTotal() {
return total;
}
public void setTotal(int total) {
this.total = total;
}
public float getAvg() {
return avg;
}
public void setAvg(float avg) {
this.avg = avg;
}
public static long getSerialversionuid() {
return serialVersionUID;
}
}