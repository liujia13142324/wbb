package com.l.wbb.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.l.wbb.bean.Comment;
import com.l.wbb.bean.Info;
import com.l.wbb.bean.LikeInfo;
import com.l.wbb.bean.PaginationBean;
import com.l.wbb.bean.Theme;

public interface InfoService {

	List<Theme> getAllTheme();

	List<Info> getUserHistory(Integer openid);

	List<Comment> getCommentsOfInfo(Integer infoId);

	boolean publishInfo(Info info , MultipartHttpServletRequest request);

	boolean publishComent(Comment comment);

	boolean setLikeInfo(LikeInfo likeInfo,int setStatus);

	List<Info> getInfoByTheme(Integer themeId);

	List<Info> getFirstPageInfo();

	List<Info> getInfoByRange(Integer start , Integer end);

	List<Info> getThemeInfoByRange(Integer ThemeId , Integer start, Integer end);
	
	List<Comment> getCommentByRange(Integer infoId,Integer start, Integer end);

}
