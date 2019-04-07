package App.taskdao;

import org.springframework.data.repository.CrudRepository;

import App.userinfo.data;

public interface TaskRepository extends CrudRepository<data, Long>{

}
