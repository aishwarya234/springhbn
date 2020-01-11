package mvchbn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import beans.Employee;

@Controller
public class CustomerController {
	@Autowired
	CustomerDao dao;
	@RequestMapping(value="/addcust",method=RequestMethod.GET)
	public String  showAddCustomerForm(){
		return "AddCustomer";
	}
	
	@RequestMapping(value="/addcust",method=RequestMethod.POST)
	public ModelAndView addCustomer(@ModelAttribute("customer")Customer cust){
		
		ModelAndView mav=new ModelAndView();
		dao.addCustomer(cust);
		//dao.updateCustomer(cust.getCode());
		mav.setViewName("redirect:viewcustomers");
		return mav;
	}
	
	
	@RequestMapping(value="/viewcustomers")
	public ModelAndView getCustomers(){
		
		ModelAndView mav=new ModelAndView();
		List<Customer> list=dao.getCustomers();
		mav.addObject("customers",list);
		mav.setViewName("ViewCustomers");
		return mav;
		
		
	}
	//here
	
	@RequestMapping(value="/updatecustomer",method=RequestMethod.GET)
	public ModelAndView showUpdateCustomerForm(int code){
		
		Customer cust=dao.getCustomers(code);
		ModelAndView mav=new ModelAndView();
		mav.addObject("cust",cust);
		mav.setViewName("UpdateCustomer");
		return mav;
	}
	@RequestMapping(value="/updatecustomers",method=RequestMethod.POST)
	public ModelAndView updateCustomers(@ModelAttribute("customer")Customer cust){
		
		ModelAndView mav=new ModelAndView();
		dao.updateCustomers(cust);
	
		mav.setViewName("redirect:viewcustomers");
		return mav;
	}
	
	@RequestMapping(value="/deletecustomers",method=RequestMethod.GET)
	public ModelAndView deleteCustomers(int code){
		
		Customer cust=dao.getCustomers(code);
		ModelAndView mav=new ModelAndView();
		dao.deleteCustomer(cust);
		mav.addObject("cust",cust);
		mav.setViewName("redirect:viewcustomers");
		return mav;
	}
	
	
	
	
	
	
	
}
