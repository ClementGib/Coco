package com.cdx.coco.application.category;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.cdx.coco.application.repository.JPARepository;

/***
 * Implementation of generic DAO to manage persistence for categories
 * 
 * @author Clément Gibert
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CategoryRepositoryImpl extends JPARepository<CategoryEntity, String> implements CategoryRepository {

}
