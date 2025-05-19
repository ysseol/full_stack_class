package student;

public class MajorDTO {
	private int majorno;
	private String mname;
	
	public int getMajorno() {
		return majorno;
	}
	
	public void setMajorno(int majorno) {
		this.majorno = majorno;
	}
	
	public String getMname() {
		return mname;
	}
	
	public void setMname(String mname) {
		this.mname = mname;
	}

	@Override
	public String toString() {
		return "MajorDTO [majorno=" + majorno + ", mname=" + mname + "]";
	}

	public MajorDTO() {
	}

	public MajorDTO(int majorno, String mname) {
		this.majorno = majorno;
		this.mname = mname;
	}
	
}
