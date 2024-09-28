package com.send.mess.service;


import org.springframework.data.repository.CrudRepository;
import com.send.mess.entity.UserEntity;


public interface UserService extends CrudRepository<UserEntity,Integer> {

	
}
