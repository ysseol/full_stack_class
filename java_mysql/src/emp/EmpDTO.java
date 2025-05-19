package emp;

public class EmpDTO {
	private int empno;
	private String ename;
	private String hiredate;
	private int sal;
	
	public int getEmpno() {
		return empno;
	}
	
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	
	public String getEname() {
		return ename;
	}
	
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public String getHiredate() {
		return hiredate;
	}
	
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
	public int getSal() {
		return sal;
	}
	
	public void setSal(int sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "EmpDTO [empno=" + empno + ", ename=" + ename + ", hiredate=" + hiredate + ", sal=" + sal + "]";
	}

	public EmpDTO() {
	}

	public EmpDTO(int empno, String ename, String hiredate, int sal) {
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
		this.sal = sal;
	}
}
