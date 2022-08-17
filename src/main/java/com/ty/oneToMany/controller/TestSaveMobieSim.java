package com.ty.oneToMany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.oneToMany.dto.Mobile;
import com.ty.oneToMany.dto.Sim;

public class TestSaveMobieSim {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Mobile mobile = new Mobile();
		mobile.setBrand("Bomb Mi");
		mobile.setCost(10000);


		Sim sim1 = new Sim();
		sim1.setImrc(78654);
		sim1.setProvider("Airtel");
		sim1.setMobile(mobile);

		Sim sim2 = new Sim();
		sim2.setImrc(98765);
		sim2.setProvider("BSNL");
		sim2.setMobile(mobile);


		Mobile mobile1 = new Mobile();
		mobile1.setBrand("Nokia");
		mobile1.setCost(12000);

		
		Sim sim3 = new Sim();
		sim3.setImrc(7898723);
		sim3.setProvider("Jio");
		sim3.setMobile(mobile1);
		
		Sim sim4 = new Sim();
		sim4.setImrc(923465);
		sim4.setProvider("V1");
		sim4.setMobile(mobile1);
		

		// mobile1.setSim(list1);

		transaction.begin();
		manager.persist(mobile);
		manager.persist(mobile1);
		manager.persist(sim1);
		manager.persist(sim2);
		manager.persist(sim3);
		manager.persist(sim4);
		transaction.commit();

	}

}
