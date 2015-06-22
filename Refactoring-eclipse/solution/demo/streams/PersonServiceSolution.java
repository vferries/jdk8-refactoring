package demo.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonServiceSolution {
	private List<Person> persons;

	public PersonServiceSolution() {
		persons = new ArrayList<>();
		persons.add(new Person("Vincent", "Ferries", 30));
		persons.add(new Person("Jean", "Dupond", 62));
		persons.add(new Person("Jean", "Dupont", 54));
		persons.add(new Person("Violette", "Toulouse", 30));
		persons.add(new Person("Vincent", "Privat", 28));
		persons.add(new Person("Julien", "Herbert", 30));
		persons.add(new Person("Virginie", "Zubrowska", 30));
		persons.add(new Person("Juliette", "Binocle", 30));
		persons.add(new Person("Colin", "Ferries", 30));
		persons.add(new Person("Célia", "Ferries", 12));
		persons.add(new Person("Antony", "Ferries", 14));
		persons.add(new Person("Alexis", "Ferries", 11));
		persons.add(new Person("Hervé", "Dupré", 43));
		persons.add(new Person("Chloé", "Vermuso", 22));
		persons.add(new Person("Grégory", "Dupin", 35));
		persons.add(new Person("Viviane", "Laurent", 54));
	}

	public Map<Integer, List<Person>> getPersonsByAge2() {
		Map<Integer, List<Person>> mapByAge = new HashMap<>();
		persons.forEach(p -> mapByAge.computeIfAbsent(p.getAge(),
				ArrayList::new).add(p));
		return mapByAge;
	}

	public Map<Integer, List<Person>> getPersonsByAge() {
		return persons.stream().collect(Collectors.groupingBy(Person::getAge));
	}

	public String listFirstNamesFromFamilyJava7(String family) {
		List<String> matchingFirstNames = new ArrayList<>();
		for (Person p : persons) {
			if (family.equals(p.getLastName())) {
				matchingFirstNames.add(p.getFirstName());
			}
		}
		String firstNames = "";
		for (String firstName : matchingFirstNames) {
			if (!"".equals(firstNames)) {
				firstNames += ", ";
			}
			firstNames += firstName;
		}
		return firstNames;
	}

	public String listFirstNamesFromFamilyJava8(String family) {
		return persons.stream().filter(p -> family.equals(p.getLastName()))
				.map(Person::getFirstName).collect(Collectors.joining(", "));
	}

	public List<Person> personsSortedByFirstNameAndLastNameJava8() {
		return persons
				.stream()
				.sorted(Comparator.comparing(Person::getFirstName)
						.thenComparing(Person::getLastName))
				.collect(Collectors.toList());
	}

}