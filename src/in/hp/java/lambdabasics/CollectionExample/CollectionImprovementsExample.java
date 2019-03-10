package in.hp.java.lambdabasics.CollectionExample;

import java.util.Arrays;
import java.util.List;

import in.hp.java.lambdabasics.exercise.Person;

public class CollectionImprovementsExample {

	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(
				new Person("Hariprasath", "R", 24),
				new Person("Suppriya", "V", 25),
				new Person("Charulatha", "R", 23),
				new Person("Ravi", "S", 61),
				new Person("Geetha", "Ravichandran", 59)
				);
		
		System.out.println("***For loop***");
		for (int i = 0; i < personList.size(); i++) {
			System.out.println(personList.get(i));
		}
		
		System.out.println("***For each / For in loop***");
		for (Person person : personList) {
			System.out.println(person);
		}
		
		System.out.println("***For each in java 8, using lambda***");
		personList.forEach((p) -> System.out.println(p));
		
		System.out.println("***For each in java 8, using method reference***");
		personList.forEach(System.out::println);
	}
	
}
