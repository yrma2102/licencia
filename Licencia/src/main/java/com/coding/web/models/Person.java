package com.coding.web.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="persons")
public class Person {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 5, max = 20)
	private String firstName;
	
	@Size(min = 5, max = 20)
	private String lastName;
	
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private License license;
    
    public Person () { }
	

	public Person(String first_name, String last_name, Date created_at, Date updated_at) {
		this.firstName = first_name;
		this.lastName = last_name;
		this.createdAt = created_at;
		this.updatedAt = updated_at;
	}

	// GETTERS & SETTERS
	public License getLicense() {
		return license;
	}
	
	public void setLicense(License license) {
		this.license = license;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String last_name) {
		this.lastName = last_name;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreated_at(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updated_at) {
		this.updatedAt = updated_at;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
