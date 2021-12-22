package com.xcg.coco.core.user;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.xcg.coco.core.repository.GenericBaseRepository;

/***
 * Implementation of the generic DAO to manage persistence of users
 * 
 * @author Clément Gibert
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class UserRepositoryImpl extends GenericBaseRepository<UserEntity, String>  implements UserRepository{

}
