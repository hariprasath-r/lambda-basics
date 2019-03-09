package in.hp.java.lambdabasics.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import in.hp.java.lambdabasics.exercise.Person;

public class FunctionalInterfaceExample {

	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(
				new Person("Hariprasath", "R", 24),
				new Person("Suppriya", "V", 25),
				new Person("Charulatha", "R", 23),
				new Person("Ravi", "S", 61),
				new Person("Geetha", "Ravichandran", 59)
				);

		//Sort list by Lastname
		/*
		 * Lambda expression of the same
		 * Collections.sort(personList, (Person p1, Person p2) -> p1.getLastName().compareTo(p2.getLastName()));
		 * 
		 * Since java knows the type by seeing personList, the type is inferred and no need to be passed
		 */
		Collections.sort(personList, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		
		System.out.println("==========================");
		
		//method that prints all the elements
		/*
		 * making the Condition interface's test method always return true
		 * 
		 * printBasedOnCondition(personList, p -> {
		 * 		return true;
		 * });
		 */
		performBasedOnCondition(personList, p -> true, p -> System.out.println(p));
		
		System.out.println("===========================");
		
		//create method that prints all lastnames starting with R
		performBasedOnCondition(personList, p -> {
			if(p.getLastName().startsWith("R"))
				return true;
			return false;
		}, p -> System.out.println(p));
		
		System.out.println("==========================");
		
		/*
		 * Lambda expression to print names starting with H
		 */
		performBasedOnCondition(personList, p -> p.getFirstName().startsWith("H"), p -> System.out.println(p.getFirstName()));

	}
	
	/**
	 * @param personList
	 * @param predicate - Out of the box Functional Interface that accepts an object and return boolean
	 * @param consume - Out of the box Functional Interface that accepts an object and return void 
	 */
	static void performBasedOnCondition(List<Person> personList, Predicate<Person> predicate, Consumer<Person> consume) {
		for (Person p : personList) {
			//Checking for implemented condition
			if(predicate.test(p))
				consume.accept(p);
		}
	}

}