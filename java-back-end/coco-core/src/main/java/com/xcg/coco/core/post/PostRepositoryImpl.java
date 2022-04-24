package com.xcg.coco.core.post;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.xcg.coco.core.repository.GenericBaseRepository;

/***
 * Implementation of generic DAO to manage persistence for posts
 * 
 * @author Clément Gibert
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class PostRepositoryImpl extends GenericBaseRepository<PostEntity, Integer> implements PostRepository {

}