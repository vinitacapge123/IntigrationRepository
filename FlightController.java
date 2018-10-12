package com.fms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fms.bean.FlightBean;
import com.fms.service.IFlightService;

@Controller
public class FlightController {

	@RequestMapping("home")
	public String getHome(Model m){
		m.addAttribute("flightObj",new FlightBean());
		return "home";
	}
	//obj service
	@Autowired
	private IFlightService fserv;
	
	@RequestMapping(value="store",method=RequestMethod.POST)
	public String storeFlightInfo(Model m,@Valid @ModelAttribute("flightObj") FlightBean f,BindingResult br){
		String target=null;
		System.out.println("in store");
		if(br.hasErrors()){
			target="home";
			System.out.println("in error");
		}
		else{
		System.out.println("in ctrlr");
		int fid=fserv.addFlightDetails(f);
		if(fid>0){
			System.out.println("in if");
			m.addAttribute("msg","stored successfully");
			m.addAttribute("fid", fid);
			target="success";
		}
		else{
			target="home";
		}
		}
		return target;
	}
}
