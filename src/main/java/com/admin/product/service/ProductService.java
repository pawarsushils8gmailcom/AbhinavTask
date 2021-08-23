package com.admin.product.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.admin.product.dto.ProductPojo;
import com.admin.product.dto.UserPojo;

public interface ProductService {
	
	List<ProductPojo> getProductList();
	ResponseEntity<Object> saveProduct(ProductPojo pojo);
	ResponseEntity<Object> updateProduct(ProductPojo pojo);
	ProductPojo getProductById(Integer id);
	ResponseEntity<Object> removeProduct(Integer id);
	ResponseEntity<Object> doLogin(String uName,String password);
	ResponseEntity<Object> registerUser(UserPojo pojo);
	

}
