package SchoolAdministration.App.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import SchoolAdministration.App.taskdao.TaskRepository;
import SchoolAdministration.App.userinfo.data;

@Service
@Transactional
public class TaskService {
	
	private final TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository)
	{
		this.taskRepository=taskRepository;
	}

	public List<data> findAll(){
		List<data> tasks = new ArrayList<data>();
		for(data d: taskRepository.findAll())
		{
			tasks.add(d);
		}
		return tasks;
	}
	
	public data findTask(long id)
	{
		return taskRepository.findOne(id);
	}
	
	public void save(data d)
	{
		taskRepository.save(d);
	}
	
	public void delete(long id)
	{
		taskRepository.delete(id);
	}
}
