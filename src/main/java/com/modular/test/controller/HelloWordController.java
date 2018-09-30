package com.modular.test.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.modular.test.dao.UserDao;
import com.modular.test.entity.UsersEntity;
import com.modular.test.form.UserForm;
import com.redis.RedisUtil;
import com.utility.TypeConversionUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/helloWord")
public class HelloWordController{
	@Autowired
	private UserDao userdao;

	@Autowired
	private RedisUtil redisUtil;

	@RequestMapping("/hw.do")
	public void HelloWord(HttpServletRequest request, HttpServletResponse response) throws Exception {
			UsersEntity user = new UsersEntity();
			user.setName("ssss");
			user.setPassWord("111111");
			String userJson = TypeConversionUtility.ObjToJson(user);
			System.out.println("输出Json格式数据:" + userJson);
//			List<UsersEntity> us = userdao.selectUserInfo();
//			for (UsersEntity s : us) {
//				System.out.println("用户名:" + s.getName() + "用户密码：" + s.getPassWord());
//			}
			response.getWriter().write(userJson);
	}

	/**
	 * 分页查询
	 * @param user
	 * @return
	 */
	@RequestMapping("/hw2.do")
	@ResponseBody
	@Cacheable(value = "userInfo",key = "#user.userId")
	public PageInfo<UsersEntity> HelloWord2 (@RequestBody UserForm user) {
			user.getPage4Dao();
			List<UsersEntity> us = userdao.selectUserInfo(user);
			PageInfo<UsersEntity> pageInfo = new PageInfo<>(us);
			return pageInfo;
	}
	
	
	@RequestMapping("/hw3.do")
	@ResponseBody
	public void TestTransaction(HttpServletRequest request, HttpServletResponse response) {
		UsersEntity user = new UsersEntity();
		user.setName("user2");
		user.setPassWord("45353");
		userdao.updataUserInfo(user);
	}

	@RequestMapping(value = "/hw4.do")
	public ModelAndView reJsp(ModelMap model, Integer page) {
		page = page != null ? page : 1;
		PageHelper.startPage(page, 3);
		ModelAndView mad = new ModelAndView("test03");
//		List<UsersEntity> userList = userdao.selectUserInfo();
//		PageInfo<UsersEntity> pages = new PageInfo<UsersEntity>(userList);
//		mad.addObject("users", userList);
//		mad.addObject("page", pages);
		return mad;
	}

}
