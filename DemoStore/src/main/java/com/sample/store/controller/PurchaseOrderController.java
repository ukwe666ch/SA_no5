package com.sample.store.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sample.store.dao.PurchaseOrderDAO;
import com.sample.store.dao.ProductDAO;
import com.sample.store.entity.Product;
import com.sample.store.entity.PurchaseOrder;



/**
 * Handles requests for the application home page.
 */
@Controller
public class PurchaseOrderController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	//private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	

	@RequestMapping(value = "/reorderProduct", method = RequestMethod.GET)
	public ModelAndView listReorderProduct(){
	
		ModelAndView model = new ModelAndView("reorderProduct");
		//logger.info("controller");
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		List<Product> productList = new ArrayList<Product>();
		productList = productDAO.getReorderList();
		//logger.info(""+productList.size());
		model.addObject("productList", productList);
		
		return model;
	}

	@RequestMapping(value = "/createPO", method = RequestMethod.GET)
	public ModelAndView reorderProduct(@ModelAttribute Product product){
		ModelAndView model = new ModelAndView("redirect:/reorderProduct");
		PurchaseOrderDAO purchaseOrderDAO = (PurchaseOrderDAO)context.getBean("purchaseOrderDAO");
		purchaseOrderDAO.create(product, 1);//qty is fixed for now
		//System.out.println("id ="+product.getId());
		return model;
	}
	
	@RequestMapping(value = "/po", method = RequestMethod.GET)
	public ModelAndView listPO(@ModelAttribute Product product){
		ModelAndView model = new ModelAndView("po");
		PurchaseOrderDAO purchaseOrderDAO = (PurchaseOrderDAO)context.getBean("purchaseOrderDAO");
		List<PurchaseOrder> poList = new ArrayList<PurchaseOrder>();
		poList=purchaseOrderDAO.getList();
		//System.out.println("#ofPO ="+poList.size());
		model.addObject("poList",poList);
		return model;
	}

	@RequestMapping(value = "/stock", method = RequestMethod.GET)
	public ModelAndView stockProduct(@ModelAttribute PurchaseOrder po){
		ModelAndView model = new ModelAndView("redirect:/po");
		PurchaseOrderDAO purchaseOrderDAO = (PurchaseOrderDAO)context.getBean("purchaseOrderDAO");
		
		try {
			//TODO result should be checked 
			//int result = purchaseOrderDAO.stockProduct(po);
			purchaseOrderDAO.stockProduct(po);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println("#ofPO ="+poList.size());
		//model.addObject("poList",poList);
		return model;
	}
	
	
}
