package com.cdx.coco.application.post;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.cdx.coco.application.repository.JPARepository;

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