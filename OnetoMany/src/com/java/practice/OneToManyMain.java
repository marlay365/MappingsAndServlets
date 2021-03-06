package com.java.practice;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lombok.Data;
import lombok.NoArgsConstructor;

public class OneToManyMain {

	static SessionFactory sf= null;
	
	static {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate-properties.xml");
		sf= cfg.buildSessionFactory();
	}
	
	public static void main(String[] args) {
		
		Car car1 = new Car(101, "Honda", 2014);
		Car car2 = new Car(102,"Mercedes", 2016);
		List<Car> cars = Arrays.asList(car1, car2);
		Person p1 = new Person(1, "Marc", "Male", cars);
		
		try {
			Session s = sf.openSession();
			s.beginTransaction();
			s.save(car1);
			s.save(car2);
			s.save(p1);
		
			s.getTransaction().commit();
			s.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}


@Entity
@Data
@NoArgsConstructor
class Person{
	
	@Id
	int id;
	String name;
	String gender;
	@OneToMany
	List<Car> cars;
	public Person(int id, String name, String gender, List<Car> cars) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.cars = cars;
	}
	
}

@Entity
@Data
@NoArgsConstructor
class Car{
	
	@Id
	int id;
	String brand;
	int year;
	
	public Car(int id, String brand, int year) {
		this.id = id;
		this.brand = brand;
		this.year = year;
	}
	
}
