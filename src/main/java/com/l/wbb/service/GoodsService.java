package com.l.wbb.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.l.wbb.bean.Category;
import com.l.wbb.bean.Comment;
import com.l.wbb.bean.Goods;
import com.l.wbb.bean.GoodsComment;
import com.l.wbb.bean.GoodsImage;

public interface GoodsService {

	List<Category> getCategory();

	List<Goods> getGoodsByRange(Integer start, Integer end);

	List<GoodsComment> getCommentByRange(Integer goodsId, Integer start, Integer end);

	List<Goods> getGoodsByCategory(Integer categoryId);

	List<Goods> getUserHistory(Integer openid);

	List<GoodsImage> getSubImage(Integer imgId);

	boolean publishGoods(Goods goods, MultipartHttpServletRequest request);

	boolean publishComent(GoodsComment comment);

}
