package demo.npe.v8;

import java.util.Optional;

import demo.npe.Address;

public class BillingInformationV8 {
	private Optional<Address> address;

	public BillingInformationV8(Address address) {
		this.address = Optional.ofNullable(address);
	}
	
	public Optional<Address> getAddress() {
		return address;
	}
}
