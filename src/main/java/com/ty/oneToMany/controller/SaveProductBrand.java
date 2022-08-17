package com.ty.oneToMany.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.oneToMany.dto.Brand;
import com.ty.oneToMany.dto.Product;

public class SaveProductBrand {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Brand brand1 = new Brand();
		brand1.setName("LG");
		brand1.setRating("5 STAR");
		
		Brand brand2 = new Brand();
		brand2.setName("Samsung");
		brand2.setRating("5 STAR");
		
		Product product1 = new Product();
		product1.setName("TV");;
		product1.setCost(12000);
		product1.setBrand(brand1);
		
		Product product2 = new Product();
		product2.setName("Mobile");;
		product2.setCost(15000);
		product2.setBrand(brand1);
		
		Product product3 = new Product();
		product3.setName("Refigirator");;
		product3.setCost(12000);
		product3.setBrand(brand2);
		
		Product product4 = new Product();
		product4.setName("Mobile");;
		product4.setCost(15000);
		product4.setBrand(brand2);
		
		transaction.begin();
		manager.persist(brand1);
		manager.persist(brand2);
		manager.persist(product1);
		manager.persist(product2);
		manager.persist(product3);
		manager.persist(product4);
		transaction.commit();
	}

}
