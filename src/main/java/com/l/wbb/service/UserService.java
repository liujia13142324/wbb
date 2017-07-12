package com.l.wbb.service;

import com.l.wbb.bean.User;

public interface UserService {

	User findUser(String code);

	void checkUser(User user);

}
