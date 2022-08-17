package com.ty.oneToMany.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.oneToMany.dto.Sim;

public class GetSimById {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = entityManagerFactory.createEntityManager();
		
		Sim sim = manager.find(Sim.class, 3);
		System.out.println(sim);
	}

}
