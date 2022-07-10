package com.cdx.coco.application.user;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.cdx.coco.application.repository.JPARepository;

/***
 * Implementation of generic DAO to manage persistence for users
 * 
 * @author Clément Gibert
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class UserRepositoryImpl extends JPARepository<UserEntity, String> implements UserRepository {

}