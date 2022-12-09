package com.NEST.ComplaintPortal.controller;

import com.NEST.ComplaintPortal.DAO.UserDAO;
import com.NEST.ComplaintPortal.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    public UserDAO udao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userReg", consumes = "application/json", produces = "application/json")
    public HashMap<String,String> UserReg(@RequestBody UserModel u){
        HashMap<String,String> map = new HashMap<>();

        udao.save(u);
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userLogin", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UserLogin(@RequestBody UserModel u){
        HashMap<String, String> map = new HashMap<>();

        List<UserModel> result = (List<UserModel>) udao.UserReg(u.getEmail(),u.getPassword());

        if(result.size()==0){
            map.put("status","success");
        }else{
            map.put("status","success");
            int id = result.get(0).getId();
            map.put("id",String.valueOf(id));
            System.out.println(id);
        }
        return map;

    }
}
