package in.hp.java.lambdabasics.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaBasicsExerciseJava8 {

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
		printBasedOnCondition(personList, p -> true);
		
		System.out.println("===========================");
		
		//create method that prints all lastnames starting with R
		printBasedOnCondition(personList, p -> {
			if(p.getLastName().startsWith("R"))
				return true;
			return false;
		});
		
		System.out.println("==========================");
		
		/*
		 * Lambda expression to print names starting with H
		 */
		printBasedOnCondition(personList, p -> p.getFirstName().startsWith("H"));

	}
	
	/**
	 * Here we can have any number of implementations, either anonymously or class implementation
	 * @author Hariprasath
	 *
	 */
	interface Condition {
		public boolean test(Person p);
	}
	
	static void printBasedOnCondition(List<Person> personList, Condition c) {
		for (Person p : personList) {
			//Checking for implemented condition
			if(c.test(p))
				System.out.println(p);
		}
	}

}
