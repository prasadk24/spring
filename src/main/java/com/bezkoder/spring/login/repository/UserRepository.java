package com.bezkoder.spring.login.repository;

import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.login.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
  Optional<User> findById(Long id);
  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
  @Modifying
  @Query("update User u set u.name=:name,u.address=:address, u.state=:state,u.country=:country, u.email=:email, u.pan=:pan, u.contactno=:contactno where u.id=:id" )
  @Transactional
  void updateUser(@Param(value = "id") Long id,
                  @Param(value = "name") String name,
                  @Param(value = "address") String address,
                  @Param(value = "state") String state,
                  @Param(value = "country") String country,
                  @Param(value = "email") String email,
                  @Param(value = "pan") String pan,
                  @Param(value = "contactno") Long contactno);


}
