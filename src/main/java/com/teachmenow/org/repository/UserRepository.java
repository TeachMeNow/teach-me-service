package com.teachmenow.org.repository;

import com.teachmenow.org.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by owdaa on 7/12/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {

  User findByName(String userName);

}
