package com.l.wbb.web.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.l.wbb.bean.Comment;
import com.l.wbb.bean.Info;
import com.l.wbb.bean.LikeInfo;
import com.l.wbb.bean.PaginationBean;
import com.l.wbb.bean.Theme;
import com.l.wbb.context.WBBConst;
import com.l.wbb.service.InfoService;

@Controller
@RequestMapping("/info")
public class InfoHandler {

	@Autowired
	private InfoService infoService;
	
	@RequestMapping("/infoCenter")
	public String enterInfoCenter(HttpServletRequest request,Integer themeId){
		
		List<Theme> themes = infoService.getAllTheme();
		List<Info> infos = null;
		if(themeId == null){
			// 大厅就是获得所有的分类，不需要在数据新建
			infos = infoService.getFirstPageInfo();
		}else{
			infos = infoService.getInfoByTheme(themeId);
		}
		
		if(themes!= null && infos!=null){
			request.setAttribute("themes", themes);
			request.setAttribute("infos", infos);
			return "/page/infoCenter";
		}
		
		
		return "/fail";
	}
	
	@RequestMapping("/userHistory")
	public String getUserInfo(Integer openid , HttpServletRequest request){
		List<Info> userHistory = infoService.getUserHistory(openid);
		request.setAttribute("userHistory", userHistory);
		return "user/userHistory";
	}
	
	
	@RequestMapping("/detailInfo")
	public String getDetailInfo(Info info, int islike , HttpServletRequest request){
	
		List<Comment> comments = infoService.getCommentsOfInfo(info.getInfoId());
		request.setAttribute("info", info);
		request.setAttribute("comments", comments);
		request.setAttribute("islike", islike);
		
		return "infoDetail";
	}
	
	@RequestMapping("/publishInfo")
	public String publishInfo(Info info,HttpServletRequest req,MultipartHttpServletRequest request){
		
		if(infoService.publishInfo(info,request)){
			return "forward:/info/infoCenter";
		}
		return "/fail";
	}
	
	@RequestMapping("/publishComment")
	@ResponseBody
	public String publishComment(Comment comment){
		
		if(infoService.publishComent(comment)){
			return "success";
		}
		
		return "fail";
	}
	
	@RequestMapping("/setLikeInfo")
	@ResponseBody
	public String setLikeInfo(LikeInfo likeInfo,int setStatus){
		
		if(infoService.setLikeInfo(likeInfo,setStatus)){
			return "success";
		}
		
		return "fail";
	}
	
	@RequestMapping("/getInfoByScroll")
	@ResponseBody
	public List<Info> getInfoByScroll(Integer start , Integer end){
		 // start 起码从11开始 end起码从20开始
		return  infoService.getInfoByRange(start, end);
		
	}
	
	@RequestMapping("/getCommentByScroll")
	@ResponseBody
	public List<Comment> getCommentByScroll(Integer infoId , Integer start , Integer end){
		// start 起码从11开始 end起码从20开始
		return  infoService.getCommentByRange(infoId,start, end);
		
	}
	
	
}
