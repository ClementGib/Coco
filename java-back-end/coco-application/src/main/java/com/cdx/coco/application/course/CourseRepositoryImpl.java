package com.cdx.coco.application.course;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.cdx.coco.application.repository.JPARepository;

/***
 * Implementation of generic DAO to manage persistence for courses
 * 
 * @author Clément Gibert
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CourseRepositoryImpl extends JPARepository<CourseEntity, Integer> implements CourseRepository {

    @Override
    public List<CourseEntity> findAll() {
        return this.getEntityManager()
                .createNamedQuery("CourseEntity.findAll", CourseEntity.class)
                .getResultList();
    }
}