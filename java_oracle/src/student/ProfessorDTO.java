package student;

public class ProfessorDTO {
	private int profno;
	private String pname;
	
	public int getProfno() {
		return profno;
	}
	
	public void setProfno(int profno) {
		this.profno = profno;
	}
	
	public String getPname() {
		return pname;
	}
	
	public void setPname(String pname) {
		this.pname = pname;
	}

	@Override
	public String toString() {
		return "ProfessorDTO [profno=" + profno + ", pname=" + pname + "]";
	}

	public ProfessorDTO() {
	}

	public ProfessorDTO(int profno, String pname) {
		this.profno = profno;
		this.pname = pname;
	}
	
	
}
