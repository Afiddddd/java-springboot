package com.ideaco.dia.repository;
import com.ideaco.dia.model.JobModel;
import com.ideaco.dia.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findByUserName(String userName);

    Optional<UserModel> findByUserNameAndUserPassword(String userName, String userPassword);
}
