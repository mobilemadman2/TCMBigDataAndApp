package org.iscas.web.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by suemi on 17-7-1.
 */
@Entity
@Table
public class User extends IdEntity implements UserDetails{

  @NotNull
  private String account;

  @NotNull
  private String password;

  private String salt;

  private String email;
  
  private String mobile;
  
  private static final long serialVersionUID = 1L;
  
  @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
  private List<SysRole> roles;

  public List<SysRole> getRoles() {
	return roles;
}

public void setRoles(List<SysRole> roles) {
	this.roles = roles;
}

@Transient
  private String plainPassword;

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public String getPlainPassword() {
    return plainPassword;
  }

  public void setPlainPassword(String plainPassword) {
    this.plainPassword = plainPassword;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> auths = new ArrayList<>();
    List<SysRole> roles = this.getRoles();
    for (SysRole role : roles) {
        auths.add(new SimpleGrantedAuthority(role.getName()));
    }
    return auths;
}

@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return this.account;
}

@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isEnabled() {
	// TODO Auto-generated method stub
	return true;
}

}
