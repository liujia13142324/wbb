package com.l.wbb.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.l.wbb.bean.Comment;
import com.l.wbb.bean.Image;
import com.l.wbb.bean.Info;
import com.l.wbb.bean.LikeInfo;
import com.l.wbb.bean.Theme;
import com.l.wbb.context.WBBConst;
import com.l.wbb.mapper.InfoMapper;
import com.l.wbb.service.InfoService;

@Service("infoService")
public class InfoServiceImpl implements InfoService {

	@Autowired
	private InfoMapper infoMapper;

	@Override
	public List<Theme> getAllTheme() {
		List<Theme> themes = new ArrayList<Theme>();
		// TODO 1.获得所有主题信息，直接返回
		//  2.捕获异常，不做任何处理,成功返回themes,失败返回null
		try {
			themes = infoMapper.getAllTheme();
		} catch (Exception e) {
			LogManager.getLogger().debug("获取主题失败！！！");
			return null;
		}
		return themes;
	}

	
	@Override
	public List<Info> getFirstPageInfo() {
		//   步骤都在这个方法里面
		return getInfoByRange(1,10);
	}
	
	


	@Override
	public List<Info> getInfoByTheme(Integer themeId) {

		List<Info> infos = new ArrayList<Info>();
		try {
			infos = infoMapper.getInfoByTheme(themeId);
		} catch (Exception e) {
			LogManager.getLogger().debug("获取主题内容失败！！！");
			return null;
		}
		return infos;

	}

	@Override
	public List<Info> getUserHistory(String openid) {
		List<Info> infos = new ArrayList<Info>();
		try {

			// TODO 1.获取该用户的信息
			// 2.按时间排序返回即可，最新的在上面
			// 3.进行异常捕获，不做任何处理，失败了返回null,成功返回 infos
			// 4.获得前十个数据 ，以上皆为一条sql完成

			infos = infoMapper.getUserHistory(openid);

		} catch (Exception e) {
			LogManager.getLogger().debug("获取用户历史信息失败！！！");

		}
		if (infos != null) {
			return infos;
		} else {
			return null;
		}

	}

	@Override
	public List<Comment> getCommentsOfInfo(Integer infoId) {
		return getCommentByRange(infoId, 1, 10);
	}

	private List<Image> uploadImg(Info info, MultipartHttpServletRequest request) {
		List<Image> imgs = new ArrayList<Image>();
		// TODO 1. 获取request中的所有图片的文件，按照 openid_infoId_fileName
		// 进行命名，存储到服务器的upload文件夹
		// 2. 设置 info 的 imgs，初始化一个List 每保存一张图片，生成一个image加入到List中
		// 3. 进行异常捕获，不做任何处理，失败了返回null,成功返回 imgs
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分MultipartHttpRequest
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());

				// 对上传文件进行处理
				if (!file.isEmpty()) {
					String path = request.getSession().getServletContext().getRealPath(WBBConst.UPLOADPATH);
					String fileName = file.getOriginalFilename();
					String suffix=null;
					if ((fileName != null) && (fileName.length() > 0)) {
						int dot = fileName.lastIndexOf('.');
						if ((dot > -1) && (dot < (fileName.length() - 1))) {
							suffix=fileName.substring(dot + 1);
						}
					}

					File targetFile = new File(path, fileName);
					if (!targetFile.exists()) {
						targetFile.mkdirs();
					}
					// 保存
					try {
						file.transferTo(targetFile);
						// 备份一份到工作目录，发布后可删除
						File workFile = new File(WBBConst.WORKIMGPATH + "/" + info.getOpenId() + new Date() + suffix);

						if (!workFile.exists()) {
							workFile.createNewFile();
						}

						FileInputStream imgin = new FileInputStream(targetFile);

						FileOutputStream imgout = new FileOutputStream(workFile);

						byte[] buff = new byte[1024];

						while (imgin.read(buff) != -1) {
							imgout.write(buff);
						}

						imgin.close();
						imgout.flush();
						imgout.close();

						// 设置入库image
						Image img = new Image();
						img.setInfoId(info.getInfoId());
						img.setImgPath(WBBConst.UPLOADPATH + "/" + info.getOpenId() + new Date() + suffix);
						imgs.add(img);
						LogManager.getLogger().debug("保存文件【" + fileName + "】成功...");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		
		}
		return imgs;
	}
	
	

	@Transactional // 事务操作，不捕获异常，异常上抛
	public boolean publishInfo(Info info, MultipartHttpServletRequest request) {
		// TODO 1.将所有的图片文件进行存储
		List<Image> imgs = uploadImg(info, request);
		boolean t1 = false, t2 = false;
		if (imgs != null) {
			// 2. 将info插入 info表
			t1 = infoMapper.insertInfo(info) > 0;
			// 3. 将imgs插入 image表
			t2 = infoMapper.insertImage(imgs) > 0;

			info.setPublishTime(new Date());

		}
		if (t1 && t2) {
			return true;
		} else {
			return false;
		}

	}
	/*lxd*/
	@Override
	public boolean publishComent(Comment comment) {
		comment.setPublishDate(new Date());
		// TODO 1.将 comment插入数据库
			//  2.捕获异常，不做任何处理
		int result=0;
		try {
			result=infoMapper.publishComent(comment);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LogManager.getLogger().debug("插入评论失败！");
			e.printStackTrace();
		}
		return result>0;
	}
	/*lxd*/
		
	public boolean setLikeInfo(LikeInfo likeInfo , int setStatus) {
		// TODO  // 1.判断setStatus字段
				//  2. 如果status==1 则将 likeInfo 插入数据库
				//  3. 如果status==0 则将 likeInfo 从数据库删除
				//  4.捕获异常，不做任何处理 , 
		int result=0;
		try {
			if(setStatus==1){
				result=infoMapper.addLikeInfo(likeInfo);
			}else if(setStatus==0){
				result=infoMapper.deleteLikeInfo(likeInfo);
			}else{
				result=0;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LogManager.getLogger().debug("点赞失败！");
			e.printStackTrace();
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
		try {
			infos=infoMapper.getInfoByRange(start,end);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LogManager.getLogger().debug("评论失败！");
			e.printStackTrace();
		}
		return infos;
	}
	/*lxd*/
	@Override
	public List<Comment> getCommentByRange(Integer infoId, Integer start, Integer end) {
		List<Comment> comments = new ArrayList<Comment>();
		// TODO
		// 1.获取所有评论信息按时间倒叙返回，最早发表的评论在最前面
		// 2.获得start ~ end 的数据 ，以上皆为一条sql完成
		// 3.进行异常捕获，不做任何处理，失败了返回null,成功返回 comments
		try {
			comments=infoMapper.getCommentByRange(infoId,start,end);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comments;
		
	}
	
	
	
	public List<Info> getThemeInfoByRange(Integer themeId,Integer start, Integer end) {
		// TODO Auto-generated method stub
		return null;
	}

}
