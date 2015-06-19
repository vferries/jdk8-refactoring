package demo.predicates;

public class Invoice {
	private String client;
	private double amount;

	public Invoice(String client, double amount) {
		super();
		this.client = client;
		this.amount = amount;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
