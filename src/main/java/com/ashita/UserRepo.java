package com.ashita;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {

	 public User findByEmailIDAndPassword(String email,String pass);
}
