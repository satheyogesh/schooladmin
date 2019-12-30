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
public class BatchController {

	@Autowired
	private BatchService service;

	@Autowired
	private BranchService branchService;

	@GetMapping("/batchList")	
	public String home(ModelMap model )
	{
		model.addAttribute("batchList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
		return "batch";
	}
	
	@RequestMapping(value="/batch", method = RequestMethod.GET)
	public String createBatch(ModelMap model){

		model.addAttribute("listBranch", branchService.findAll());
		model.addAttribute("batchList", service.findAll());
		model.addAttribute("mode", "MODE_NEW");
		return "batch";
	
	}
	
	/*@RequestMapping(value="/savebatch", method = RequestMethod.GET)
	public String saveBatch(ModelMap model){

		model.addAttribute("batchList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
			return "batch";
	}*/
	


	@RequestMapping(value="/batch", method = RequestMethod.POST)
	public String saveBatch(@ModelAttribute("batchForm") @Valid Batch batch, BindingResult bindingResult,
			ModelMap model,
			@RequestParam(required=false , value = "save") String saveFlag , 
			@RequestParam(required=false , value = "cancel") String cancelFlag){

		if(cancelFlag!=null && cancelFlag.equalsIgnoreCase("cancel"))
		{
			return "redirect:/batchList";
			
		}
		
		if (bindingResult.hasErrors()) {
			
			model.addAttribute("batchList", service.findAll());
			model.addAttribute("mode", "MODE_NEW");
			model.addAttribute("batchobj",batch);

			return "batch";
			}
		
		service.addBatchData(batch);
		model.addAttribute("batchList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
		
		return "redirect:/batchList";
	}
	
	@RequestMapping(value="/updatebatch", method = RequestMethod.GET)
	public String updateTask(@RequestParam long batchid,ModelMap model)
	{
		Batch s = service.findOne(batchid);
		model.addAttribute("batchobj",s);
		model.addAttribute("mode", "MODE_UPDATE");
		model.addAttribute("listBranch", branchService.findAll());

		return "batch";
	}
	
	@RequestMapping(value="/deletebatch", method = RequestMethod.GET)
	public String deleteTask(@RequestParam long batchid,ModelMap model)
	{
		service.deleteBatchData(batchid);
		model.addAttribute("batchList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
		return "batch";
	}

}
