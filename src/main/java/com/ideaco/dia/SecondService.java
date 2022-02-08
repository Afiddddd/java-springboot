package com.ideaco.dia;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecondService {

    private UserRepository userRepository;

    public SecondService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public  UserModel getUserById(int userId){
        return userRepository.findById(userId).get();
    }

    public UserModel createJob(String userName,
                              String userPassword,
                              String userEmail,
                               int userPhone,
                               String userAddress,
                               String userResume){
        UserModel newUser = new UserModel();
        newUser.setUserName(userName);
        newUser.setUserPassword(userPassword);
        newUser.setUserEmail(userEmail);
        newUser.setUserPhone(userPhone);
        newUser.setUserAddress(userAddress);
        newUser.setUserResume(userResume);
        return userRepository.save(newUser);
    };

    public List<UserModel> getAllUsers(){
        return userRepository.findAll();
    }
}
