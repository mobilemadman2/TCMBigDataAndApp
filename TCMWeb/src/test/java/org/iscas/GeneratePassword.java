package org.iscas;

import java.util.List;

import org.iscas.utils.PaperItemToPinyin;
import org.iscas.web.dao.SysUserRepository;
import org.iscas.web.dao.UserDao;
import org.iscas.web.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratePassword {

	@Autowired 
	SysUserRepository sysUserRepository;
	
	public GeneratePassword() {
		// TODO Auto-generated constructor stub
	}
	
@Test
public void test89() {
	
	User user = sysUserRepository.findByAccount("root");
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	// 加密
	System.out.println(user.getPassword());
	String encodedPassword = passwordEncoder.encode(user.getPassword().trim());
    user.setPassword(encodedPassword);
    System.out.println(encodedPassword);
	sysUserRepository.save(user);
}
}



