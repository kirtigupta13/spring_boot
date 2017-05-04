package io.egens.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.egens.pojo.User;
import io.egens.service.UserService;
/**
 * now get data from service interace
 * @author kirti gupta
 *
 */
@RestController
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	private UserService userService;	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return userService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public User findOne(@PathVariable("id") String id) {
		return userService.findOne(id);
	}

	@RequestMapping(method= RequestMethod.POST)
	public User create(@RequestBody User user) {
		return userService.create(user);

	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public User update(@PathVariable("id") String id, @RequestBody User user) {
		return userService.update(id, user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		userService.delete(id);
	}
}
