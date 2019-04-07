package App.taskdao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import App.userinfo.Batch;

@Repository
public interface BatchRepository extends CrudRepository<Batch,Long>  {

}