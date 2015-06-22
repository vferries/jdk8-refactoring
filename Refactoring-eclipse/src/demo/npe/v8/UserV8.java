package demo.npe.v8;

import java.util.Optional;

public class UserV8 {
	private String name;
	private Optional<BillingInformationV8> billingInformation;

	public UserV8(String name, BillingInformationV8 billingInformation) {
		this.name = name;
		this.billingInformation = Optional.ofNullable(billingInformation);
	}

	public Optional<BillingInformationV8> getBillingInformation() {
		return billingInformation;
	}

	public String getName() {
		return name;
	}
}
