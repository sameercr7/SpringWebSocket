package org.example.hello1.user;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface UserRepository  extends JpaRepository<User, Long> {
    List<User> findAllByStatus(Status status);
}
