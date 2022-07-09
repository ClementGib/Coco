package com.cdx.coco.core.post;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.cdx.coco.core.repository.JPARepository;

/***
 * Implementation of generic DAO to manage persistence for posts
 * 
 * @author Clément Gibert
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class PostRepositoryImpl extends JPARepository<PostEntity, Integer> implements PostRepository {

}