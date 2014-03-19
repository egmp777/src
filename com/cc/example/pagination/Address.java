package com.cc.example.pagination;

import java.io.Serializable;
import java.lang.String;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;
import javax.persistence.ManyToOne;


/**
 * Entity implementation class for Entity: Address
 *
 */
@Entity
@Table(name="ADDRESS")
@NamedQuery(
        name="findAddressById",
        query="select OBJECT(a) from Address a where a.Id = :Id")
public class Address implements Serializable {
	@Id //@GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="ID")
	private int Id;   
	@Column(name="NAME")
	private String name;
	private static final long serialVersionUID = 1L;
	
	public Address() {
		super();
	}   
	
	public Address(String name2, int Id2) {
		// TODO Auto-generated constructor stub
		this.name = name2;
		this.Id = Id2;
	}
	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
    public String toString() {
        return "Address[name=" + name+ "]";
    }
}
