package org.mql.user.repositories;

import java.util.List;

import org.mql.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.address LIKE %:address%")
	public List<User> findByAddress(String address);

	@Query("SELECT u FROM User u WHERE u.phone LIKE %:phone%")
	public List<User> findByPhone(String phone);

	@Query("SELECT u FROM User u WHERE u.fullname LIKE %:name%")
	public List<User> findByName(String name);
	
}
