package com.java.practice5;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import lombok.Data;
import lombok.NoArgsConstructor;

public class Main {

	static SessionFactory sf= null;
	
	static {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate-properties.xml");
		sf= cfg.buildSessionFactory();
	}
	
public static void main(String[] args) {
		
		Citizen c1 = new Citizen(1, "Marc", 22);
		
		
		Passport p = new Passport(1, "USA", c1);
		Passport p1 = new Passport(2, "Jamaica", c1);
		Passport p2 = new Passport(3, "Haiti", c1);
		
		try {
			Session s = sf.openSession();
			s.beginTransaction();
			s.save(c1);
			s.save(p);
			s.save(p1);
			s.save(p2);
		
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
class Passport{
	@Id
	int id;
	String country;
	@ManyToOne
	Citizen citizen;
	
	public Passport(int id, String country, Citizen citizen) {
		this.id = id;
		this.country = country;
		this.citizen = citizen;
	}
}

@Entity
@Data
@NoArgsConstructor
class Citizen {

	@Id
	int id;
	String name;
	int age;
	
	public Citizen(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
}
