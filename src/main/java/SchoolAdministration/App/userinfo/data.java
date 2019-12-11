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
@Table(name = "t_tasks")

public class data implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	//@ManyToOne
	private String name;
	
	private String task;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private boolean finished;

	public data() {
	}

	public data(String name, String task, Date date, boolean finished) {
		super();
		this.name = name;
		this.task = task;
		this.date = date;
		this.finished = finished;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "data [t_id=" + id + ", name=" + name + ", Task=" + task + ", date=" + date + ", finished=" + finished
				+ "]";
	}

}
