package com.cdx.coco.core.course;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.cdx.coco.core.repository.JPARepository;

/***
 * Implementation of generic DAO to manage persistence for courses
 * 
 * @author Clément Gibert
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CourseRepositoryImpl extends JPARepository<CourseEntity, Integer> implements CourseRepository {

}
