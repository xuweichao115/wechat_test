package com.modular.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.modular.test.dao.UserDao;
import com.referenceResources.entity.UsersEntity;
import com.utility.TypeConversionUtility;

@Controller
@RequestMapping("/helloWord")
public class HelloWordController{
	@Autowired
	private UserDao userdao;

	@RequestMapping("hw.do")
	public void HelloWord(HttpServletRequest request, HttpServletResponse response) throws Exception {
			UsersEntity user = new UsersEntity();
			user.setName("ssss");
			user.setPassWord("111111");
//			System.out.println("服务端返回成功！");
			String userJson = TypeConversionUtility.ObjToJson(user);
			System.out.println("输出Json格式数据:" + userJson);
			List<UsersEntity> us = userdao.selectUserInfo();
//			getLogger().logger.error("服务端异常");
			for (UsersEntity s : us) {
				System.out.println("用户名:" + s.getName() + "用户密码：" + s.getPassWord());
			}
			response.getWriter().write(userJson);
	}

	@RequestMapping("hw2.do")
	@ResponseBody
	public List<UsersEntity> HelloWord2 (@RequestBody UsersEntity user) {
			int pageNum = user.getPageNum();
		    //每页的数量
			int pageSize = user.getPageSize();
			System.out.println("返回页面："+pageNum + "" +pageSize);
			String username = user.getName();
//			PageHelper.startPage(user.getPageSize(),user.getPageNum());
			String pad = user.getPassWord();
			System.out.println(pad);
			System.out.println(username);
			List<UsersEntity> us=userdao.selectUserInfo();
			return us;
	}
	
	
	@RequestMapping("hw3.do")
	@ResponseBody
	public void TestTransaction(HttpServletRequest request, HttpServletResponse response) {
		UsersEntity user = new UsersEntity();
		user.setName("user2");
		user.setPassWord("45353");
		userdao.updataUserInfo(user);
	}

	@RequestMapping(value = "hw4.do")
	public ModelAndView reJsp(ModelMap model, Integer page) {
		page = page != null ? page : 1;
		PageHelper.startPage(page, 3);
		ModelAndView mad = new ModelAndView("test03");
		List<UsersEntity> userList = userdao.selectUserInfo();
		PageInfo<UsersEntity> pages = new PageInfo<UsersEntity>(userList);
		mad.addObject("users", userList);
		mad.addObject("page", pages);
		return mad;
	}

}
