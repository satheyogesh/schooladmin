package SchoolAdministration.App.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import SchoolAdministration.App.service.*;
import SchoolAdministration.App.userinfo.Batch;

@Controller
public class BranchController {

	@Autowired
	private BatchService service;

	@GetMapping("/branchList")	
	public String home(ModelMap model )
	{
		model.addAttribute("branchList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
		return "branch";
	}
	
	@RequestMapping(value="/branch", method = RequestMethod.GET)
	public String createBatch(ModelMap model){

			model.addAttribute("branchList", service.findAll());
			model.addAttribute("mode", "MODE_NEW");
			return "branch";
	
	}
	
	/*@RequestMapping(value="/savebatch", method = RequestMethod.GET)
	public String saveBatch(ModelMap model){

		model.addAttribute("batchList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
			return "batch";
	}*/
	


	@RequestMapping(value="/branch", method = RequestMethod.POST)
	public String saveBatch(@ModelAttribute("branchForm") @Valid Batch branch, BindingResult bindingResult,
			ModelMap model,
			@RequestParam(required=false , value = "save") String saveFlag , 
			@RequestParam(required=false , value = "cancel") String cancelFlag){

		if(cancelFlag!=null && cancelFlag.equalsIgnoreCase("cancel"))
		{
			return "redirect:/branchList";
			
		}
		
		if (bindingResult.hasErrors()) {
			
			model.addAttribute("branchList", service.findAll());
			model.addAttribute("mode", "MODE_NEW");
			model.addAttribute("branchobj",branch);

			return "branch";
			}
		
		service.addBatchData(branch);
		model.addAttribute("branchList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
		
		return "redirect:/branchList";
	}
	
	@RequestMapping(value="/updatebranch", method = RequestMethod.GET)
	public String updateTask(@RequestParam long branchid,ModelMap model)
	{
		Batch s = service.findOne(branchid);
		model.addAttribute("branchobj",s);
		model.addAttribute("mode", "MODE_UPDATE");
		return "branch";
	}
	
	@RequestMapping(value="/deletebranch", method = RequestMethod.GET)
	public String deleteTask(@RequestParam long branchid,ModelMap model)
	{
		service.deleteBatchData(branchid);
		model.addAttribute("branchList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
		return "branch";
	}

}
