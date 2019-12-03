package com.seecen.domain;

/**
 * @Author 鞠志超
 * @Date 2019/10/27 18:27
 * @Description
 */
public class UserBo {
    private User user;
    private Role role;
    private UserRole userRole;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
