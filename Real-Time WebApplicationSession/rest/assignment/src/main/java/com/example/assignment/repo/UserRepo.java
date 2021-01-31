package com.example.assignment.repo;

import com.example.assignment.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User,Integer> {

    @Query(value="Select password from user where email=:email",nativeQuery = true)
    String checkLogin(@Param("email") String email);

}
