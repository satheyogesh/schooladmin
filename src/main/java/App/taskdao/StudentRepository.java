package App.taskdao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import App.userinfo.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long>  {

}
