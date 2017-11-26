import java.util.ArrayList;

public class Security extends Person{

	private Campus campus;
	private ArrayList<Violation> issuedViolations;
	
	
	
	public Campus getCampus() {
		return campus;
	}
	public void setCampus(Campus campus) {
		this.campus = campus;
	}
	public ArrayList<Violation> getIssuedViolations() {
		return issuedViolations;
	}
	public void setIssuedViolations(ArrayList<Violation> issuedViolations) {
		this.issuedViolations = issuedViolations;
	}
	
}
