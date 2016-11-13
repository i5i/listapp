package com.listapp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.listapp.domain.Org;
import com.listapp.repositories.OrgRepo;
@Service
public class ListServiceImpl implements ListService {
    @Autowired
    OrgRepo orgRepo;
    
    @Override
    public String createOrg(Org org){
    String id = "";
    try {
      orgRepo.save(org);
      id=String.valueOf(org.getId());
    }
    catch (Exception ex) {
      return "Error creating org entity:" + ex.toString();
    }
    return "Succesfully created org id:"+id; 
    }

    @Override
    public List<Org> getList() {
        List<Org> list=new ArrayList<Org>();
        Iterator<Org> orgIterator=orgRepo.findAll().iterator();
        while(orgIterator.hasNext()){
            list.add(orgIterator.next());
        };
        return list;
    }

    @Override
    public String deleteById(long id) {
        try {
            Org org = new Org();
            org.setId(id);
            orgRepo.delete(org);
          }
          catch (Exception ex) {
            return "Error deleting the org:" + ex.toString();
          }
          return "Org succesfully deleted!";
    }

    @Override
    public String getByName(String name) {
      String id = "";
      try {
        Org org = orgRepo.findByName(name);
        id = String.valueOf(org.getId());
      }
      catch (Exception ex) {
        return "Org not found";
      }
      return "The org id is: " + id;
    }

    @Override
    public String updateName(long id, String name) {
          try {
            Org org = orgRepo.findOne(id);
            org.setName(name);
            orgRepo.save(org);
          }
          catch (Exception ex) {
            return "Error updating the org: " + ex.toString();
          }
          return "Org succesfully updated!";
    }
    
}
