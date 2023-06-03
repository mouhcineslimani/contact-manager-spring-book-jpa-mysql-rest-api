package org.mql.user.business;

import java.util.List;

import org.mql.user.entities.User;

public interface ContactService {
	public List<User> users();

	public User users(Long id);

	public List<User> usersByName(String name);

	public List<User> usersByPhone(String phone);

	public List<User> usersByAddress(String address);

	public User addUser(User u);

	public User updateUser(Long id, User u);

	public User deleteUser(Long id);
}
