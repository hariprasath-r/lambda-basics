package in.hp.java.lambdabasics.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class LambdaBasicsExercise {

	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(
				new Person("Hariprasath", "R", 24),
				new Person("Suppriya", "V", 25),
				new Person("Charulatha", "R", 23),
				new Person("Ravi", "S", 61),
				new Person("Geetha", "Ravichandran", 59)
				);

		//Sort list by Lastname
		Collections.sort(personList, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
		
		
		System.out.println("==========================");
		
		//method that prints all the elements
		printList(personList);
		
		System.out.println("===========================");
		
		//create method that prints all lastnames starting with R
		//printLastNameStartingWithFirstArgument("R", personList);
		printBasedOnCondition(personList, new Condition() {
			/*
			 * Implementation to print all persons, who has lastname starting with R
			 * (non-Javadoc)
			 * @see in.hp.java.lambdabasics.exercise.LambdaBasicsExercise.Condition#test(in.hp.java.lambdabasics.exercise.Person)
			 */
			@Override
			public boolean test(Person p) {
				if(p.getLastName().startsWith("R"))
					return true;
				return false;
			}
		});
		
		System.out.println("==========================");
		
		printBasedOnCondition(personList, new Condition() {
			/*
			 * Implementation to print all persons, whose firstname starts with H
			 * (non-Javadoc)
			 * @see in.hp.java.lambdabasics.exercise.LambdaBasicsExercise.Condition#test(in.hp.java.lambdabasics.exercise.Person)
			 */
			@Override
			public boolean test(Person p) {
				if(p.getFirstName().startsWith("H"))
					return true;
				return false;
			}
		});
		
	}
	
	/**
	 * Tried sorting using Map, Not working
	 * @param personList
	 * @return
	 */
	static List<Person> sortByLastName(List<Person> personList) {
		SortedMap<String, Person> personLastNameMap = new TreeMap<>();
		for (Person person : personList) {
			personLastNameMap.put(person.getLastName() + person.getFirstName(), person);
		}
		return new ArrayList<Person>(personLastNameMap.values());
	}
	
	static void printList(List<Person> personList) {
		for (Person person : personList) {
			System.out.println(person);
		}
	}
	
	/**
	 * Non interface method of implementation, what if we want to filter based on firstname
	 * Since we are not getting that flexibility, we are going for interface approach
	 * @param lastNameBeginingLetter
	 * @param personList
	 */
	static void printLastNameStartingWithFirstArgument(String lastNameBeginingLetter, List<Person> personList) {
		for (Person person : personList) {
			if(person.getLastName().startsWith(lastNameBeginingLetter))
				System.out.println(person);
		}
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
