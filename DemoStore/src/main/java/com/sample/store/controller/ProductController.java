package com.sample.store.controller;

//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sample.store.dao.ProductDAO;
import com.sample.store.entity.Product;


/**
 * Handles requests for the application home page.
 */
@Controller
public class ProductController {
	//@Autowired
	//private ProductDAO productDAO;
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	//private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView getProductList(){
	
		ModelAndView model = new ModelAndView("product");
		//logger.info("controller");
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		List<Product> productList = new ArrayList<Product>();
		productList = productDAO.getList();
		//logger.info(""+productList.size());
		model.addObject("productList", productList);
		
		return model;
	}
	
	
	@RequestMapping(value = "/insertProduct", method = RequestMethod.GET)
	public ModelAndView insertProductPage(){
		ModelAndView model = new ModelAndView("insertProduct");
		//need the following part for product category
		/*
		ArticleCategoryDAO articleCategoryDAO = (ArticleCategoryDAO)context.getBean("articleCategoryDAO");
		List<ArticleCategory> articleCategoryList = new ArrayList<ArticleCategory>();
		articleCategoryList = articleCategoryDAO.getList();
		model.addObject("articleCategoryList", articleCategoryList);
		*/
		return model;
	}
	
	@RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
	public ModelAndView insertProduct(@ModelAttribute Product product){
		ModelAndView model = new ModelAndView("redirect:/product");
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		productDAO.insert(product);
		
		return model;
	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.GET)
	public ModelAndView updateProductPage(@ModelAttribute Product product){
		ModelAndView model = new ModelAndView("updateProduct");
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		//will need the following part later
		/*
		ArticleCategoryDAO articleCategoryDAO = (ArticleCategoryDAO)context.getBean("articleCategoryDAO");
		List<ArticleCategory> articleCategoryList = new ArrayList<ArticleCategory>();
		articleCategoryList = articleCategoryDAO.getList();
		*/
		product = productDAO.get(product);
		//System.out.println("id="+product.getId());
		//will need the following part later
		//model.addObject("articleCategoryList", articleCategoryList);
		model.addObject("product", product);
		return model;
	}
	
	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	public ModelAndView updateProduct(@ModelAttribute Product product){
		ModelAndView model = new ModelAndView("redirect:/product");
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		productDAO.update(product);	
		return model;
	}

	@RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
	public ModelAndView deleteProduct(@ModelAttribute Product product){
		ModelAndView model = new ModelAndView("redirect:/product");
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		productDAO.delete(product);
		return model;
	}



	@RequestMapping(value = "/availableProduct", method = RequestMethod.GET)
	public ModelAndView listAvailableProduct(){
	
		ModelAndView model = new ModelAndView("availableProduct");
		//logger.info("controller");
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		List<Product> productList = new ArrayList<Product>();
		productList = productDAO.getAvailableList();
		//logger.info(""+productList.size());
		model.addObject("productList", productList);
		
		return model;
	}

}
