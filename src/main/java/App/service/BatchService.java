/**
 * 
 */
/**
 * @author ysathe
 *
 */
package App.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import App.taskdao.*;
import App.userinfo.*;

@Service
public class BatchService {

	@Autowired
	private BatchRepository wRepository;
	
	@Autowired
	private BatchService service;

	
	public List<Batch> findAll(){
		List<Batch> batchList = new ArrayList<Batch>();
		for(Batch s : wRepository.findAll())
		{
			batchList.add(s);
		}
		return batchList;
	}
	
	   public void addBatchData(Batch batch)
	    {
			   wRepository.save(batch);
	    }
	    
	    public void deleteBatchData(long  batchId)
	    {
			   wRepository.delete(batchId);
	    }
	    	    
	    public Batch findOne(long  batchId) {
	    	return wRepository.findOne(batchId);
	    }
	    
}