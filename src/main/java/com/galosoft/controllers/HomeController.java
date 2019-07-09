package com.galosoft.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.galosoft.models.Product;
import com.galosoft.repos.ProductRepository;

@Controller
public class HomeController {
	
	private Path path;
	
	@Autowired 
	private ProductRepository repository;
	
	@RequestMapping("/")
	public String getIndex() {
		return "myIndex";
	}
	
	@RequestMapping("/productList")
	public String getProducts(Model model) {
		List<Product> products = repository.findAll();
		model.addAttribute("products", products);
		return "productList";
	}
	
	@RequestMapping("/productList/viewProduct/{productId}")
	public String viewProduct(@PathVariable int productId, Model model) throws IOException {
		Product product = repository.getOne(productId);
		model.addAttribute(product);
		return "viewProduct";
	}
	
	@RequestMapping("/admin")
	public String getAdmin() {
		return "admin";
	}
	
	@RequestMapping("/admin/productInventory")
	public String productInventory(Model model) {
		List<Product> products = repository.findAll();
		model.addAttribute("products", products);
		return "productInventory";
	}
	
	@RequestMapping("/admin/productInventory/addProduct")
	public String addProduct(Model model) {
		Product product = new Product();
		product.setProductName("Pilas");
		product.setProductDescription("Pilas recargables");
		product.setProductCondition("nuevo");
		product.setProductStatus("active");
		model.addAttribute("product", product);
		return "addProduct";
	}

	@RequestMapping(value="/admin/productInventory/addProduct", method=RequestMethod.POST)
	public String addProductPost(@Valid @ModelAttribute("product") Product product,BindingResult result,
			HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "addProduct";
		}

		repository.save(product);

		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "//resources//img//" + product.getProductId() + ".png");

		System.out.println(path);

		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("product saving failed...", e);
			}
		}

		return "redirect:/admin/productInventory";
	}
	
	
	@RequestMapping("/admin/productInventory/editProduct/{id}")
	
	public String editProduct(@PathVariable("id") int id, Model model) {
		Product product = repository.getOne(id);
		model.addAttribute("product", product);
		return "editProduct";
	}
	
	@RequestMapping(value="/admin/productInventory/editProduct", method = RequestMethod.POST)
	public String editProduct(@Valid @ModelAttribute("product")Product product,BindingResult result,
			                   HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "addProduct";
		}
		
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		
		path = Paths.get(rootDirectory + "//resources//img//" + product.getProductId() + ".png");
		
		if(productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path.toString()));
			}catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("product saving failed...", e);
			}
		}
		
		
		repository.save(product);
		
		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping("/admin/productInventory/deleteProduct//{id}")
	public String deleteProduct(@PathVariable int id, Model model,HttpServletRequest request ) {
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "//resources//img//" + id+ ".png");
		
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		Product product = repository.getOne(id);
		
		repository.delete(product);
		
		return "redirect:/admin/productInventory";
	}


	
}





















