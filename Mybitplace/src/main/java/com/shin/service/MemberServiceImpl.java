package com.shin.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shin.dao.MemberDao;
import com.shin.vo.Member;

/* StudentService 인터페이스의 구현체
 */

@Service
public class MemberServiceImpl implements MemberService {
  @Autowired
  MemberDao   memberDao;

  @Transactional(
      propagation=Propagation.REQUIRED, 
      rollbackFor={Throwable.class})
  public void signup(Member member) throws Exception {
    memberDao.insert(member);
  }
  
  @Override
  public Member exist(String email, String password) throws Exception {
    HashMap<String,Object> paramMap = new HashMap<String,Object>();
    paramMap.put("email", email);
    paramMap.put("pwd", password);
    
    return memberDao.exist(paramMap);
  }
}












