package demo.predicates;

import java.util.ArrayList;
import java.util.List;

public class InvoiceServiceV2 {

	public List<Invoice> filterInvoicesByClient(List<Invoice> invoices, String client) {
		List<Invoice> filtered = new ArrayList<>();
		for (Invoice invoice : invoices) {
			if (invoice.getClient().equals(client)) {
				filtered.add(invoice);
			}
		}
		return filtered;
	}
}
