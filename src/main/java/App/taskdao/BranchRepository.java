package App.taskdao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import App.userinfo.Batch;
import App.userinfo.Branch;

@Repository
public interface BranchRepository extends CrudRepository<Branch,Long>  {

}