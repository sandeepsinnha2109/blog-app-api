package com.san.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.san.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
