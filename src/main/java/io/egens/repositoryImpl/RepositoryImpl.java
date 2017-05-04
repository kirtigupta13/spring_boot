package io.egens.repositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import io.egens.pojo.User;
import io.egens.repository.UserRepository;

@Repository
public class RepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;//just use this for database connecion
	
	
	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createQuery("SELECT e FROM User e", User.class);
		
		return query.getResultList();
	}

	@Override
	public User findOne(String id) {
		
		return em.find(User.class, id);
	}
	@Override
	public User create(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User update(User user) {
		return em.merge(user);
	}

	@Override
	public void delete(User user) {
		em.remove(user);

	}

	

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
