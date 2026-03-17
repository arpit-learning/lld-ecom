package dev.arpit.ecom.services;

import dev.arpit.ecom.exceptions.InvalidLoginUserException;
import dev.arpit.ecom.exceptions.InvalidSignupUserException;
import dev.arpit.ecom.exceptions.InvalidUserIdException;
import dev.arpit.ecom.models.User;

public interface IUserService {
  User findById(long userId) throws InvalidUserIdException;
  User signupUser(User user) throws InvalidSignupUserException;
  User loginUser(User user) throws InvalidLoginUserException;
  User updateUser(long userId, User user) throws InvalidUserIdException;
  void deleteUser(long userId) throws InvalidUserIdException;
}
