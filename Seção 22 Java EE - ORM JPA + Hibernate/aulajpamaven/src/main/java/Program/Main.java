package Program;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import models.entities.People;

public class Main {

	public static void main(String[] args) {
		People p1 = new People(null, "Carlos da Silva", "carlos@gmail.com");
		People p2 = new People(null, "Joaquim Torres", "joaquim@gmail.com");
		People p3 = new People(null, "Ana Maria", "ana@gmail.com");
		
		new Persistence();
		EntityManager entityManager = Persistence.createEntityManagerFactory("exemplo-jpa").createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(p1);
		entityManager.persist(p2);
		entityManager.persist(p3);
		entityManager.getTransaction().commit();
		
		System.out.println("persistence !!"); 
	}

}
