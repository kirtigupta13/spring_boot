package io.egens.service;

import java.util.List;

import io.egens.pojo.User;

/**
 * create service impl
 * @author kirti gupta
 *
 */
public interface UserService {
	public List<User> findAll();

	public User findOne(String id);

	public User create(User user);

	public User update(String id, User user);

	public void delete(String id);
}
