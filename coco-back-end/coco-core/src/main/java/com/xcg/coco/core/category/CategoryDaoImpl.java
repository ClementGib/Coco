package com.xcg.coco.core.category;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.xcg.coco.core.dao.GenericBaseDao;

/***
 * Implementation of the generic DAO to manage persistence of categories
 * 
 * @author Clément Gibert
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CategoryDaoImpl extends GenericBaseDao<CategoryEntity, String> implements CategoryDao {

}
