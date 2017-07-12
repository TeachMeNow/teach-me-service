package com.teachmenow.org.repository;

import com.teachmenow.org.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by owdaa on 7/12/17.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

}
