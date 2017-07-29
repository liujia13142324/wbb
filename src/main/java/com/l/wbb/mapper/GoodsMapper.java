package com.l.wbb.mapper;

import java.util.List;

import com.l.wbb.bean.Category;
import com.l.wbb.bean.Goods;
import com.l.wbb.bean.GoodsComment;
import com.l.wbb.bean.GoodsImage;

public interface GoodsMapper {

	public List<Category> getCategory();

	public List<Goods> getGoodsByRange(Integer start, Integer end);

	public List<GoodsComment> getCommentByRange(Integer goodsId,Integer start,Integer end);

	public List<Goods> getCategoryGoodsByRange(Integer categoryId,Integer start, Integer end);

	public List<Goods> getGoodsBySearch(String searchCondition);

	public List<Goods> getUserHistory(Integer openid);

	public List<GoodsImage> getSubImage(Integer imgId);

	public boolean publishComent(GoodsComment comment);

}
