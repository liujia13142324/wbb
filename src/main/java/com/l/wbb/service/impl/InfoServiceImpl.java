package com.l.wbb.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.l.wbb.bean.Comment;
import com.l.wbb.bean.Image;
import com.l.wbb.bean.Info;
import com.l.wbb.bean.LikeInfo;
import com.l.wbb.bean.Theme;
import com.l.wbb.mapper.InfoMapper;
import com.l.wbb.service.InfoService;

@Service("infoService")
public class InfoServiceImpl implements InfoService {

	private InfoMapper infoMapper;
	
	@Override
	public List<Theme> getAllTheme() {
		// TODO 1.获得所有主题信息，直接返回
		//  2.捕获异常，不做任何处理
		return null;
	}

	@Override
	public List<Info> getAllInfo() {
		// TODO 1.获得所有的info信息   2.将 commentCount + likeinfo.size()最多的选出来放在最前面 3.返回
		// 查询按使时间排序！最新的在上面
		//  2.捕获异常，不做任何处理
		return null;
	}

	@Override
	public List<Info> getUserHistory(Integer openid) {
		// TODO 1.获取该用户的的所有信息 2.按时间排序返回即可，最新的在上面
			//  2.捕获异常，不做任何处理
		return null;
	}

	@Override
	public List<Comment> getCommentsOfInfo(Integer infoId) {
		// TODO 1.获取所有评论信息按时间倒叙返回，最早发表的评论在最前面 
			//  2.捕获异常，不做任何处理
			
		return null;
	}


	private List<Image> uploadImg(Info info,MultipartHttpServletRequest request) {
		// TODO 1. 获取request中的所有图片的文件，按照 openid_infoId_fileName 进行命名，存储到服务器的upload文件夹
			//  2. 设置 info 的 imgs，初始化一个List 每保存一张图片，生成一个image加入到List中
			//  3. 进行异常捕获，不做任何处理，失败了返回null,成功返回 List
		return null;
	}
	
	@Transactional  // 事务操作，不捕获异常，异常上抛
	public boolean publishInfo(Info info,MultipartHttpServletRequest request) {
		// TODO 1.将所有的图片文件进行存储
		List<Image> imgs = uploadImg(info,request);
		if(imgs != null){
			//  2. 将imgs插入 image表 
			info.setPublishTime(new Date());
			//  3. 将info插入 info表
		}
			
		return false;
	}

	@Override
	public boolean publishComent(Comment comment) {
		comment.setPublishDate(new Date());
		// TODO 1.将 comment插入数据库
			//  2.捕获异常，不做任何处理
		return false;
	}

	@Override
	public boolean setLikeInfo(LikeInfo likeInfo , int setStatus) {
		// TODO  // 1.判断setStatus字段
				//  2. 如果status==1 则将 likeInfo 插入数据库
				//  3. 如果status==0 则将 likeInfo 从数据库删除
				//  4.捕获异常，不做任何处理
		return false;
	}

}
