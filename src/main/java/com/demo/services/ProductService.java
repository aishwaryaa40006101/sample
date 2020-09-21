package com.demo.services;



import org.springframework.stereotype.Service;

import com.demo.entities.Product;

@Service
public interface ProductService {
	
	public Product save(Product movie);

	public Product getOne(int id);

	public void deleteById(int id);

	public Object findAll();

	//public Product findById(int id);


}
