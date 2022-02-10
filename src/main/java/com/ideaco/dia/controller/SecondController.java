package com.ideaco.dia.controller;


import com.ideaco.dia.model.UserModel;
import com.ideaco.dia.response.DataResponse;
import com.ideaco.dia.response.HandlerResponse;
import com.ideaco.dia.service.SecondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Handler;

@RestController
@RequestMapping("/api/v2")


public class SecondController {

    @Autowired
    private SecondService secondService;


    @GetMapping("/auth/{userid}")
    public void  getUser(HttpServletRequest request, HttpServletResponse response,
                             @PathVariable("userid")int userId){
        UserModel userModel = secondService.getUserById(userId);
        DataResponse<UserModel> data = new DataResponse<>();
        data.setData(userModel);
        HandlerResponse.responseSuccessWithData(response, data);
    }

    @GetMapping("auth/users")
    public List<UserModel> getAllUsers(){
        return secondService.getAllUsers();
    }

    @GetMapping("auth/user/password")
    public UserModel getUserByUserNameAndPassword(@RequestParam("userName")String userName,
                                                  @RequestParam("userPassword")String userPassword){
        UserModel userByName = secondService.getUserByUserNameAndPassword(userName, userPassword);
        if (userByName != null){
            return userByName;
        }else {
            return new UserModel();
        }
    }

    @PostMapping("/auth")
    public UserModel createUser(@RequestParam("userName") String userName,
                              @RequestParam("userPassword") String userPassword,
                              @RequestParam("userEmail") String userEmail,
                                @RequestParam("userPhone")int userPhone,
                                @RequestParam("userAddress")String userAddress,
                                @RequestParam("userResume")String userResume) {
        return secondService.createJob(userName, userPassword, userEmail, userPhone, userAddress, userResume);
    }

}
