/**
 * 
 */
package com.workflow.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.workflow.model.User;

/**
 * @author Kishan
 *
 */
@Repository
@Transactional
public interface UserRepository extends CrudRepository<User,Integer> {

}
