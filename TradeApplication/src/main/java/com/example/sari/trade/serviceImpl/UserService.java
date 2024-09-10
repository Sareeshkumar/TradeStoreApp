package com.example.sari.trade.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sari.trade.model.User;
import com.example.sari.trade.repo.UserRepository;
import com.example.sari.trade.service.IUserService;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private UserRepository repo;

	@Override
	public Integer saveUser(User user) {
		
		//TODO: Encode Password
		return repo.save(user).getId();
	}

}
