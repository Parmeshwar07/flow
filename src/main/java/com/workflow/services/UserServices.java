/**
 * 
 */
package com.workflow.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workflow.model.User;
import com.workflow.repository.UserRepository;

/**
 * @author Kishan
 *
 */
@Service
public class UserServices {
	
	@Autowired
	private UserRepository repository;

	public User create(User user) {		
		return repository.save(user);
	}
	
	public Iterable<User> list() {			
		return repository.findAll();
	}
	
	public User update(int id,User user) {		
		if(repository.existsById(id)) {
			user.setId(id);
			return repository.save(user);	
		}
		return null;
	}
	
	public User get(int id) {		
		Optional<User> user= repository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}
}
