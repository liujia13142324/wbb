package com.l.wbb.web.handler;

import java.security.Provider.Service;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.l.wbb.bean.Category;
import com.l.wbb.bean.Goods;
import com.l.wbb.bean.GoodsComment;
import com.l.wbb.bean.GoodsImage;
import com.l.wbb.bean.User;
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
			products = goodsService.getCategoryGoodsByRange(categoryId,0,10);
		}else if(searchCondition != null){
			products = goodsService.getGoodsBySearch(searchCondition);
		} else {
			products = goodsService.getGoodsByRange(0, 10);
		}

		if (categories != null && products != null) {
			request.setAttribute("categories", categories);
			request.setAttribute("products", products);
			return "/page/goodsCenter";
		}

		return "/fail";
	}

	@RequestMapping("/getCategoryGoods")
	@ResponseBody
	public List<Goods> getGoodsByCategory(Integer categoryId ){
		if(categoryId>0)
			return  goodsService.getCategoryGoodsByRange(categoryId,0,10);
		else
			return goodsService.getGoodsByRange(0, 10);
	}
	
	@RequestMapping("/getGoodsBySearch")
	@ResponseBody
	public List<Goods> getGoodsBySearch(String searchCondition ){
		return goodsService.getGoodsBySearch(searchCondition);
	}
	
	
	@RequestMapping("/userHistory")
	public String getUserInfo(HttpSession session, HttpServletRequest request) {
		User user = (User) session.getAttribute("user");
		if(user!=null){
			List<Goods> userHistory = goodsService.getUserHistory(user.getOpenid());
			request.setAttribute("products", userHistory);
			return "page/user/userGoodsHistory";
		}else{
			return"redirect:/center/enter";
		}
		
	}
	
	@SuppressWarnings({ "unused", "unused" })
	@RequestMapping("/detailGoods")
	public String getDetailInfo(Goods goods,  HttpServletRequest request , HttpSession session){
	
		List<GoodsComment> comments = goodsService.getCommentByRange(goods.getGoodsId(),0,10);
		List<GoodsImage> subImgs = goodsService.getSubImage(goods.getMainImage().getImgId());
		subImgs.add(0, goods.getMainImage());
		LogManager.getLogger().debug("请求："+goods);
	
		request.setAttribute("lastGoods", goods);
		request.setAttribute("imgs", subImgs);
		request.setAttribute("comments", comments);
		return "page/goodsDetail";
		
	}

	
	@RequestMapping("/getGoodsByScroll")
	@ResponseBody
	public List<Goods> getInfoByScroll(Integer start , Integer offset){
		 // start 起码从11开始 end起码从20开始
		return  goodsService.getGoodsByRange(start, offset);
		
	}
	
	@RequestMapping("/getCategoryGoodsByScroll")
	@ResponseBody
	public List<Goods> getCategoryInfoByScroll(Integer categoryId ,Integer start , Integer offset){
		 // start 起码从11开始 end起码从20开始
		return  goodsService.getCategoryGoodsByRange(categoryId, start, offset);
		
	}
	
	
	@RequestMapping("/getGoodsCommentByScroll")
	@ResponseBody
	public List<GoodsComment> getCommentByScroll(Integer goodsId , Integer start , Integer offset){
		// start 起码从11开始 end起码从20开始
		return  goodsService.getCommentByRange(goodsId,start, offset);
		
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
	public Object publishComment(GoodsComment comment,HttpSession session){
		
		User user = (User)session.getAttribute("user");
		if(user != null){
			comment.setUser(user);
			comment.setPublishDate(new Date());
			if(goodsService.publishComent(comment)){
				return comment;
			}else{
				return "fail";
			}
		}else{
			return "unlogin";
		}
	}
	
	@RequestMapping("/enterPublishGoods")
	public String enterPublishGoods(GoodsComment comment){
		return "page/user/publishGoods";
	}
	
	
}
