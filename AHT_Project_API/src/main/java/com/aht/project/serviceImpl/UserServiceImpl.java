package com.aht.project.serviceImpl;


import org.springframework.stereotype.Service;

import com.aht.project.entity.ServiceResult;
import com.aht.project.entity.User;
import com.aht.project.repository.UserRepository;

@Service
public class UserServiceImpl {
	private UserRepository userRepository;
	private ServiceResult serviceResult;

	public UserServiceImpl(UserRepository userRepository, ServiceResult serviceResult) {
		this.userRepository = userRepository;
		this.serviceResult = serviceResult;
	}

	public ServiceResult findAll() {
		serviceResult.setValid(true);
		serviceResult.setMessage("all");
		serviceResult.setData(userRepository.findAll());
		return serviceResult;
	}

	public ServiceResult save(User user) {
		userRepository.save(user);
		serviceResult.setValid(true);
		serviceResult.setMessage("Created");
		return serviceResult;
	}

	public ServiceResult delete(int id) {
		userRepository.deleteById(id);
		serviceResult.setValid(true);
		serviceResult.setMessage("Deleted");
		return serviceResult;
	}

	public ServiceResult update( User user) {
		userRepository.save(user);
		serviceResult.setValid(true);
		serviceResult.setMessage("Updated");
		return serviceResult;
	}

	public ServiceResult getUser(User userLogin) {
		User user = userRepository.findByEmail(userLogin.getEmail());
		if (user == null) {
			serviceResult.setValid(false);
			serviceResult.setMessage("The email address you entered isn't connected to an account ");
		} else {
			if (user.getPassword().equals(userLogin.getPassword())) {
				serviceResult.setValid(true);
				serviceResult.setData(user);
				serviceResult.setMessage("Ok");
			} else {
				serviceResult.setValid(false);
				serviceResult.setMessage("The password that you've entered is incorrect");
			}
		}
		return serviceResult;
	}

}
