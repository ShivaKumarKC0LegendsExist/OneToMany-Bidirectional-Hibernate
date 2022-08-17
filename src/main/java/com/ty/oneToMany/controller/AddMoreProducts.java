package com.ty.oneToMany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.oneToMany.dto.Brand;
import com.ty.oneToMany.dto.Product;

public class AddMoreProducts {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Brand brand = manager.find(Brand.class, 1);
		Product product1 = new Product();
		product1.setName("mobile");
		product1.setBrand(brand);
		product1.setCost(1200);
		Product product2 = new Product();
		product2.setName("Oven");;
		product2.setCost(1500);
		product2.setBrand(brand);
		List<Product> brands = brand.getProduct();
		brands.add(product2);
		brands.add(product1);
		brand.setProduct(brands);
		
		transaction.begin();
		manager.persist(product1);
		manager.persist(product2);
		transaction.commit();
	}

}
