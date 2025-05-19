package student;

public class StudentDTO {
	private int studno;
	private String sname;
	private int grade;
	private String jumin;
	private String tel;
	private int majorno;
	private int profno;
	private String mname;
	private String pname;
	private String img_path;
	
	public int getStudno() {
		return studno;
	}
	
	public void setStudno(int studno) {
		this.studno = studno;
	}
	
	public String getSname() {
		return sname;
	}
	
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public String getJumin() {
		return jumin;
	}
	
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public int getMajorno() {
		return majorno;
	}
	
	public void setMajorno(int majorno) {
		this.majorno = majorno;
	}
	
	public int getProfno() {
		return profno;
	}
	
	public void setProfno(int profno) {
		this.profno = profno;
	}
	
	public String getMname() {
		return mname;
	}
	
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	public String getPname() {
		return pname;
	}
	
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public String getImg_path() {
		return img_path;
	}
	
	public void setImg_path(String imp_path) {
		this.img_path = imp_path;
	}

	@Override
	public String toString() {
		return "StudentDTO [studno=" + studno + ", sname=" + sname + ", grade=" + grade + ", jumin=" + jumin + ", tel="
				+ tel + ", majorno=" + majorno + ", profno=" + profno + ", mname=" + mname + ", pname=" + pname
				+ ", img_path=" + img_path + "]";
	}

	public StudentDTO() {
	}

	public StudentDTO(int studno, String sname, int grade, String jumin, String tel, int majorno, int profno,
			String mname, String pname, String img_path) {
		this.studno = studno;
		this.sname = sname;
		this.grade = grade;
		this.jumin = jumin;
		this.tel = tel;
		this.majorno = majorno;
		this.profno = profno;
		this.mname = mname;
		this.pname = pname;
		this.img_path = img_path;
	}
}
