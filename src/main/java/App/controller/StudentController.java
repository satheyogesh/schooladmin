package App.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import App.userinfo.Student;
import App.service.*;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/student")	
	public String home(ModelMap model )
	{
		//request.setAttribute("mode", "MODE_HOME");
		model.addAttribute("studentList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
		return "student";
	}
	
	@RequestMapping(value="/newstudent", method = RequestMethod.GET)
	public String createStudent(ModelMap model){


		model.addAttribute("studentList", service.findAll());
		model.addAttribute("mode", "MODE_NEW");

		return "student";
	}
	
	@RequestMapping(value="/savestudent", method = RequestMethod.GET)
	public String saveStudent(ModelMap model){

		model.addAttribute("studentList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
			return "student";
	}
	
	@RequestMapping(value="/newstudent", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute Student sell, BindingResult bindingResult,ModelMap model){

		service.addStudentData(sell);
		model.addAttribute("studentList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
		
		
		return "redirect:/savestudent";
	}
	
	@RequestMapping(value="/updatestudent", method = RequestMethod.GET)
	public String updateTask(@RequestParam long id,ModelMap model)
	{
		Student s = service.findOne(id);
		model.addAttribute("studentobj",s);
		model.addAttribute("mode", "MODE_UPDATE");
		return "student";
	}
	
	@RequestMapping(value="/deletestudent", method = RequestMethod.GET)
	public String deleteTask(@RequestParam long id,ModelMap model)
	{
		service.deleteStudentData(id);
		model.addAttribute("studentList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
		return "student";
	}
	
	@RequestMapping(value="/error", method = RequestMethod.POST)
	public String error(ModelMap model){


		return "403";
	}
	
}
