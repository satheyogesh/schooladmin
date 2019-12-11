package SchoolAdministration.App.taskdao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import SchoolAdministration.App.userinfo.Batch;
import SchoolAdministration.App.userinfo.Branch;

@Repository
public interface BranchRepository extends CrudRepository<Branch,Long>  {

}