package com.springbook.biz.user.impl;

import com.springbook.biz.user.UserVO;

public interface UserService {
	
	// 회원 등록 확인
	UserVO getUser(UserVO vo);
}
