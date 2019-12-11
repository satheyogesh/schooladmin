package SchoolAdministration.App.taskdao;

import org.springframework.data.repository.CrudRepository;

import SchoolAdministration.App.userinfo.User;
import SchoolAdministration.App.userinfo.data;

public interface UserRepository extends CrudRepository<User, String>{

}
