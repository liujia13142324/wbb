package com.l.wbb.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.l.wbb.bean.Comment;
import com.l.wbb.bean.Info;
import com.l.wbb.bean.LikeInfo;
import com.l.wbb.bean.Theme;

public interface InfoService {

	List<Theme> getAllTheme();

	List<Info> getUserHistory(String openid,HttpSession session,HttpServletResponse response);

	List<Comment> getCommentsOfInfo(Integer infoId);

	boolean publishInfo(Info info , MultipartHttpServletRequest request);

	boolean publishComent(Comment comment);

	boolean setLikeInfo(LikeInfo likeInfo,int setStatus);

	List<Info> getInfoByTheme(Integer themeId, HttpServletResponse response, HttpSession session);

	List<Info> getInfoByRange(Integer start , Integer end , HttpServletResponse response,HttpSession session);

	List<Info> getThemeInfoByRange(Integer ThemeId , Integer start, Integer end, HttpServletResponse response , HttpSession session);
	
	List<Comment> getCommentByRange(Integer infoId,Integer start, Integer end);

}
