package com.teachmenow.org.service;

import com.teachmenow.org.auth.Role;
import com.teachmenow.org.auth.User;
import com.teachmenow.org.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by owdaa on 7/12/17.
 */
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  @Transactional(rollbackOn = {})
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

    User user = userRepository.findByName(userName);

    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

    for (Role role : user.getRoles()){
      grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
    }

    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
  }
}
