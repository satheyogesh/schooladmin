package SchoolAdministration.App.taskdao;

import org.springframework.data.repository.CrudRepository;

import SchoolAdministration.App.userinfo.Tasks;

public interface TasksRepository extends CrudRepository<Tasks, Long>{

}
