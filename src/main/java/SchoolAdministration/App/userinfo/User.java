package SchoolAdministration.App.userinfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "user_table")

public class User {
	
	//@Id
	//@Column(name="id")
	//private int id;
	
	@Id
	//@Column(name="name")
	private String username;
	
	//@Column(name="password")
	private String password;

	/*public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
*/
	
	
	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
