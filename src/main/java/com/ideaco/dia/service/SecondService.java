package com.ideaco.dia.service;

import com.ideaco.dia.model.UserModel;
import com.ideaco.dia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecondService {

    @Autowired
    private UserRepository userRepository;


    // Read user data
    public UserModel getUserById(int userId){
        return userRepository.findById(userId).get();
    }

    // Create user data with validation
    public UserModel createJob(String userName,
                              String userPassword,
                              String userEmail,
                               int userPhone,
                               String userAddress,
                               String userResume){
        Optional<UserModel> userOpt = userRepository.findByUserName(userName);
        if (userOpt.isEmpty()){
            UserModel newUser = new UserModel();
            newUser.setUserName(userName);
            newUser.setUserPassword(userPassword);
            newUser.setUserEmail(userEmail);
            newUser.setUserPhone(userPhone);
            newUser.setUserAddress(userAddress);
            newUser.setUserResume(userResume);
            return userRepository.save(newUser);

        } else {
            return null;

        }

    };

    // Read all user data
    public List<UserModel> getAllUsers(){
        return userRepository.findAll();
    }

    // Read user data with validation username and password
    public UserModel getUserByUserNameAndPassword(String userName, String userPassword){
        Optional<UserModel> userOpt = userRepository.findByUserNameAndUserPassword(userName, userPassword);
        if (userOpt.isEmpty()){
            return null;
        }
        return  userOpt.get();
    }

}
