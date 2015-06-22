package demo.npe;

public class UserServiceV2 {
	public String getBillingCity(User user) {
		if (user != null) {
			BillingInformation info = user.getBillingInformation();
			if (info != null) {
				Address address = info.getAddress();
				if (address != null) {
					String city = address.getCity();
					if (city != null) {
						return city;
					}
				}
			}
		}
		return "No billing city";
	}
}
