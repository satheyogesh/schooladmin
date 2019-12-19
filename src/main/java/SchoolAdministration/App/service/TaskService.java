package SchoolAdministration.App.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import SchoolAdministration.App.taskdao.TasksRepository;
import SchoolAdministration.App.userinfo.Tasks;

@Service
@Transactional
public class TaskService {
	
	private final TasksRepository tasksRepository;
	
	public TaskService(TasksRepository tasksRepository)
	{
		this.tasksRepository=tasksRepository;
	}

	public List<Tasks> findAll(){
		List<Tasks> tasks = new ArrayList<Tasks>();
		for(Tasks d: tasksRepository.findAllByOrderByDtDesc())
		{
			tasks.add(d);
		}
		
		return tasks;
	}
	
	public Tasks findTask(long id)
	{
		return tasksRepository.findOne(id);
	}
	
	public void save(Tasks d)
	{
		tasksRepository.save(d);
	}
	
	public void delete(long id)
	{
		tasksRepository.delete(id);
	}
}
