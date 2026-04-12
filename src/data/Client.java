package data;

public class Client extends Account{
	String membershipStatus;
	String membershipType;
	public Client(int id, String firstName, String lastName,String membershipStatus,String membershipType) {
		super(id, firstName, lastName);
		this.membershipStatus = membershipStatus;
		this.membershipType = membershipType;
	}
	public String getMembershipStatus() {
		return membershipStatus;
	}
	public void setMembershipStatus(String membershipStatus) {
		this.membershipStatus = membershipStatus;
	}
	public String getMembershipType() {
		return membershipType;
	}
	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}
	
}
