package com.admin.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.admin.product.dto.ProductPojo;


import com.admin.product.service.ProductService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService service;
	
	@PostMapping("/saveProduct")
	@ResponseBody
	public ResponseEntity<Object> saveProduct(@RequestBody ProductPojo pojo)
	{
		System.out.println("save Product");
		if(pojo.getId()!=null && pojo.getId() >0)
		{
			return service.updateProduct(pojo);
		}
		return service.saveProduct(pojo);
		
	}
	
	@PostMapping("/editProduct")
	@ResponseBody
	public ResponseEntity<Object> editProduct(@RequestBody ProductPojo pojo)
	{
		System.out.println("edit Product");
		return service.updateProduct(pojo);
		
	}
	
	@GetMapping("/getProduct")
	@ResponseBody
	public ProductPojo getProduct(@RequestParam Integer id)
	{
		System.out.println("get Product");
		return service.getProductById(id);
	}
	
	@GetMapping("/getProductList")
	@ResponseBody
	public List<ProductPojo> getProductList()
	{
		System.out.println("get ProductList");
		return service.getProductList();
	}
	
	@DeleteMapping("/removeProduct")
	@ResponseBody
	public ResponseEntity<Object> RemoveProduct(@RequestParam Integer id)
	{
		return service.removeProduct(id);
	}

}
