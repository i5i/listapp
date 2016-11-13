package com.listapp.web;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.listapp.domain.Org;
import com.listapp.service.ListService;


@RestController
public class ListAppController{
    @Autowired 
    private ListService service;
    
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping("/resource")
    public Map<String, Object> home() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("list", service.getList());
        return model;
    }
    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public Map<String, Object> create(@RequestBody Org org){
        Map<String, Object> model = new HashMap<String, Object>();
        String str=service.createOrg(org);
        model.put("dblog", str);
        model.put("list", service.getList());
        return model;
    }
    
    
    @RequestMapping("/delete")
    public Map<String, Object> delete(long id) {
        Map<String, Object> model = new HashMap<String, Object>();
        String str=service.deleteById(id);
        model.put("dblog", str);
        model.put("list", service.getList());
        return model;
    }
    
    
    @RequestMapping("/get-by-name")
    public Map<String, Object> getByName(String name) {
        Map<String, Object> model = new HashMap<String, Object>();
        String str=service.getByName(name);
        model.put("dblog", str);
        return model;
    }
    
    @RequestMapping("/update")
    public Map<String, Object> updateUser(long id, String name, Org org) {
        Map<String, Object> model = new HashMap<String, Object>();
        String str=service.updateName(id, name);
        model.put("dblog", str);
        return model;
    }

}
