package com.xcg.coco.core.category;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.xcg.coco.core.repository.GenericBaseRepository;

/***
 * Implementation of generic DAO to manage persistence for categories
 * 
 * @author Clément Gibert
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CategoryRepositoryImpl extends GenericBaseRepository<CategoryEntity, String> implements CategoryRepository {

}
