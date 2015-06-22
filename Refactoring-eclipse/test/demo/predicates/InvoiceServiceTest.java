package demo.predicates;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.BeforeClass;
import org.junit.Test;

import demo.predicates.Invoice;
import demo.predicates.InvoiceServiceV1;
import demo.predicates.InvoiceServiceV2;
import demo.predicates.InvoiceServiceV3;
import demo.predicates.InvoiceServiceV8;

public class InvoiceServiceTest {
	private static List<Invoice> invoices = new ArrayList<>();
	private static Invoice eclipse1 = new Invoice("Eclipse Foundation", 134.50);
	private static Invoice eclipse2 = new Invoice("Eclipse Foundation", 200.00);
	private static Invoice redHat = new Invoice("Red Hat", 1000.00);
	private static Invoice apache = new Invoice("Apache", 42);
	private static Invoice springSource = new Invoice("Spring Source", 60.30);
	private static Invoice jenkins1 = new Invoice("Jenkins", 1);
	private static Invoice jenkins2 = new Invoice("Jenkins", 5);
	private static Invoice jenkins3 = new Invoice("Jenkins", -12);

	@BeforeClass
	public static void init() {
		invoices.add(eclipse1);
		invoices.add(eclipse2);
		invoices.add(redHat);
		invoices.add(apache);
		invoices.add(springSource);
		invoices.add(jenkins1);
		invoices.add(jenkins2);
	}

	@Test
	public void shouldFilterInvoicesMadeByEclipseFoundation() {
		List<Invoice> actual = new InvoiceServiceV1().filterEclipseInvoices(invoices);
		List<Invoice> expected = Arrays.asList(eclipse1, eclipse2);
		assertThat(actual, is(expected));
	}

	@Test
	public void shouldFilterInvoicesMadeBySpringSource() {
		List<Invoice> actual = new InvoiceServiceV2().filterInvoicesByClient(invoices, "Spring Source");
		List<Invoice> expected = Arrays.asList(springSource);
		assertThat(actual, is(expected));
	}

	@Test
	public void shouldFilterInvoicesGivenAComplexQuery() {
		List<Invoice> actual = new InvoiceServiceV3().filterInvoicesComplex(invoices, "Jenkins", 4.0, false);
		List<Invoice> expected = Arrays.asList(jenkins2);
		assertThat(actual, is(expected));
	}

//	@Test
//	public void shouldFilterGivenPredicates() {
//		List<Invoice> actual = new InvoiceServiceV8().filterInvoices(invoices,
//				new JenkinsPredicate().and(new MoreThanPredicate(4)));
//		List<Invoice> expected = Arrays.asList(jenkins2);
//		assertThat(actual, is(expected));
//	}

	private class JenkinsPredicate implements Predicate<Invoice> {
		@Override
		public boolean test(Invoice invoice) {
			return invoice.getClass().equals("Jenkins");
		}
	}

	public class MoreThanPredicate implements Predicate<Invoice> {
		private double amount;

		public MoreThanPredicate(double amount) {
			this.amount = amount;
		}

		@Override
		public boolean test(Invoice invoice) {
			return invoice.getAmount() > amount;
		}
	}

//	@Test
//	public void shouldAlsoFilterWithLambda() {
//		List<Invoice> actual = new InvoiceServiceV8().filterInvoices(invoices,
//				invoice -> invoice.getClient().equals("Jenkins") && invoice.getAmount() > 4);
//		List<Invoice> expected = Arrays.asList(jenkins2);
//		assertThat(actual, is(expected));
//	}
}
