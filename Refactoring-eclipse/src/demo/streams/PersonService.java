package demo.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonService {
	private List<Person> persons;

	public PersonService() {
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

	public Map<Integer, List<Person>> getPersonsByAge() {
		Map<Integer, List<Person>> mapByAge = new HashMap<>();
		for (Person p : persons) {
			if (!mapByAge.containsKey(p.getAge())) {
				mapByAge.put(p.getAge(), new ArrayList<>());
			}
			mapByAge.get(p.getAge()).add(p);
		}
		return mapByAge;
	}

	public String listFirstNamesFromFamily(String family) {
		List<String> matchingFirstNames = new ArrayList<String>();
		for (Person p : persons) {
			if (family.equals(p.getLastName())) {
				matchingFirstNames.add(p.getFirstName());
			}
		}
		StringBuilder firstNames = new StringBuilder();
		for (String firstName : matchingFirstNames) {
			if (firstNames.length() > 0) {
				firstNames.append(", ");
			}
			firstNames.append(firstName);
		}
		return firstNames.toString();
	}

	public List<Person> personsSortedByFirstNameAndLastName() {
		List<Person> result = new ArrayList<>(persons);
		result.sort(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				int firstNameComparison = o1.getFirstName().compareTo(o2.getFirstName());
				if (firstNameComparison != 0) {
					return firstNameComparison;
				} else {
					return o1.getLastName().compareTo(o2.getLastName());
				}
			}
		});
		return result;
	}
}