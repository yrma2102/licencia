package com.coding.web.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coding.web.models.License;

public interface ILincenseRepository extends CrudRepository<License, Long> {
	public List<License> findAll();
	
	public License findTopByOrderByNumberDesc();
}
