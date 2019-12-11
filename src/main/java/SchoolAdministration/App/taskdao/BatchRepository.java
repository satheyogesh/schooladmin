package SchoolAdministration.App.taskdao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import SchoolAdministration.App.userinfo.Batch;

@Repository
public interface BatchRepository extends CrudRepository<Batch,Long>  {

}