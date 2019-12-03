package com.seecen.shiro.realm;


import com.seecen.dao.UserDao;
import com.seecen.domain.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author 鞠志超
 * @Date 2019/9/30 10:01
 * @Description
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserDao userDao;
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("~~~~~~~~~执行了授权方法~~~~~~~~~~~");
     SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userDao.getUserRole((String)principalCollection.getPrimaryPrincipal()));
        authorizationInfo.setStringPermissions(userDao.getUserPermission((String)principalCollection.getPrimaryPrincipal()));
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("~~~~~~~~~执行了认证方法~~~~~~~~~~~");
        User dbUser = userDao.getByName(authenticationToken.getPrincipal().toString());
        if(dbUser == null){
            throw new UnknownAccountException();
        }
        //将用户输入的信息放到shiro中的session会话中去
//        SecurityUtils.getSubject().getSession().setAttribute("user",dbUser);
        //把正确的用户名和密码给匹配器，调用subject.login的时候，匹配器会去自动匹配
        return new SimpleAuthenticationInfo(dbUser.getUserName(),dbUser.getPassword(),getName());
    }
}
