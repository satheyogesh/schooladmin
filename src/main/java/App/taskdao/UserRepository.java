package App.taskdao;

import org.springframework.data.repository.CrudRepository;

import App.userinfo.User;
import App.userinfo.data;

public interface UserRepository extends CrudRepository<User, String>{

}
