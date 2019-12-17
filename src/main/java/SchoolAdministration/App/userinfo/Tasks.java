package SchoolAdministration.App.userinfo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tasks")
public class Tasks implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	//@Temporal(TemporalType.DATE)
	private Date dt;
		
	private String task;

	private boolean finished;

	public Tasks() {
	}

	public Tasks(String name, String task, Date date, boolean finished) {
		super();
		this.task = task;
		this.dt = date;
		this.finished = finished;
	}

	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

		
	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "data [t_id=" + id + ", Task=" + task + ", date=" + dt + ", finished=" + finished
				+ "]";
	}

}
