package App.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginHomeController {

	@GetMapping("/loginHome")
	public String home(ModelMap model)
	{
		return "loginHome";
	}
	
}
