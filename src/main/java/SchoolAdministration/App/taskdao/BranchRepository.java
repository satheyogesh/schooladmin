package SchoolAdministration.App.taskdao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import SchoolAdministration.App.userinfo.Batch;
import SchoolAdministration.App.userinfo.Branch;

import java.util.List;

@Repository
public interface BranchRepository extends CrudRepository<Branch,Long>  {

    List<Branch> findAll();

}