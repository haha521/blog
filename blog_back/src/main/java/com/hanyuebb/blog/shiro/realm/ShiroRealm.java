package com.hanyuebb.blog.shiro.realm;

import com.hanyuebb.blog.domain.TbBlogUser;
import com.hanyuebb.blog.exmapper.ExTbBlogUserMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

@Component
public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private ExTbBlogUserMapper exTbBlogUserMapper;
//
//	@Autowired
//	private MenuService menuService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//System.out.println(principals.getPrimaryPrincipal());
		Object object = principals.getPrimaryPrincipal();
		TbBlogUser user = new TbBlogUser();
		try {
			BeanUtils.copyProperties(user, object);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		//TbBlogUser user = (TbBlogUser) simplePrincipalCollection.getPrimaryPrincipal();
		Set<String> set = new HashSet<>();
		set.add(user.getUserType());
		info.setRoles(set);
		//获取权限菜单
		//Set<String> set = menuService.listPerms(SubjectUtils.getUserId());
		//info.setStringPermissions(set);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		//更具用户名和密码查找用户
		String username = upToken.getPrincipal().toString();

		TbBlogUser tbBlogUser = new TbBlogUser();
		tbBlogUser.setUserName(username);
		TbBlogUser user = exTbBlogUserMapper.selectOne(tbBlogUser);

		//System.out.println(username);
		if(user!=null){
			ByteSource credentialsSalt = ByteSource.Util.bytes(username);
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), credentialsSalt, getName());
			return info;
		}
		// 账号不存在
//		if (user == null) {
//			throw new UnknownAccountException("账号或密码不正确");
//		}
//		// 密码错误
//		if (!password.equals(user.getLoginPassword())) {
//			throw new IncorrectCredentialsException("账号或密码不正确");
//
//		// 账号被锁定
//		if ("0".equals(user.getLocked())) {
//			throw new LockedAccountException("账号已被锁定,请联系管理员");
//		}
		// 盐值
		return null;
	}

}
