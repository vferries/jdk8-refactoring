package demo.npe;

public class UserServiceV3 {
	public String getBillingCity(User user) {
		if (user == null) {
			return "No billing city";
		}
		BillingInformation info = user.getBillingInformation();
		if (info == null) {
			return "No billing city";
		}
		Address address = info.getAddress();
		if (address == null) {
			return "No billing city";
		}
		String city = address.getCity();
		if (city == null) {
			return "No billing city";
		}
		return city;
	}
}
