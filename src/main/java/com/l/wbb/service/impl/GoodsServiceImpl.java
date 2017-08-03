package com.l.wbb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.l.wbb.bean.Category;
import com.l.wbb.bean.Goods;
import com.l.wbb.bean.GoodsComment;
import com.l.wbb.bean.GoodsImage;
import com.l.wbb.mapper.GoodsMapper;
import com.l.wbb.service.GoodsService;

/**
 * 逻辑步骤原则
 * 1.牵扯到多条sql，多次操作数据库的时候，要添加事务操作
 * 2.牵扯到实务操作就不要捕获异常，我在上层捕获。其他所有未牵扯到事务操作的数据库操作都要捕获异常
 * （就算没报错，也要手动捕获）
 * 3.mapper里面的sql语句也一样，不要偷懒，只写上操作的数据的字段，禁止用 *号
 * 4.不懂问我
 * @author ua
 *
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	private GoodsMapper goodsMapper;
	@Override
	public List<Category> getCategory() {
		List<Category> categories=new ArrayList<Category>();
		// TODO Auto-generated method stub
		try {
			categories=goodsMapper.getCategory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public List<Goods> getGoodsByRange(Integer start, Integer end) {
		List<Goods> goods=new ArrayList<Goods>();
		// TODO Auto-generated method stub
	    //1.查询 goods表，按照时间倒叙，得到 start ~ end 的数据，返回
		//2.进行异常捕获，不做任何处理，失败了返回null,成功返回  infos
		try {
			goods=goodsMapper.getGoodsByRange(start,end);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goods;
	}

	@Override
	public List<GoodsComment> getCommentByRange(Integer goodsId, Integer start, Integer end) {
		List<GoodsComment> goodsComments=new ArrayList<GoodsComment>();
		// TODO Auto-generated method stub
		try {
			goodsComments=goodsMapper.getCommentByRange(goodsId,start,end);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goodsComments;
	}

	@Override
	public List<Goods> getCategoryGoodsByRange(Integer categoryId, Integer start, Integer end) {
		List<Goods> categoryGoods=new ArrayList<Goods>();
		// TODO Auto-generated method stub
		try {
			categoryGoods=goodsMapper.getCategoryGoodsByRange(categoryId,start,end);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryGoods;
	}
	
	@Override
	public List<Goods> getGoodsBySearch(String searchCondition) {
		List<Goods> searchGoods=new ArrayList<Goods>();
		// TODO 使用sql模糊匹配即可 like '%searchCondition%'
		try {
			searchGoods=goodsMapper.getGoodsBySearch(searchCondition);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchGoods;
	}

	@Override
	public List<Goods> getUserHistory(String openid) {
		List<Goods> historyGoods=new ArrayList<Goods>();
		// TODO Auto-generated method stub
		try {
			historyGoods=goodsMapper.getUserHistory(openid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return historyGoods;
	}

	@Override
	public List<GoodsImage> getSubImage(Integer imgId) {
		List<GoodsImage> img=new ArrayList<GoodsImage>();
		// TODO Auto-generated method stub
		try {
			img=goodsMapper.getSubImage(imgId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
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
		Iterator<String> iter = request.getFileNames();
		return null;
	}

	@Override
	public boolean publishComent(GoodsComment comment) {
		// TODO Auto-generated method stub
		boolean result=false;
		try {
			result=goodsMapper.publishComent(comment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


}
