package com.crud.reporistories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.entities.User;

public interface UserRepo extends JpaRepository<User, Long>{
}
