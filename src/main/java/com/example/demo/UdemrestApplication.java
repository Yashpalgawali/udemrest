package com.example.demo;

//import java.sql.SQLSyntaxErrorException;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Predicate;
//import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UdemrestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UdemrestApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//printnums(Arrays.asList(1,5,4,78,98,654,47));
		
//		List<String> flist = Arrays.asList("Banana","Mango","Guava","Berry");
//		Stream<String> fstr = flist.stream();
//		Predicate<? super String> predicate = fruit -> fruit.startsWith("b");
//		Optional<String> opt = fstr.filter(predicate ).findFirst();
//		//Optional<String> opt = fstr.filter(fruit -> fruit.startsWith("B")).findFirst();
//		System.err.println(opt);
//		System.err.println(opt.isEmpty());
//		System.err.println(opt.isPresent());
//		System.err.println(opt.get());
	}

//	private void printnums(List<Integer> asList) {
//		
//		System.err.println("Using Functional Programming\n");
//		//asList.stream().forEach(UdemrestApplication::print);
//		System.err.println("Even Numbers\n");
//		asList.stream().filter(e->e%2==0).forEach(System.out::println);
//		
//		System.err.println("ODD Numbers\n");
//		asList.stream().filter(e->e%2!=0).forEach(System.err::println);
//		
////		System.err.println("Printing courses\n");
//		List<String> str = Arrays.asList("PUss in Boots","Bootstrap","Spring boot","MVC");
////		str.stream().forEach(System.out::println);
//	
////		System.err.println("Printing courses containing word boot\n");
////		str.stream().filter(st->st.contains("Boot")).forEach(System.err::println);
////		
////		System.out.println("Printing courses containing at Least 4 letters\n");
////		System.out.println("\nCount  = "+ str.stream().filter(st->st.length()>=4).count());
////		
////		System.err.println("Cube of each number using Map function \n");
////		asList.stream().filter(num->num%2!=0).map(num -> num * num *num).forEach(System.err::println);
////		
//		System.err.println("Print number of characters in a string\n");
//		str.stream().map(st->st+" = "+st.length()).forEach(System.err::println);
//		
//	} 
//	
//	private static void print(int num)
//	{
//		System.err.println("Number is "+num);
//	}
}
