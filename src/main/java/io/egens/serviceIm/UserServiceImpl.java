package io.egens.serviceIm;

import java.util.List;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egens.exception.BadRequestException;
import io.egens.exception.NotFoundException;
import io.egens.pojo.User;
import io.egens.repository.UserRepository;
import io.egens.service.UserService;

//transation in spring is done on service layer
@Service

public class UserServiceImpl implements UserService {

	private UserRepository repository;

	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Transactional(readOnly=true)
	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional()
	public User findOne(String id) {
		User existingUser = repository.findOne(id);
		if (existingUser == null) {
			throw new NotFoundException("User with id " + id + " does not exist");
		}
		return existingUser;
	}

	@Override
	@Transactional
	public User create(User user) {

		User existingUser = repository.findOne(user.getEmail());
		if (existingUser != null) {
			throw new BadRequestException("User with email " + user.getEmail() + " already exists");
		}
		return repository.create(existingUser);
	}

	@Override
	@Transactional
	public User update(String id, User user) {
		User existingUser = repository.findOne(id);
		if (existingUser == null) {
			new NotFoundException("User with id " + id + " does not exist");
		}
		return repository.update(existingUser);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User existingUser = repository.findOne(id);
		if (existingUser == null) {
			new NotFoundException("User with id " + id + " does not exist");
		}
		repository.delete(existingUser);

	}
}
