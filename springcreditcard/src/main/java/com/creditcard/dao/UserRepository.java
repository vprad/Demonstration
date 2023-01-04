package com.creditcard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creditcard.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{

}
