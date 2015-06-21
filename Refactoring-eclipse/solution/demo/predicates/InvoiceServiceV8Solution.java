package demo.predicates;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InvoiceServiceV8Solution {
	public List<Invoice> filterInvoices(List<Invoice> invoices, Predicate<Invoice> predicate) {
		return invoices.stream().filter(predicate).collect(Collectors.toList());
	}
}
