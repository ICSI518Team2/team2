package com.ashita;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@Autowired
	UserRepo ur;
	
	@RequestMapping("/welcome")
	public String homepage()
	{
		return "index";
	}
	@RequestMapping("/signup")
	public String signup()
	{
		return "Signup";
	}
	@RequestMapping("/contact")
	public String contact()
	{
		return "contact";
	}
	@RequestMapping("/saveuser")
	public String saveuser(@ModelAttribute("user") User user,BindingResult bindingResult,HttpServletRequest request)
	{
		user.setRole("user");
		ur.save(user);
		return "index";
	}
	@RequestMapping("/login")
	public String login(@ModelAttribute("user") User user,BindingResult bindingResult,HttpServletRequest request)
	{
		
	   System.out.println(user.getEmailID()+"    ####"+ user.getPassword());
		if(ur.findByEmailIDAndPassword(user.getEmailID(),user.getPassword())!=null)
		{
			User d=ur.findByEmailIDAndPassword(user.getEmailID(),user.getPassword() );
			if(d.getRole().equalsIgnoreCase("admin"))
			{
				return "adminpage";
			}
			else
				return "userpage";//change userpage to something page
			
		}
		return "index";
	}
	
	

}
