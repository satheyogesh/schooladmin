package App.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import App.service.UserService;
import App.userinfo.User;
import App.userinfo.data;

@Controller
public class UserController {

	@Autowired 
	private UserService userService;

	@GetMapping("/login")
	public String home(HttpServletRequest request )
	{
		request.setAttribute("mode", "HOME");
		return "login";
	}
	
	@GetMapping("/user")
	public String log(HttpServletRequest request)
	{
		request.setAttribute("mode", "NEW");
		return "login";
	}
	
	
	 @PostMapping("/save-user")
	public String saveUser(@ModelAttribute User u, BindingResult bindingResult, HttpServletRequest request)
	{
		//userService.save(u);
		  request.getSession().setAttribute("username", u.getUsername());

		 //u.setUsername(uname);
		request.setAttribute("users", u);
		request.setAttribute("mode", "MODE_HOME");
		//request.setAttribute("username", uname);

	//	request.setAttribute("users", userService.findUser(u.getUsername()));
	//	request.setAttribute("users", userService.findUser(u.getUsername()));

		return "index";
	}
	 

}

