package demo.streams;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PersonServiceTest {
	private PersonService service;

	@Before
	public void initTest() {
		service = new PersonService();
	}

	@Test
	public void nobodyShouldBe0_3YearsOld() {
		assertThat(service.getPersonsByAge().get(3), is(nullValue()));
	}

	@Test
	public void thereShouldBe6_30YearsOld() {
		assertThat(service.getPersonsByAge().get(30).size(), is(6));
	}

	@Test
	public void shouldListFerriesFamily() {
		String firstNamesFromFerriesFamily = service.listFirstNamesFromFamily("Ferries");
		assertThat(firstNamesFromFerriesFamily, containsString("Vincent"));
		assertThat(firstNamesFromFerriesFamily, containsString("Alexis"));
		assertThat(firstNamesFromFerriesFamily, containsString("Célia"));
		assertThat(firstNamesFromFerriesFamily, containsString("Antony"));
		assertThat(firstNamesFromFerriesFamily.length(), is(37));
	}

	@Test
	public void shouldBeSortedByFirstAndLastName() throws Exception {
		Person alexis = new Person("Alexis", "Ferries", 11);
		Person antony = new Person("Antony", "Ferries", 14);
		Person chloé = new Person("Chloé", "Vermuso", 22);
		List<Person> actual = service.personsSortedByFirstNameAndLastName();
		assertThat(actual.get(0), equalTo(alexis));
		assertThat(actual.get(1), equalTo(antony));
		assertThat(actual.get(2), equalTo(chloé));
	}
}