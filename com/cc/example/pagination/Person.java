package com.cc.example.pagination;


import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Person
 *
 */
@Entity
@Table(name="PERSON")

public class Person implements Serializable {

	   
	@Id
	@Column(name="ID")
	private int ID;
	@Column(name="NAME")
	private String name;
	private static final long serialVersionUID = 1L;
	 @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	 @JoinColumn(name="ADDR_ID")
	 private Address address = new Address();
	
	public Person() {
		super();
	}   
	public Person(String personName) {
		// TODO Auto-generated constructor stub
		this.name = personName;
		
	}
	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(Address address2){
		this.address = address2;
	}
   public Address getAddress(){
	   
	   return this.address;
   }
   
}
