package com.l.wbb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.l.wbb.bean.Category;
import com.l.wbb.bean.Goods;
import com.l.wbb.bean.GoodsComment;
import com.l.wbb.bean.GoodsImage;

public interface GoodsMapper {

	public List<Category> getCategory();

	public List<Goods> getGoodsByRange(@Param("start")Integer start,@Param("end") Integer end);

	public List<GoodsComment> getCommentByRange(@Param("goodsId")Integer goodsId,@Param("start")Integer start,@Param("end")Integer end);

	public List<Goods> getCategoryGoodsByRange(@Param("categoryId")Integer categoryId,@Param("start")Integer start, @Param("end")Integer end);

	public List<Goods> getGoodsBySearch(String searchCondition);

	public List<Goods> getUserHistory(String openid);

	public List<GoodsImage> getSubImage(Integer imgId);

	public boolean publishComent(GoodsComment comment);

}
