package com.NEST.ComplaintPortal.controller;

import com.NEST.ComplaintPortal.DAO.ComplaintDAO;
import com.NEST.ComplaintPortal.DAO.UserDAO;
import com.NEST.ComplaintPortal.Model.ComplaintModel;
import com.NEST.ComplaintPortal.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    public UserDAO udao;

    @Autowired
    public ComplaintDAO cdao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userReg", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UserReg(@RequestBody UserModel u) {
        HashMap<String, String> map = new HashMap<>();

        udao.save(u);
        map.put("status", "success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userLogin", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UserLogin(@RequestBody UserModel u) {
        HashMap<String, String> map = new HashMap<>();

        List<UserModel> result = (List<UserModel>) udao.UserReg(u.getEmail(), u.getPassword());

        if (result.size() == 0) {
            map.put("status", "success");
        } else {
            map.put("status", "success");
            int id = result.get(0).getId();
            map.put("id", String.valueOf(id));
            System.out.println(id);
        }
        return map;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/profile", consumes = "application/json", produces = "application/json")
    public List<UserModel> Profile(@RequestBody UserModel u) {
        return (List<UserModel>) udao.Profile(u.getId());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/complaint", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> Complaint(@RequestBody ComplaintModel c) {
        HashMap<String, String> map = new HashMap<>();

        cdao.save(c);
        map.put("status", "success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewComplaints", consumes = "application/json", produces = "application/json")
    public List<ComplaintModel> Complaints(@RequestBody ComplaintModel c) {
        return (List<ComplaintModel>) cdao.Complaints(c.getUserId());
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewAllComplaints")
    public List<Map<String, String>> ViewAllComplaints() {
        return (List<Map<String, String>>) cdao.ViewAllComplaints();
    }

}