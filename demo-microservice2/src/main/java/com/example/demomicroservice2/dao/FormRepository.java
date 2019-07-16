/**
 * 
 */
package com.example.demomicroservice2.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demomicroservice2.domain.Form;

/**
 * @author juhi.b.jain
 *
 */
@Repository
public interface FormRepository extends CrudRepository<Form, Integer> {

}
