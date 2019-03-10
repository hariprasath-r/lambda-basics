package in.hp.java.lambdabasics.CollectionExample;

import java.util.Arrays;
import java.util.List;

import in.hp.java.lambdabasics.exercise.Person;

public class StreamsExample {

	public static void main(String[] args) {
		
		long startTime = 0;
		
		List<Person> personList = Arrays.asList(
				new Person("Hariprasath", "R", 24),
				new Person("Suppriya", "V", 25),
				new Person("Charulatha", "R", 23),
				new Person("Ravi", "S", 61),
				new Person("Geetha", "Ravichandran", 59)
				);
		
		/*
		 * Previously we were doing the below operations in the Collection using Functional Interfaces
		 * 1. Filtering the person, whose last name starts with certain letter
		 * 2. Printing that list
		 * 
		 * here we are going to use the same using streams
		 * 
		 * filter - accepts a Predicate functional interface, which has a method that returns a boolean value for a condition
		 * foreach - accepts a Consumer
		 */
		personList.stream()
			.filter(p -> p.getLastName().startsWith("R"))
			.forEach(p -> System.out.println(p.getFirstName()));
		
		/*
		 * There are various operation we can do with streams, and also a stream has 3 elements
		 * 1. Source - which is a collection
		 * 2. Operation - which is being performed to the stream
		 * 3. Terminal - end condition, or what to do with the performed stream
		 */
		long count = personList.stream().filter(p -> p.getFirstName().startsWith("H")).count();
		System.out.println(count);
		
		
		startTime= System.currentTimeMillis();
		personList.stream()
			.filter(p -> p.getLastName().startsWith("R"))
			.forEachOrdered(p -> System.out.println(p));
		System.out.println("Time taken :: " + (System.currentTimeMillis() - startTime));
		
		startTime= System.currentTimeMillis();
		personList.parallelStream()
			.filter(p -> p.getLastName().startsWith("R"))
			.forEachOrdered(p -> System.out.println(p));
		System.out.println("Time taken :: " + (System.currentTimeMillis() - startTime));
	}
}
