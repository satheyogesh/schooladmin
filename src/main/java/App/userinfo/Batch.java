package App.userinfo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "batch_table")
public class Batch implements Serializable 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long  batchid;
	
	@NotEmpty(message ="{batch.name.empty}")
    @Size(min=0, max=50,message ="{batch.name.length}")
	private String batchName;
	
   @Size(min=0, max=80,message ="{batch.desc.length}")
	private String batchDesc;
    
   @NotEmpty(message ="{batch.startdate.empty}")
   @Size(min=0, max=10,message ="{batch.startdate.length}")
	private String startDate;
    
   @NotEmpty(message ="{batch.enddate.empty}")
   @Size(min=0, max=10,message ="{batch.enddate.length}")
	private String endDate;
    
   @NotEmpty(message ="{batch.starttime.empty}")
   @Size(min=0, max=8,message ="{batch.starttime.length}")
	private String startTime;
    
   @NotEmpty(message ="{batch.endtime.empty}")
   @Size(min=0, max=8,message ="{batch.endtime.length}")
	private String endTime;
    
   @NotEmpty(message ="{batch.minage.empty}")
   @Size(min=0, max=2,message ="{batch.minage.length}")
	private String minAge;
	
   @NotEmpty(message ="{batch.maxage.empty}")
   @Size(min=0, max=2,message ="{batch.maxage.length}")
	private String maxAge;
    
	public long getBatchid() {
		return batchid;
	}
	public void setBatchid(long batchid) {
		this.batchid = batchid;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public String getBatchDesc() {
		return batchDesc;
	}
	public void setBatchDesc(String batchDesc) {
		this.batchDesc = batchDesc;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getMinAge() {
		return minAge;
	}
	public void setMinAge(String minAge) {
		this.minAge = minAge;
	}
	public String getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(String maxAge) {
		this.maxAge = maxAge;
	}

	
}
