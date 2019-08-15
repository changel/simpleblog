package com.chang.simpleblog.realm;

import com.chang.simpleblog.basedata.dao.RightAuthDao;
import com.chang.simpleblog.basedata.dao.UserDao;
import com.chang.simpleblog.basedata.entity.RightAuth;
import com.chang.simpleblog.basedata.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: chang.tong
 * @Date: 2019/8/12 15:16
 * @Version 1.0
 */
public class UserRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private RightAuthDao rightAuthDao;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName=(String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Set<String> users=new HashSet<String>();
//        User user = userDao.findUserByUsername(userName);
        users.add(userName);
        List<RightAuth> rightAuths = rightAuthDao.findRightAuthByUserName(userName);
        for(RightAuth rightAuth:rightAuths) {
            info.addStringPermission(rightAuth.getSourceentity()+"&&"+rightAuth.getSourceid());
        }
        info.setRoles(users);
        return info;
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        LOGGER.debug("token.getPrincipal:" + token.getPrincipal());
        LOGGER.debug("token.getCredentials:" + token.getCredentials());
        String userName = token.getPrincipal().toString();
        User user = userDao.findUserByUsername(userName);
        if (user != null) {
            // Object principal, Object credentials, String realmName
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
            return authcInfo;
        } else {
            return null;
        }
    }
}
