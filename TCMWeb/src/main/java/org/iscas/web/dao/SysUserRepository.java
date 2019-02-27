package org.iscas.web.dao;

import org.iscas.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends JpaRepository<User, Long> {
    User findByAccount(String account);
}
