package SchoolAdministration.App.service;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import SchoolAdministration.App.taskdao.UserRepository;
import SchoolAdministration.App.userinfo.User;

@Service
@Transactional
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository)
	{
		this.userRepository= userRepository;
	}
	
	public User findUser(String name)
	{
		return userRepository.findOne(name);
	}
	
	public void save(User u)
	{
		userRepository.save(u);
	}

}
