package org.mql.user.business;

import java.util.List;
import java.util.Optional;

import org.mql.user.entities.User;
import org.mql.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceDefault implements ContactService {

	@Autowired
	private UserRepository userRepository;

	public ContactServiceDefault() {
	}

	@Override
	public List<User> users() {
		return userRepository.findAll();
	}

	@Override
	public User users(Long id) {
		Optional<User> u = userRepository.findById(id);
		return u.isPresent() ? u.get() : null;
	}

	@Override
	public List<User> usersByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	public List<User> usersByPhone(String phone) {
		return userRepository.findByPhone(phone);
	}

	@Override
	public List<User> usersByAddress(String address) {
		return userRepository.findByAddress(address);
	}

	@Override
	public User addUser(User u) {
		return userRepository.save(u);
	}

	@Override
	public User updateUser(Long id, User u) {
		User user = users(id);
		if (user != null) {
			user.setAddress(u.getAddress());
			user.setFullname(u.getFullname());
			user.setPhone(u.getPhone());
			userRepository.save(user);
		}
		return user;
	}

	@Override
	public User deleteUser(Long id) {
		User user = users(id);
		if (user != null)
			userRepository.delete(user);
		return user;
	}

}
