package com.l.wbb.mapper;

import java.util.List;

import com.l.wbb.bean.Image;
import com.l.wbb.bean.Info;
import com.l.wbb.bean.Theme;

public interface InfoMapper {

	List<Theme> getAllTheme();

	int insertInfo(Info info);

	int insertImage(List<Image> imgs);

	List<Info> getUserHistory(String openid);

	List<Info> getInfoByTheme(Integer themeId);

}
