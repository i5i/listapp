package com.listapp.service;

import java.util.List;

import com.listapp.domain.Org;

public interface ListService {
    /**
     * Generates List of organizations
     */
    List<Org> getList();
    String createOrg(Org org);
    String deleteById(long id);
    String getByName(String name);
    String updateName(long id, String name);
}