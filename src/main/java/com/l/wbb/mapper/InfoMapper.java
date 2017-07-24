package com.l.wbb.mapper;

import java.util.List;

import com.l.wbb.bean.Comment;
import com.l.wbb.bean.Info;
import com.l.wbb.bean.LikeInfo;

public interface InfoMapper {

	int publishComent(Comment comment);

	int addLikeInfo(LikeInfo likeInfo);

	int deleteLikeInfo(LikeInfo likeInfo);

	List<Comment> getCommentByRange(Integer infoId, Integer start, Integer end);

	List<Info> getInfoByRange(Integer start, Integer end);

}
