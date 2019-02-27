package org.iscas.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.iscas.web.dao.UserDao;
import org.iscas.web.entity.User;

/**
 * Created by suemi on 17-7-2.
 */
@Service
@Transactional
public class UserService {

  @Autowired
  private UserDao userDao;

  public User load(String account) {
	return userDao.findByAccount(account);
  }

  public Long insert(User user) {
    return userDao.save(user).getId();
  }

  private String checkUser(User user) {
    if(user.getAccount() == null) return "请设置用户名";
    if(user.getPassword() == null) return "请设置密码";

    User tmp = userDao.findByAccount(user.getAccount());
    if(tmp != null) return "用户名已存在";
    return null;
  }

  public String createUser(User user) {
    String err = checkUser(user);
    if(err == null) userDao.save(user);
    return err;
  }

  public User findByAccount(String account) {
    return account == null? null : userDao.findByAccount(account);
  }
}
