import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import demo.predicates.Invoice;
import demo.predicates.InvoiceService;

public class InvoiceServiceTest {
	private static InvoiceService service;
	private static List<Invoice> invoices = new ArrayList<>();
	private static Invoice eclipse1 = new Invoice("Eclipse Foundation", 134.50);
	private static Invoice eclipse2 = new Invoice("Eclipse Foundation", 200.00);
	private static Invoice redHat = new Invoice("Red Hat", 1000.00);
	private static Invoice apache = new Invoice("Apache", 42);
	private static Invoice springSource = new Invoice("Spring Source", 60.30);
	private static Invoice jenkins1 = new Invoice("Jenkins", 0);
	private static Invoice jenkins2 = new Invoice("Jenkins", -12);

	@BeforeClass
	public static void init() {
		service = new InvoiceService();
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
		List<Invoice> actual = service.filterEclipseInvoices(invoices);
		List<Invoice> expected = Arrays.asList(eclipse1, eclipse2);
		assertThat(actual, is(expected));
	}

}
