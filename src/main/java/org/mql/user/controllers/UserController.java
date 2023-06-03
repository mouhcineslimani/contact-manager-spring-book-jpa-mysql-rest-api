package org.mql.user.controllers;

import java.util.List;

import org.mql.user.business.ContactService;
import org.mql.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
	@Autowired
	ContactService service;

	public UserController() {
	}

	@GetMapping
	public List<User> getAllUsers() {
		return service.users();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		User u = service.users(id);
		return u == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(u);
	}

	@GetMapping("/search-phone/{phone}")
	public List<User> getUserByPhone(@PathVariable String phone) {
		return service.usersByPhone(phone);
	}

	@GetMapping("/search-name/{name}")
	public List<User> getUserByName(@PathVariable String name) {
		return service.usersByName(name);
	}

	@GetMapping("/search-address/{address}")
	public List<User> getUserByAddress(@PathVariable String address) {
		return service.usersByAddress(address);
	}

	@PostMapping
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
		User u = service.updateUser(id, user);
		return u != null ? ResponseEntity.ok().body(u) : ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> addUser(@PathVariable Long id) {
		User u = service.deleteUser(id);
		return u != null ? ResponseEntity.ok().body(u) : ResponseEntity.noContent().build();
	}

}
