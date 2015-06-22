package demo.npe.v8;

import java.util.Optional;

import demo.npe.Address;

public class UserServiceV8Solution {
	public String getBillingCity(UserV8 user) {
		return Optional.ofNullable(user)
				.flatMap(UserV8::getBillingInformation)
				.flatMap(BillingInformationV8::getAddress)
				.map(Address::getCity)
				.orElse("No billing city");
	}
}
