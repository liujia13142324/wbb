package com.l.wbb.web.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.l.wbb.bean.Category;
import com.l.wbb.bean.Comment;
import com.l.wbb.bean.Goods;
import com.l.wbb.bean.GoodsComment;
import com.l.wbb.bean.GoodsImage;
import com.l.wbb.bean.Info;
import com.l.wbb.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsHandler {

	@Autowired
	private GoodsService goodsService;

	@RequestMapping("/goodsCenter")
	public String enterGoodsCenter(HttpServletRequest request, Integer categoryId , String searchCondition) {

		List<Category> categories = goodsService.getCategory();
		List<Goods> products = null;
		if (categoryId != null) {
			products = goodsService.getCategoryGoodsByRange(categoryId,1,10);
		}else if(searchCondition != null){
			products = goodsService.getGoodsBySearch(searchCondition);
		} else {
			products = goodsService.getGoodsByRange(1, 10);
		}

		if (categories != null && products != null) {
			request.setAttribute("categories", categories);
			request.setAttribute("products", products);
			return "/page/goodsCenter";
		}

		return "/fail";
	}

	@RequestMapping("/userHistory")
	public String getUserInfo(Integer openid, HttpServletRequest request) {
		List<Goods> userHistory = goodsService.getUserHistory(openid);
		request.setAttribute("userHistory", userHistory);
		return "user/userGoodsHistory";
	}
	
	@RequestMapping("/detailGoods")
	public String getDetailInfo(Goods goods,  HttpServletRequest request){
	
		List<GoodsComment> comments = goodsService.getCommentByRange(goods.getGoodsId(),1,10);
		List<GoodsImage> subImgs = goodsService.getSubImage(goods.getMainImage().getImgId());
		subImgs.add(0, goods.getMainImage());
		request.setAttribute("goods", goods);
		request.setAttribute("imgs", subImgs);
		request.setAttribute("comments", comments);
		
		return "goodsDetail";
	}

	
	@RequestMapping("/getGoodsByScroll")
	@ResponseBody
	public List<Goods> getInfoByScroll(Integer start , Integer end){
		 // start 起码从11开始 end起码从20开始
		return  goodsService.getGoodsByRange(start, end);
		
	}
	
	@RequestMapping("/getCategoryGoodsByScroll")
	@ResponseBody
	public List<Goods> getCategoryInfoByScroll(Integer categoryId ,Integer start , Integer end){
		 // start 起码从11开始 end起码从20开始
		return  goodsService.getCategoryGoodsByRange(categoryId, start, end);
		
	}
	
	
	@RequestMapping("/getGoodsCommentByScroll")
	@ResponseBody
	public List<GoodsComment> getCommentByScroll(Integer infoId , Integer start , Integer end){
		// start 起码从11开始 end起码从20开始
		return  goodsService.getCommentByRange(infoId,start, end);
		
	}
	
	
	@RequestMapping("/publishGoods")
	public String publishInfo(Goods goods,HttpServletRequest req,MultipartHttpServletRequest request){
		
		if(goodsService.publishGoods(goods,request)){
			return "forward:/goods/goodsCenter";
		}
		return "/fail";
	}
	
	@RequestMapping("/publishGoodsComment")
	@ResponseBody
	public String publishComment(GoodsComment comment){
		
		if(goodsService.publishComent(comment)){
			return "success";
		}
		
		return "fail";
	}
	
	
}
