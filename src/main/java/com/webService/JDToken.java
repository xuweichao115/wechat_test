package com.webService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webService.entity.CallbackEntity;
import com.webService.entity.JDInfoEntity;
import com.webService.mapperInterface.IjdInfo;

@Controller
@RequestMapping("/JD")
public class JDToken{
	@Autowired
	private IjdInfo IjdInfo;

	@RequestMapping("insertInfo.do")
	@ResponseBody
	public CallbackEntity savaJDInfo(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
		JDInfoEntity jdinfo=new JDInfoEntity();
		CallbackEntity call = new CallbackEntity();
		String jdCode=request.getParameter("code"); 
		JSONObject jdToke =JSONObject.fromObject(request.getParameter("token"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String jdIns_date = sdf.format(new Date());
		Map<String, Object> m_jdtoke=jdToke;
		jdinfo.setCode(jdCode!=null?jdCode:"");
		jdinfo.setExpires_in(Integer.valueOf((String) (m_jdtoke.get("expires_in")!=null?m_jdtoke.get("expires_in"):0)));
		jdinfo.setIns_date(jdIns_date);
		jdinfo.setTime((String)(m_jdtoke.get("time")!=null?m_jdtoke.get("time"):""));
		jdinfo.setToken(m_jdtoke.get("token")!=null?m_jdtoke.get("token").toString():"");
		jdinfo.setUid(m_jdtoke.get("uid")!=null?m_jdtoke.get("uid").toString():"");
		jdinfo.setUser_nick( m_jdtoke.get("user_nick")!=null?m_jdtoke.get("user_nick").toString():"");
		jdinfo.setVenderId(Integer.valueOf((String)(m_jdtoke.get("venderId")!=null?m_jdtoke.get("venderId"):0)));
		try {
		IjdInfo.insertJdInfo(jdinfo);
		call.setCode("0");
		call.setMsg("success");
		call.setData("");
		} catch (Exception e) {
			call.setCode("-1");
			call.setData("");
			call.setMsg("fail");
		}
		return call;
	}
	
	
	@RequestMapping("findInfo.do")
	@ResponseBody
	public JDInfoEntity findJDInfo(HttpServletRequest request, HttpServletResponse response) {
		JDInfoEntity jdinfo=new JDInfoEntity();
//		Callback call=new Callback();
		String password=request.getParameter("psd") != null?request.getParameter("psd"):"";
//		String userName=request.getParameter("user") != null?request.getParameter("user"):"";
		if(password.equals("jdToken")){
			try {
				jdinfo=IjdInfo.findJdInf();
				if(jdinfo!=null){
					jdinfo.setCode("0");
				}
			} catch (Exception e) {
				jdinfo.setCode("-1");
				e.printStackTrace();
			}
			return jdinfo;
		}else{
			jdinfo.setCode("-1");
			return jdinfo;
		}
	}
}