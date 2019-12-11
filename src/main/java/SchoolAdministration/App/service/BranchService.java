/**
 * 
 */
/**
 * @author ysathe
 *
 */
package SchoolAdministration.App.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SchoolAdministration.App.taskdao.*;
import SchoolAdministration.App.userinfo.*;

@Service
public class BranchService {

	@Autowired
	private BranchRepository wRepository;
	
	@Autowired
	private BranchService service;

	
	public List<Branch> findAll(){
		List<Branch> branchList = new ArrayList<Branch>();
		for(Branch s : wRepository.findAll())
		{
			branchList.add(s);
		}
		return branchList;
	}
	
	   public void addBranchData(Branch branch)
	    {
			   wRepository.save(branch);
	    }
	    
	    public void deleteBranchData(long  branchId)
	    {
			   wRepository.delete(branchId);
	    }
	    	    
	    public Branch findOne(long  branchId) {
	    	return wRepository.findOne(branchId);
	    }
	    
}