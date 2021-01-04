package com.blackcat.controller;

import com.blackcat.common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Title 用户操作
 * @Description
 * @author zhanghui
 * @date 2020年12月31日 13:46
 * @version V1.0
 * @see
 * @since V1.0
 */
@Controller
public class UserController {

//	@GetMapping("login")
//	public String login(){
//		return "login";
//	}
//
//	@PostMapping("login")
//	public String login(String userName,String password){
//		return "user";
//	}

	/**
	 * <p> 描述 : 跳转登陆页面
	 * @author : blackcat
	 * @date  : 2020/2/1 20:01
	 */
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login() {
//		Subject subject = SecurityUtils.getSubject();
//		SysUser user=(SysUser) subject.getPrincipal();
//		if (user == null){
			return "login";
//		}else{
//			return "redirect:index";
//		}
	}

	/**
	 * <p> 描述 : 用户登录
	 * @author : blackcat
	 * @date  : 2020/2/3 17:04
	 */
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@ResponseBody
	public Result loginUser(String userName, String password) {
//		// 如果有点击  记住我
//		UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
//		// 获取当前的Subject
//		Subject currentUser = SecurityUtils.getSubject();
//		try {
//			// 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
//			// 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
//			// 所以这一步在调用login(token)方法时,它会走到xxRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
//			currentUser.login(token);
//			Subject subject = SecurityUtils.getSubject();
//			SysUser user=(SysUser) subject.getPrincipal();
//			SecurityUtils.getSubject().getSession(true).setAttribute("userInfo", user);
//			return ResultUtil.ok("登录成功！");
//		} catch (Exception e) {
//			log.error("登录失败，用户名[{}]", username, e);
//			token.clear();
//			return ResultUtil.error(e.getMessage());
//		}
		return Result.SUCCESS;
	}
}
