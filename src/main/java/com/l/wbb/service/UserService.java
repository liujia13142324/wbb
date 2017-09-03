package com.l.wbb.service;

import com.l.wbb.bean.User;
import com.l.wbb.bean.Wechat;

public interface UserService {

	User findUser(String code);

	void checkUser(User user);

	Wechat initJs();

}
