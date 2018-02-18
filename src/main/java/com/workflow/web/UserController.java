/**
 * 
 */
package com.workflow.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.workflow.model.User;
import com.workflow.services.UserServices;

/**
 * @author Kishan
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServices userservices;
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public @ResponseBody User create(@RequestBody User usr) {
		return userservices.create(usr);		
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public @ResponseBody Iterable<User> list() {
		return userservices.list();		
	}	 
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public @ResponseBody User update(@RequestBody User usr,@PathVariable Integer id) {
		return userservices.update(id, usr);		
	}
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public @ResponseBody User get(@PathVariable Integer id) {
		return userservices.get(id);		
	}
		
}
