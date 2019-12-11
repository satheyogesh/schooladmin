package SchoolAdministration.App.taskdao;

import org.springframework.data.repository.CrudRepository;

import SchoolAdministration.App.userinfo.data;

public interface TaskRepository extends CrudRepository<data, Long>{

}
