package demo.predicates;

import java.util.ArrayList;
import java.util.List;

public class InvoiceServiceV3 {

	public List<Invoice> filterInvoicesComplex(List<Invoice> invoices, String client, Double minAmount,
			boolean filterNegative) {
		List<Invoice> filtered = new ArrayList<>();
		for (Invoice invoice : invoices) {
			if (invoice.getClient().equals(client) && (minAmount == null || invoice.getAmount() >= minAmount)
					&& (!filterNegative || invoice.getAmount() > 0)) {
				filtered.add(invoice);
			}
		}
		return filtered;
	}
}
