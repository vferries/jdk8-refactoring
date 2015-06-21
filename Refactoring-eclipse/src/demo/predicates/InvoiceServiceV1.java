package demo.predicates;

import java.util.ArrayList;
import java.util.List;

public class InvoiceServiceV1 {

	public List<Invoice> filterEclipseInvoices(List<Invoice> invoices) {
		List<Invoice> filtered = new ArrayList<>();
		for (Invoice invoice : invoices) {
			if (invoice.getClient().equals("Eclipse Foundation")) {
				filtered.add(invoice);
			}
		}
		return filtered;
	}

}
