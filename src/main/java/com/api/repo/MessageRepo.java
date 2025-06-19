package com.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.entity.Message;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long>{

	
	List<Message> findBySecretmsgAndPassword(String msg, String password);
}
