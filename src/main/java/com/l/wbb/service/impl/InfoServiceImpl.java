package com.l.wbb.service.impl;

import java.util.ArrayList;
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
		List<Theme> themes = new ArrayList<Theme>();
		// TODO 1.获得所有主题信息，直接返回
		//  2.捕获异常，不做任何处理,成功返回themes,失败返回null
		
		return null;
	}

	
	@Override
	public List<Info> getFirstPageInfo() {
		//   步骤都在这个方法里面
		return getInfoByRange(1,10);
	}
	
	@Override
	public List<Info> getInfoByTheme(Integer themeId) {
		// TODO 要求同上，多加一个条件查找当前主题的info
		return getThemeInfoByRange(themeId,1,10);
	}


	@Override
	public List<Info> getUserHistory(Integer openid) {
		List<Info> infos = new ArrayList<Info>();
		// TODO 1.获取该用户的信息
			//	2.按时间排序返回即可，最新的在上面
			//  3.进行异常捕获，不做任何处理，失败了返回null,成功返回  infos
			//  4.获得前十个数据 ，以上皆为一条sql完成
		return null;
	}

	@Override
	public List<Comment> getCommentsOfInfo(Integer infoId) {
		return getCommentByRange(infoId, 1, 10);
	}


	private List<Image> uploadImg(Info info,MultipartHttpServletRequest request) {
		List<Image> imgs = new ArrayList<Image>();
		// TODO 1. 获取request中的所有图片的文件，按照 openid_infoId_fileName 进行命名，存储到服务器的upload文件夹
			//  2. 设置 info 的 imgs，初始化一个List 每保存一张图片，生成一个image加入到List中
			//  3. 进行异常捕获，不做任何处理，失败了返回null,成功返回  imgs
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
	/*lxd*/
	@Override
	public boolean publishComent(Comment comment) {
		comment.setPublishDate(new Date());
		// TODO 1.将 comment插入数据库
			//  2.捕获异常，不做任何处理
		return infoMapper.publishComent(comment)>0;
	}
	/*lxd*/
	@Override
	public boolean setLikeInfo(LikeInfo likeInfo , int setStatus) {
		// TODO  // 1.判断setStatus字段
				//  2. 如果status==1 则将 likeInfo 插入数据库
				//  3. 如果status==0 则将 likeInfo 从数据库删除
				//  4.捕获异常，不做任何处理 , 
		int result;
		if(setStatus==1){
			result=infoMapper.addLikeInfo(likeInfo);
		}else if(setStatus==0){
			result=infoMapper.deleteLikeInfo(likeInfo);
		}else{
			result=0;
		}
		return result>0;
	}
	/*lxd*/
	public List<Info> getInfoByRange(Integer start, Integer end){
		List<Info> infos = new ArrayList<Info>();
			//TODO
			//1.查出 commentCount + likeinfo 最多的数据 
		    //2.查询到最火的数据后，再 union 其他数据，按时间倒叙，新的在上面，且数据的ID不等于最火数据的Id（因为已经查出来放在了最前面）
		    //3.获得 start ~ end 的数据 ，以上皆为一条sql完成
			//4.进行异常捕获，不做任何处理，失败了返回null,成功返回  infos
		
		infos=infoMapper.getInfoByRange(start,end);
		
		return infos;
	}
	/*lxd*/
	@Override
	public List<Comment> getCommentByRange(Integer infoId,Integer start, Integer end) {
		List<Comment> comments = new ArrayList<Comment>();
		// TODO 
		//  1.获取所有评论信息按时间倒叙返回，最早发表的评论在最前面 
		//  2.获得start ~ end 的数据 ，以上皆为一条sql完成
		//  3.进行异常捕获，不做任何处理，失败了返回null,成功返回  comments 
		comments=infoMapper.getCommentByRange(infoId,start,end);
		return comments;
	}
	
	public List<Info> getThemeInfoByRange(Integer themeId,Integer start, Integer end) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
