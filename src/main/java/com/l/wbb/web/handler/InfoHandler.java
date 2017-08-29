package com.l.wbb.web.handler;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.l.wbb.bean.Comment;
import com.l.wbb.bean.Goods;
import com.l.wbb.bean.Info;
import com.l.wbb.bean.LikeInfo;
import com.l.wbb.bean.Theme;
import com.l.wbb.bean.User;
import com.l.wbb.service.InfoService;
import com.mysql.jdbc.log.Log;

@Controller
@RequestMapping("/info")
public class InfoHandler {

	@Autowired
	private InfoService infoService;
	
	@RequestMapping("/infoCenter")
	public String enterInfoCenter(HttpServletRequest request,Integer themeId, HttpServletResponse response , HttpSession session){
		//.out.println(themeId);
		List<Theme> themes = infoService.getAllTheme();
		List<Info> infos = null;
		if(themeId == null || themeId<0){
			// 大厅就是获得所有的分类，不需要在数据新建
			// 已经查出来最大了，剩下的减1
			infos = infoService.getInfoByRange(0, 9, response, session);
		}else{
			infos = infoService.getInfoByTheme(themeId, response, session);
			for (Theme theme : themes) {
				if(themeId.intValue() == theme.getThemeId().intValue()){
					request.setAttribute("currentTheme", theme);
					break;
				}
			}
		}
		
		if(themes!= null && infos!=null){
			request.setAttribute("themes", themes);
			request.setAttribute("infos", infos);
			return "/page/infoCenter";
		}
		return "/fail";
	}
	
	@RequestMapping("/userHistory")
	public String getUserInfo(HttpSession session , HttpServletRequest request,HttpServletResponse response){
		User user = (User) session.getAttribute("user");
		LogManager.getLogger().debug("用户："+user+"请求历史信息");
		List<Info> userHistory = infoService.getUserHistory(user.getOpenid(),session,response);
		request.setAttribute("infos", userHistory);
		return "page/user/userHistory";
	}
	
	@RequestMapping("/detailInfo")
	public String getDetailInfo(Info info, HttpServletRequest request,HttpSession session){

		if(info.getInfoId() == null && session.getAttribute("lastInfo")!=null){
			info = (Info) session.getAttribute("lastInfo");
		}else if(info.getInfoId() == null && session.getAttribute("lastInfo")==null){
			return "index";
		}
		List<Comment> comments = infoService.getCommentsOfInfo(info.getInfoId());
		request.setAttribute("info", info);
		request.setAttribute("comments", comments);
		return "page/infoDetail";
	}
	
	@RequestMapping("/publishInfo")
	@ResponseBody
	public String publishInfo(Info info,HttpSession session ,MultipartHttpServletRequest request){
		User user = (User)session.getAttribute("user");
		LogManager.getLogger().debug("用户："+user+"请求发布信息，信息："+info);
		if(user != null){
			info.setUser(user);
			if(infoService.publishInfo(info,request)){
				return "success";
			}else{
				return "fail";
			}
		}else{
			return "unlogin";
		}
		
		
	}
	
	@RequestMapping("/publishComment")
	@ResponseBody
	public Object publishComment(Comment comment,HttpSession session){
		User user = (User)session.getAttribute("user");
		if(user != null){
			comment.setUser(user);
			if(infoService.publishComent(comment)){
				return comment;
			}else{
				return "fail";
			}
		}else{
			return "unlogin";
		}
		
	}
	
	@RequestMapping("/setLikeInfo")
	@ResponseBody
	public String setLikeInfo(LikeInfo likeInfo,int setStatus,HttpSession session){
		User user = (User)session.getAttribute("user");
		if(user != null){
			likeInfo.setOpenId(user.getOpenid());
			if(infoService.setLikeInfo(likeInfo,setStatus)){
				return "success";
			}else{
				return "fail";
			}
		}else{
			return "unlogin";
		}
		
		
		
	}
	
	@RequestMapping("/getInfoByScroll")
	@ResponseBody
	public List<Info> getInfoByScroll(Integer start , Integer offset, HttpServletResponse response , HttpSession session){
		return  infoService.getInfoByRange(start, offset,response ,session);
		
	}
	
	@RequestMapping("/getThemeInfoByScroll")
	@ResponseBody
	public List<Info> getThemeInfoByScroll(Integer ThemeId,Integer start , Integer offset , HttpServletResponse rep , HttpSession session ){
		 // start 起码从11开始 end起码从20开始
		return  infoService.getThemeInfoByRange(ThemeId, start, offset , rep ,session);		
	}
	
	@RequestMapping("/getCommentByScroll")
	@ResponseBody
	public List<Comment> getCommentByScroll(Integer infoId , Integer start , int offset){
		// start 起码从11开始 end起码从20开始
		return  infoService.getCommentByRange(infoId,start, offset);
		
	}
	
	@RequestMapping("/enterPublish")
	public String enterPublish(HttpServletRequest request){
		LogManager.getLogger().debug("进入发布页面请求..");
		List<Theme> themes = infoService.getAllTheme();
		request.setAttribute("themes", themes);
		return "page/user/publishInfo";
	}
}
