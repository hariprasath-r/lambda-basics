package in.hp.java.lambdabasics.MethodReference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import in.hp.java.lambdabasics.exercise.Person;

public class MethodReferenceExample2 {

	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(
				new Person("Hariprasath", "R", 24),
				new Person("Suppriya", "V", 25),
				new Person("Charulatha", "R", 23),
				new Person("Ravi", "S", 61),
				new Person("Geetha", "Ravichandran", 59)
				);

		//method that prints all the elements
		/*
		 * making the Condition interface's test method always return true
		 * 
		 * printBasedOnCondition(personList, p -> {
		 * 		return true;
		 * });
		 */
		performBasedOnCondition(personList, p -> true, p -> System.out.println(p));
		
		System.out.println("===================================================");
		
		/*
		 * The above can be replaced with Method Reference because
		 * 1. The lambda expression takes in one arg and calls a method with one arg
		 * 
		 * p -> System.out.println(p) === System.out::println
		 * 
		 * System.out returns an object and calls a instance method println
		 */
		performBasedOnCondition(personList, p -> true, System.out::println);
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
