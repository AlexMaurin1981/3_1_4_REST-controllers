package REST_controller.demo.entetie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
 @Id
 private Long id;
 @Column(name = "name_role")
 private String nameRole;
 @Column(name = "users")
 @ManyToMany(mappedBy = "roles")
 @JsonIgnore
 private Set<User> users;

 public Role() {
 }

 public Role(Long id) {
  this.id = id;
 }

 public Role(Long id, String nameRole) {
  this.id = id;
  this.nameRole = nameRole;
 }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getNameRole() {
  return nameRole;
 }

 public void setNameRole(String nameRole) {
  this.nameRole = nameRole;
 }

 public Set<User> getUsers() {
  return users;
 }

 public void setUsers(Set<User> users) {
  this.users = users;
 }

 @Override
 public String getAuthority() {
  return getNameRole();
 }

 @Override
 public String toString() {
  return nameRole.substring(5) + " ";
 }

}

