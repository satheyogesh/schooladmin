package SchoolAdministration.App.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import SchoolAdministration.App.service.TaskService;
import SchoolAdministration.App.userinfo.User;
import SchoolAdministration.App.userinfo.Tasks;

@Controller
public class TaskController {

	@Autowired 
	private TaskService taskService;
		   
	//@Autowired
	//private HttpServletRequest request;
	
	@GetMapping("/")
	public String home(HttpServletRequest request )
	{
		request.setAttribute("mode", "MODE_HOME");
		return "home";
	}
	
	/*@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(ModelMap model){
		//this.getData();
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	} */
	
	
	
	@GetMapping("/all-tasks")
	public String allTasks(HttpServletRequest request)
	{
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "tasks";
	}
	
	@GetMapping("/new-task")
	public String newTask(HttpServletRequest request)
	{
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_NEW");
		return "tasks";
	}
	
	@PostMapping("/save-task")
	public String saveTask(@ModelAttribute Tasks d, BindingResult bindingResult, HttpServletRequest request)
	{
		//d.setDate(new Date());
		taskService.save(d);
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "redirect:/all-tasks";
	}
	
	@GetMapping("/update-task")
	public String updateTask(@RequestParam long id, HttpServletRequest request)
	{
		Tasks tk = taskService.findTask(id);
		request.setAttribute("taskObj",tk );

		String pattern = "MM/dd/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(tk.getDt());
		
		request.setAttribute("parsedTaskDate",date);
		request.setAttribute("mode", "MODE_UPDATE");
		return "tasks";
	}
	
	@GetMapping("/delete-task")
	public String deleteTask(@RequestParam long id, HttpServletRequest request)
	{
		taskService.delete(id);
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "tasks";
	}
}

