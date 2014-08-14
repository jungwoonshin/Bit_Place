package com.shin.dao;

import java.util.Map;

import com.shin.vo.Member;

public interface MemberDao {
	  Member exist(Map<String,Object> paramMap) throws Exception;
	  int insert(Member member) throws Exception;
}
