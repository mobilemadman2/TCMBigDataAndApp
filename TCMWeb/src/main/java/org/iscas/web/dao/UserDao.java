package org.iscas.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.iscas.web.entity.User;

/**
 * Created by suemi on 17-7-1.
 */
@Repository
public interface UserDao extends JpaRepository<User,Long> {
  User findByAccount(String account);
  User findByMobile(String mobile);
  User findByEmail(String email);
  User findByAccountOrMobileOrEmail(String account, String mobile, String email);

  User findByMobileAndAccountNot(String mobile, String account);
  User findByEmailAndAccountNot(String email, String account);
}
