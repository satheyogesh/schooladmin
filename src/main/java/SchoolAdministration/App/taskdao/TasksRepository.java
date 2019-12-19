package SchoolAdministration.App.taskdao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import SchoolAdministration.App.userinfo.Tasks;

public interface TasksRepository extends CrudRepository<Tasks, Long>{

/*	List<Tasks> findAllOrderByFinishedDesc();*/
	
	List<Tasks> findAllByOrderByDtDesc();


}
