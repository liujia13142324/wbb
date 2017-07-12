package com.l.wbb.mapper;

import com.l.wbb.bean.User;


public interface UserMapper {

	int insertUser(User user);

	User selectUser(String openid);

}
