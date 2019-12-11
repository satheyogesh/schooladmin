package SchoolAdministration.App.userinfo;

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
@Table(name = "branch_table")
public class Branch implements Serializable 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long  branchId;
	
	@NotEmpty(message ="{branch.name.empty}")
    @Size(min=1, max=70,message ="{branch.name.length}")
	private String branchName;
	
	@NotEmpty(message ="{branch.address1.empty}")
    @Size(min=1, max=100,message ="{branch.address1.length}")
	private String address1;
	
    @Size(min=0, max=50,message ="{branch.address2.length}")
	private String address2;
	
	@NotEmpty(message ="{branch.city.empty}")
    @Size(min=1, max=100,message ="{branch.city.length}")
	private String city;
	
	@NotEmpty(message ="{branch.state.empty}")
    @Size(min=1, max=100,message ="{branch.state.length}")
	private String state;
	
	@NotEmpty(message ="{branch.country.empty}")
    @Size(min=1, max=100,message ="{branch.country.length}")
	private String country;
	
	@NotEmpty(message ="{branch.phone.empty}")
    @Size(min=1, max=12,message ="{branch.phone.length}")
	private String phone;

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

   
}
