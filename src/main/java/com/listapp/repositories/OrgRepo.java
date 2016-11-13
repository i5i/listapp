package com.listapp.repositories;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import com.listapp.domain.Org;

/**
 * A DAO for the entity User is simply created by extending the CrudRepository
 * interface provided by spring. The following methods are some of the ones
 * available from such interface: save, delete, deleteAll, findOne and findAll.
 * The magic is that such methods must not be implemented, and moreover it is
 * possible create new query methods working only by defining their signature!
 * 
 */
@Transactional
public interface OrgRepo extends CrudRepository<Org, Long> {
  /**
   * Return the user having the passed email or null if no user is found.
   * 
   * @param name 
   */
  public Org findByName(String name);

}




