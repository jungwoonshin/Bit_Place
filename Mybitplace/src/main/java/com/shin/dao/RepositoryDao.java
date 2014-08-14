package com.shin.dao;

import java.util.HashMap;
import java.util.List;

import com.shin.vo.Content;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryDao {
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;

	public int selectMno(String user_email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			HashMap<String,String> params = new HashMap<String,String>();
			params.put("user_email", user_email);
			return sqlSession.selectOne("com.shin.RepositoryDao.selectMno" , params);
		} catch (Exception e) {
			throw e;
		} finally {
			sqlSession.close();
		}
	}

	public List<String> selectClass(int mno) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			HashMap<String,Integer> params = new HashMap<String,Integer>();
			params.put("mno", mno);
			return sqlSession.selectList("com.shin.RepositoryDao.selectClass" , params);
		} catch (Exception e) {
			throw e;
		} finally {
			sqlSession.close();
		}
		
		
	}
	public List<Content> selectContents(int groupNo) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			HashMap<String,Integer> params = new HashMap<String,Integer>();
			params.put("groupNo", groupNo);

			return sqlSession.selectList("com.shin.RepositoryDao.selectContents", params);

		} catch (Exception e) {
			throw e;

		} finally {
			sqlSession.close();
		}
	}

	public int selectGroupNo(int mno) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			HashMap<String,Integer> params = new HashMap<String,Integer>();
			params.put("mno", mno);
			return sqlSession.selectOne("com.shin.RepositoryDao.selectGroupNo" , params);
		} catch (Exception e) {
			throw e;
		} finally {
			sqlSession.close();
		}
	}

	public List<Content> selectOneContent(int content_no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectList("com.shin.RepositoryDao.selectOneContent" , content_no);
		} catch (Exception e) {
			throw e;
		} finally {
			sqlSession.close();
		}
	}




}
