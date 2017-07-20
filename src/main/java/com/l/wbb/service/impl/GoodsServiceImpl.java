package com.l.wbb.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.l.wbb.bean.Category;
import com.l.wbb.bean.Goods;
import com.l.wbb.bean.GoodsComment;
import com.l.wbb.bean.GoodsImage;
import com.l.wbb.service.GoodsService;

public class GoodsServiceImpl implements GoodsService{

	@Override
	public List<Category> getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> getGoodsByRange(Integer start, Integer end) {
		// TODO Auto-generated method stub
	    //1.查询 goods表，按照时间倒叙，得到 start ~ end 的数据，返回
		//2.进行异常捕获，不做任何处理，失败了返回null,成功返回  infos
		return null;
	}

	@Override
	public List<GoodsComment> getCommentByRange(Integer goodsId, Integer start, Integer end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> getGoodsByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> getUserHistory(Integer openid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsImage> getSubImage(Integer imgId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public boolean publishGoods(Goods goods, MultipartHttpServletRequest request) {
		// TODO 1.将所有的图片文件进行存储
		List<GoodsImage> imgs = uploadImg(goods,request);
		
		if(imgs != null){
			// 2. 将 imgs中第一个 GoodsImage 插入 mainImage
			// 3. 将imgs中其余插入 subImage表 
			goods.setPublishTime(new Date());
			// 4. 将goods插入 goods表
		}
		return false;
	}

	private List<GoodsImage> uploadImg(Goods goods, MultipartHttpServletRequest request) {
		// TODO 1. 获取request中的所有图片的文件，按照 openid_字母g_goodsId_fileName 进行命名，存储到服务器的upload文件夹
			//  2. 初始化一个List imgs 每保存一张图片，生成一个GoodsImage加入到imgs中
			//  3. 进行异常捕获，不做任何处理，失败了返回null,成功返回  imgs
		return null;
	}

	@Override
	public boolean publishComent(GoodsComment comment) {
		// TODO Auto-generated method stub
		return false;
	}

}
