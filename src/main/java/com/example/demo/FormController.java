package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	@Autowired
	CustomersRepo repo;
	
	@RequestMapping("/")
	public String bridgelabz() {
		return "Bridgelabz";
	}
	@RequestMapping("/details")
	public String details(Customers customers) {
		repo.save(customers);
		return "Bridgelabz";
	}
	@RequestMapping("/getdetails")
	public String getDetails() {
		return "ViewCustomers";
	}
	@PostMapping("/getdetails")
	public ModelAndView getDetails(@RequestParam("cid") int cid) {
		ModelAndView mv=new ModelAndView("Retrieve");
		Customers customer=repo.findById(cid).orElse(null);
		
		mv.addObject("cname", customer.getCname());
		mv.addObject("cemail", customer.getCemail());
		mv.addObject("cid", customer.getCid());
		System.out.println(customer.getCname());
		return mv;
	}
}
