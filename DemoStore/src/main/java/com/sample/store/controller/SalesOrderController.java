package com.sample.store.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

//import javax.servlet.http.HttpSession;


//import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sample.store.dao.SalesOrderDAO;
import com.sample.store.dao.ProductDAO;
import com.sample.store.entity.Product;
import com.sample.store.entity.ShoppingCart;


@Controller
public class SalesOrderController {
	private ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	//private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	//configuration for session, please refer to: http://tuhrig.de/making-a-spring-bean-session-scoped/
	@Autowired
	private ShoppingCart shoppingCart;
	
	@RequestMapping(value = "/addShoppingCart", method = RequestMethod.GET)
	public ModelAndView addShoppingCart(@ModelAttribute Product product){
		ModelAndView model = new ModelAndView("redirect:/availableProduct");
		//only id is passed
		long pid = product.getId();
		System.out.println("pid="+pid);
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		product = productDAO.get(product);//retrieve all information with id
		//ShoppingCart shoppingCart = (ShoppingCart)context.getBean("shoppingCart"); 
		shoppingCart.add(product);
		//System.out.println(shoppingCart.count());
		return model;
	}
	
	@RequestMapping(value = "/showCart", method = RequestMethod.GET)
	public ModelAndView showShoppingCart(){
		ModelAndView model = new ModelAndView("showCart");
		//ShoppingCart shoppingCart = (ShoppingCart)context.getBean("shoppingCart");
		List<Product> content =  shoppingCart.getCart();
		model.addObject("shoppingCart",content);
		return model;
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView checkout(){
		ModelAndView model = new ModelAndView("showCart");
		//ShoppingCart shoppingCart = (ShoppingCart)context.getBean("shoppingCart");
		SalesOrderDAO salesOrderDAO = (SalesOrderDAO)context.getBean("salesOrderDAO");
		List<Product> pList =  shoppingCart.getCart();
		List<Long> pList2 = new ArrayList<Long>();
		for (int i=0; i<pList.size();i++){
			pList2.add(pList.get(i).getId());
		}
		int result = 0;
		try {
			result = salesOrderDAO.sellProduct(pList2);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("result="+result);
		if (result != 0){ //successfully updated, clean up shopping cart
			shoppingCart.cleanup();
		}
		return model;
	}
	
	
}
