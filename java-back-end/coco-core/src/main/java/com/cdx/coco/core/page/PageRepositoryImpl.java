package com.cdx.coco.core.page;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.cdx.coco.core.repository.GenericBaseRepository;


/***
 * Implementation of generic DAO to manage persistence for pages
 * 
 * @author Clément Gibert
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class PageRepositoryImpl extends GenericBaseRepository<PageEntity, Integer> implements PageRepository {

}