package com.example.sari.trade.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sari.trade.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
