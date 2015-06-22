package demo.npe;

public class User {
	private String name;
	private BillingInformation billingInformation;
	
	public User(String name, BillingInformation billingInformation) {
		this.name = name;
		this.billingInformation = billingInformation;
	}

	public BillingInformation getBillingInformation() {
		return billingInformation;
	}

	public String getName() {
		return name;
	}
}
