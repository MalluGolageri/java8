package com.java8.lambda;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class BasicLamdaExpressions {


	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Malu", "Golageri"),
				new Person("Satish", "Biradar"),
				new Person("Roopesh", "Itagi"),
				new Person("Guru", "Bijapur"));
		//filter people whose name starts with B
		people.parallelStream()
				.filter(p-> p.getLastName().startsWith("B"))
				.forEach(System.out::println);

		System.out.println("Sort based on last name");
		// sort based on lastName #approach 1
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}

		});
		// sort based on lastName #approach 2 using lamda expressions
		Collections.sort(people, (p1,p2)->p1.getLastName().compareTo(p2.getLastName()));

		//print collection using method references
		people.forEach(System.out::println);

		//Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		System.out.println("display all");

		printAll(people, p -> true,System.out::println);


		System.out.println("display first name starts with M");
		printAll(people, p->p.getFirstName().startsWith("M"), p->System.out.println(p.getFirstName()));
		System.out.println("display last name starts with B");
		printAll(people, p -> p.getLastName().startsWith("B"), p -> System.out.println(p.getLastName()));


		System.out.println("=====");


	}

	private static void someUser(User user){

	}






	private static Predicate<Person>  printAll(List<Person> people, Predicate<Person> condition, Consumer<Person> consumer) {
		for (Person person : people) {
			if (condition.test(person))
				consumer.accept(person);
		}
		return condition;
	}

}

@FunctionalInterface
interface User {
	public Predicate test(Integer integer);
}
