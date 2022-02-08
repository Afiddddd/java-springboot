package com.ideaco.dia;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")


public class SecondController {

    private SecondService secondService;

    public SecondController(SecondService secondService) {
        this.secondService = secondService;
    }

    @GetMapping("/user/{userid}")
    public UserModel getUser(@PathVariable("userid")int userId){
        return secondService.getUserById(userId);
    }

    @GetMapping("user/users")
    public List<UserModel> getAllUsers(){
        return secondService.getAllUsers();
    }

    @PostMapping("/user")
    public UserModel createUser(@RequestParam("userName") String userName,
                              @RequestParam("userPassword") String userPassword,
                              @RequestParam("userEmail") String userEmail,
                                @RequestParam("userPhone")int userPhone,
                                @RequestParam("userAddress")String userAddress,
                                @RequestParam("userResume")String userResume) {
        return secondService.createJob(userName, userPassword, userEmail, userPhone, userAddress, userResume);
    }
}
