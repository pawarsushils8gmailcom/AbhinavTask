package com.admin.product.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.admin.product.repos.ProductRepository;
import com.admin.product.repos.UserRepository;
import com.admin.product.dto.ApiResponse;
import com.admin.product.dto.ProductPojo;
import com.admin.product.dto.UserPojo;
import com.admin.product.entities.Product;
import com.admin.product.entities.User;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	public JavaMailSender javaMailsender;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<ProductPojo> getProductList() {
		List<ProductPojo> pojoList=new ArrayList<ProductPojo>();
		try {
			List<Product> productList=productRepo.findByStatus("A");
			for(Product product:productList)
			{
				ProductPojo pojo=new ProductPojo();
				pojo.setId(product.getId());
				pojo.setDescription(product.getDescription());
				pojo.setEmail(product.getEmail());
				pojo.setPrice(product.getPrice());
				pojo.setProductName(product.getProductName());
				pojo.setSku(product.getSku());
				pojo.setStockLevel(product.getStockLevel());
				
				pojoList.add(pojo);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return pojoList;
	}

	@Override
	public ResponseEntity<Object> saveProduct(ProductPojo pojo) {
		ApiResponse response = new ApiResponse();
//		String response="";
		try {
			Product pr=new Product();
			pr.setDescription(pojo.getDescription());
			pr.setEmail(pojo.getEmail());
			pr.setPrice(pojo.getPrice());
			pr.setProductName(pojo.getProductName());
			pr.setSku(pojo.getSku());
			pr.setStockLevel(pojo.getStockLevel());
			pr.setCreateDate(LocalDate.now());
			pr.setCreateTime(LocalTime.now());
			pr.setStatus("A");
			Product afterSaveProdcut = productRepo.save(pr);
			
//			
			System.out.println("Sending mail....");

			MimeMessage mimeMessage=javaMailsender.createMimeMessage();
			MimeMessageHelper mimehelper=new MimeMessageHelper(mimeMessage,true);
				String textMessage ="Product Name:"+afterSaveProdcut.getProductName()+"\n"+ "Product Description: "+afterSaveProdcut.getDescription()+"\n"+"Price: "+afterSaveProdcut.getPrice()+"\n"+
			"Stock Level: "+ afterSaveProdcut.getStockLevel()+"\n"+"Sku:"+afterSaveProdcut.getSku();
			mimehelper.setTo(afterSaveProdcut.getEmail());
			mimehelper.setText(textMessage);
			mimehelper.setSubject("Product Information");		
			javaMailsender.send(mimeMessage);	
			
			System.out.println("Done");		
				
			response.setMessage("Saved Successfully!");
			
			
		}catch (Exception e) {
			e.printStackTrace();
			response.setMessage("Something went wrong");
		}
			
		
		return ResponseEntity.ok().body(response);
	}

	@Override
	public ResponseEntity<Object> updateProduct(ProductPojo pojo) {
		ApiResponse response = new ApiResponse();
		try {
			Product pr=productRepo.getById(pojo.getId());
			pr.setDescription(pojo.getDescription());
			pr.setEmail(pojo.getEmail());
			pr.setPrice(pojo.getPrice());
			pr.setProductName(pojo.getProductName());
			pr.setSku(pojo.getSku());
			pr.setStockLevel(pojo.getStockLevel());
			pr.setCreateDate(LocalDate.now());
			pr.setCreateTime(LocalTime.now());
			pr.setStatus("A");
			productRepo.save(pr);
			response.setMessage("Updated Successfully!");
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			response.setMessage("Something went wrong");
		}
			
		return ResponseEntity.ok().body(response);
//		return response;
	}

	@Override
	public ProductPojo getProductById(Integer id) {
		ProductPojo pojo=new ProductPojo();
		try {
			Product pr=productRepo.getById(id);
			System.out.println(id);
			
			pojo.setDescription(pr.getDescription());
			pojo.setEmail(pr.getEmail());
			pojo.setPrice(pr.getPrice());
			pojo.setProductName(pr.getProductName());
			pojo.setSku(pr.getSku());
			pojo.setStockLevel(pr.getStockLevel());
			pojo.setId(pr.getId());
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return pojo;
	}

	@Override
	public ResponseEntity<Object> removeProduct(Integer id) {
		ApiResponse response = new ApiResponse();

		try {
			Product pr=productRepo.getById(id);
			pr.setStatus("D");
			pr.setUpdateDate(LocalDate.now());
			pr.setUpdateTime(LocalTime.now());
			productRepo.save(pr);
			response.setMessage("Deleted Successfully!");
			
			
		}catch (Exception e) {
			e.printStackTrace();
			response.setMessage("Something went wrong!");
		}
		return ResponseEntity.ok().body(response);
	}

	@Override
	public ResponseEntity<Object> doLogin(String uName, String password) {
		ApiResponse response = new ApiResponse();
		ResponseEntity<Object> resp=null;
		try {
			List<User> userList = userRepo.findByUserNameAndPasswordAndStatus(uName, password, "A");
			if(!userList.isEmpty())
			{
				return ResponseEntity.ok().body(userList.get(0));
			}else {
				response.setMessage("User Not Found");
				return ResponseEntity.badRequest().body(response);
				
			}
		}catch (Exception e) {
			response.setMessage("Something went wrong");
			resp= ResponseEntity.unprocessableEntity().body(response);
		}
		return resp;
	}

	@Override
	public ResponseEntity<Object> registerUser(UserPojo pojo) {
		ApiResponse response=new ApiResponse();
		try {
			User user=new User();
			user.setName(pojo.getName());
			user.setPassword(pojo.getPassword());
			user.setStatus("A");
			user.setUserName(pojo.getUserName());
			userRepo.save(user);
			response.setMessage("Registered Successfully!");
			return ResponseEntity.ok().body(response);
			
		}catch (Exception e) {
			e.printStackTrace();
			response.setMessage("Something Went Wrong!");
		}
		return ResponseEntity.unprocessableEntity().body(response);
	}

}
