package com.xcg.coco.core.tutorial;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.xcg.coco.core.repository.GenericBaseRepository;

/***
 * Implementation of the generic DAO to manage persistence of tutorials
 * 
 * @author Clément Gibert
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class TutorialRepositoryImpl extends GenericBaseRepository<TutorialEntity, Integer> implements TutorialRepository {

}
