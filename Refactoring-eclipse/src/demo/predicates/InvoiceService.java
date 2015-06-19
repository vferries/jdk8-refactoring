package demo.predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class InvoiceService {

	public List<Invoice> filterEclipseInvoices(List<Invoice> invoices) {
		List<Invoice> filtered = new ArrayList<>();
		for (Invoice invoice : invoices) {
			if (invoice.getClient().equals("Eclipse Foundation")) {
				filtered.add(invoice);
			}
		}
		return filtered;
	}

	public List<Invoice> filterInvoicesByClient(List<Invoice> invoices, String client) {
		List<Invoice> filtered = new ArrayList<>();
		for (Invoice invoice : invoices) {
			if (invoice.getClient().equals(client)) {
				filtered.add(invoice);
			}
		}
		return filtered;
	}

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

	
	private List<Invoice> filter2(List<Invoice> invoices) {
		return filterInvoices(invoices, new EclipsePredicate());
	}
	
	private List<Invoice> filterInvoices(List<Invoice> invoices, Predicate<Invoice> predicate) {
		List<Invoice> filtered = new ArrayList<>();
		for (Invoice invoice : invoices) {
			if (predicate.test(invoice)) {
				filtered.add(invoice);
			}
		}
		return filtered;
	}

	private class EclipsePredicate implements Predicate<Invoice> {
		@Override
		public boolean test(Invoice invoice) {
			return invoice.getClient().equals("Eclipse Foundation");
		}
	}
}
