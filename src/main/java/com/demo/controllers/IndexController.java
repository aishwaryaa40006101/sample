package com.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.entities.Product;
import com.demo.repositories.ProductRepository;
import com.demo.services.ProductService;

@Controller
@RequestMapping(value= {"","product"})
public class IndexController {
	
	@Autowired
	private ProductRepository productService;
	
	
	
	@GetMapping("/products")
	public String products(ModelMap modelMap) {
		modelMap.put("products",productService.findAll());
		return "product/products";
	}
	
	@RequestMapping(value="delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		//castRepository.saveAll(movie.getCast());
		//castService.deleteByMovie(id);
		productService.deleteById(id);
		
		//System.out.print
		return "redirect:/product/products";
	}


	@RequestMapping(value="index",method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("product",new Product());
		//System.out.print(product);
		
		return "product/index";
	}
	
	/*
	 * @PostMapping(value="/index") public String index(@ModelAttribute("product")
	 * Product product) {
	 * 
	 * productService.save(product); return "redirect:/index";
	 */
	@PostMapping(value="index")
	public String index(@ModelAttribute("product") Product product) {
		
		productService.save(product);
		return "product/index";
	}
	
	

	@RequestMapping(value="update/{id}",method=RequestMethod.GET)
	public String update(ModelMap modelMap,@PathVariable String id) {
		//product product1=productService.findById(id);
		modelMap.put("product",new Product());
		return "product/update";
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(@ModelAttribute("product") Product product){
		
		Product product1=productService.getOne(product.getId());
		
		product1.setId(product.getId());
		product1.setName(product.getName());
		product1.setCost(product.getCost());
		productService.save(product1);
		return "redirect:/products";
	}
}
