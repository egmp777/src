package com.cc.example.pagination;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.List;
import java.util.ArrayList;
import junit.framework.*;
import junit.runner.*;
import javax.persistence.Entity;





public class CreateEntity {
	public static void main(String[] args) {
	       CreateEntity createEntity = 
	          new CreateEntity();
	        
	        try {
	     // createEntity.createPerson("Melanie Griff",20 , "NE Andreson Ln, Los Angeles");
	           
	        //Employee2 employee2 = createEntity.createEmployee("David", "Hilbert", "dh@mail.com");
	            ///Employee2 employee3 = createEntity.createEmployee("Terry", "Dactyll", "td@gmail.com");
	        	//Employee2 employee4 = createEntity.createEmployee("Aby", "Bell", "ab@gmail.com");
	           // Employee2 employee5 = createEntity.createEmployee("Max", "Kan", "mk@gmail.com");
	        	
	         // createEntity.createDepartment("ACCOUNTS");
	        	//createEntity.createDepartment("MARKETING");
	        	//createEntity.createDepartment("FINANCE");
	        	//createEntity.createDepartment("PRODUCTION");
	        	//createEntity.createDepartment("SALES");
	        	//createEntity.createDepartment("HHRR");

	          // createEntity.addEmployeeToDept(employee1, "SOFTWARE");
	           // createEntity.addEmployeeToDept(employee2, "SOFTWARE");
	           //createEntity.addEmployeeToDept(employee3, "ACCOUNTS");
	        	//createEntity.addEmployeeToDept(employee5, "ACCOUNTS");
	        	//createEntity.getAllEmployees();
	        	createEntity.getPersonsWithAddresses();
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		}

		public  void createPerson(String personName, int addressId, String addressName) {
			// TODO Auto-generated method stub
			try {
	            // Start EntityManagerFactory
	            EntityManagerFactory emf = Persistence
	                    .createEntityManagerFactory("punit");

	            // First unit of work
	            EntityManager entityManager = emf.createEntityManager();
	            EntityTransaction entityTransaction = entityManager
	                    .getTransaction();
	            entityTransaction.begin();
	            
	            Person person = new Person(personName);
	          person.getAddress().setName(addressName);
	          person.getAddress().setId(addressId);
	          //  person.setAddress(new Address (addressName, addressId));
	          // person.setAddress(address);
	            entityManager.persist(person);
              // entityManager.persist(address);
	            entityTransaction.commit();
	            entityManager.close();
	            emf.close();
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }     
		}

		
		public Address createAddress(String name, int Id) {
			// TODO Auto-generated method stub
			
			try {
	            // Start EntityManagerFactory
	            EntityManagerFactory emf = Persistence
	                    .createEntityManagerFactory("punit");

	            // First unit of work
	            EntityManager entityManager = emf.createEntityManager();
	            EntityTransaction entityTransaction = entityManager
	                    .getTransaction();
	            entityTransaction.begin();
	            
	            Address address = new Address(name, Id); 
	            entityManager.persist(address);

	            entityTransaction.commit();
	            entityManager.close();
	            emf.close();
	            
	            return address;
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

			return null;
		}
		
		public void getPersonsWithAddresses(){
		try {
            // Start EntityManagerFactory
            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("punit");

            // First unit of work
            EntityManager entityManager = emf.createEntityManager();
            EntityTransaction entityTransaction = entityManager
                    .getTransaction();
            entityTransaction.begin();
          //  Query query = 
            //        entityManager.createNamedQuery("findDepartmentByName");
              //  query.setParameter("name", "ACCOUNTS");
         // Query query = 
          // entityManager.createQuery("From Person");
          // Query query = entityManager.createQuery("Select p from Person as p " +
            //      "left outer join fetch p.address order by p.address.Id");
                 Query query = entityManager.createQuery("Select p from Person as p order by p.address.Id");
            //Query query = entityManager.createQuery("Select p from Person as p where p.address.Id=:Id");
            //query.setParameter("Id", 7);
            //query.setFirstResult(0);
           query.setMaxResults(5);
           //List <Address> address = (List<Address>)query.getResultList();
            List <Person> persons =(List<Person>) query.getResultList();
            for(Person per:persons){
            	
            	
            
                System.out.println(
                        "Person Name: " + per.getName()
                     + ", Person Address: " + per.getAddress()
                         
                       
                      );
                
            }
           
            
          

            //entityTransaction.commit();
            entityManager.close();
            emf.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }       
	}
		
		public List <Person> getListsOfPersonsWithAddresses(){
			 List <Person> persons = new ArrayList();
			try {
            // Start EntityManagerFactory
            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("punit");

            // First unit of work
            EntityManager entityManager = emf.createEntityManager();
            EntityTransaction entityTransaction = entityManager
                    .getTransaction();
            entityTransaction.begin();
            
           
          //  Query query = 
            //        entityManager.createNamedQuery("findDepartmentByName");
              //  query.setParameter("name", "ACCOUNTS");
         // Query query = 
          // entityManager.createQuery("From Person");
          // Query query = entityManager.createQuery("Select p from Person as p " +
            //      "left outer join fetch p.address order by p.address.Id");
                 // Query query = entityManager.createQuery("Select p from Person as p");
           Query query = entityManager.createQuery("Select p from Person as p where p.address.Id=:Id");
           query.setParameter("Id", 7);
          query.setFirstResult(0);
           query.setMaxResults(2);
           
           //List <Address> address = (List<Address>)query.getResultList();
             persons =(List<Person>) query.getResultList();
            for(Person per:persons){
            	
            	
            
                System.out.println(
                        "Person Name: " + per.getName()
                     + ", Person Address: " + per.getAddress()
                         
                       
                      );
                
            }
           
            
          

            //entityTransaction.commit();
            entityManager.close();
            emf.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   
		return persons;
	}	
		
		public List <Address> getListsOfAddresses(){
			 List <Address> addresses = new ArrayList();
			try {
           // Start EntityManagerFactory
           EntityManagerFactory emf = Persistence
                   .createEntityManagerFactory("punit");

           // First unit of work
           EntityManager entityManager = emf.createEntityManager();
           EntityTransaction entityTransaction = entityManager
                   .getTransaction();
           entityTransaction.begin();
           
          
          Query query = 
                entityManager.createNamedQuery("findAddressById");
              query.setParameter("Id", 7);
        
          
                // Query query = entityManager.createQuery("Select p from Person as p");
         query.setFirstResult(0);
          query.setMaxResults(5);
          //List <Address> address = (List<Address>)query.getResultList();
            addresses =(List<Address>) query.getResultList();
           for(Address ad:addresses){
           	
           	
           
               System.out.println(
                       "Person Name: " + ad.getName()
                    + ", Person Address: " + ad.getId()
                        
                      
                     );
               
           }
          
           
         

           //entityTransaction.commit();
           entityManager.close();
           emf.close();
       } catch (Exception e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }   
		return addresses;
	}	
		
}
