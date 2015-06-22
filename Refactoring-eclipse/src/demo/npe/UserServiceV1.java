package demo.npe;

public class UserServiceV1 {
	public String getBillingCity(User user) {
		return user.getBillingInformation().getAddress().getCity();
	}
}
