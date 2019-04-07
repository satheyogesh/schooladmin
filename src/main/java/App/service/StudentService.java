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
public class StudentService {

	@Autowired
	private StudentRepository wRepository;
	
	@Autowired
	private StudentService service;

	
	public List<Student> findAll(){
		List<Student> studentList = new ArrayList<Student>();
		for(Student s : wRepository.findAll())
		{
			studentList.add(s);
		}
		return studentList;
	}
	
	   public void addStudentData(Student sell)
	    {
			   wRepository.save(sell);
	    }
	    
	    public void deleteStudentData(long  id)
	    {
			   wRepository.delete(id);
	    }
	    	    
	    public Student findOne(long  id) {
	    	return wRepository.findOne(id);
	    }
	    
}