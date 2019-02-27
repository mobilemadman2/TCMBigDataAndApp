package org.iscas.web.service;

import java.util.ArrayList;
import java.util.List;

import org.iscas.web.dao.SysUserRepository;
import org.iscas.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("CustomUserService")
@Transactional
public class CustomUserService implements UserDetailsService {
    @Autowired
    SysUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByAccount(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println("s:"+s);
        System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
        System.out.println("role:"+user.getRoles());
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list = (List<GrantedAuthority>) user.getAuthorities();
        //getRoles(user,list);
        //User auth_user = new User
        org.springframework.security.core.userdetails.User auth_user = new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),list);
        return auth_user;
        //return user;
    }
    
    /**
     * 获取所属角色
     * @param user
     * @param list
     */
/*    public void getRoles(User user,List<GrantedAuthority> list){
    	
        for (String role:user.getRoles().split(",")) {
　　　　　　　//权限如果前缀是ROLE_，security就会认为这是个角色信息，而不是权限，例如ROLE_MENBER就是MENBER角色，CAN_SEND就是CAN_SEND权限
            list.add(new SimpleGrantedAuthority("ROLE_"+role));　　　　　　　　　　
        }
    }*/
}
