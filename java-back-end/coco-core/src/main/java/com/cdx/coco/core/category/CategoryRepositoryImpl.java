package com.cdx.coco.core.category;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.cdx.coco.core.repository.JPARepository;

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
