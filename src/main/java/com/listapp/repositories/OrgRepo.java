package com.listapp.repositories;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import com.listapp.domain.Org;

@Transactional
public interface OrgRepo extends CrudRepository<Org, Long> {
  public Org findByName(String name);
}




