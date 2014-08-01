package bitplace.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Bit_Rep {

@Autowired
SqlSessionFactory sqlSessionFactory;

public Object getGroups(Integer no) throws Exception{
	SqlSession sqlSession = sqlSessionFactory.openSession();
	try{
			return sqlSession.selectList("bean-mapper.group",no);
	}catch(Exception e){
		throw e;
	}finally{
		sqlSession.close();
	}
}

public Object getTitles(Integer group) {
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	try{
	return sqlSession.selectList("bean-mapper.title",group);
	}catch(Exception e){
		throw e;
	}finally{
		sqlSession.close();
	}
}


public Object getSubs(Integer group) {
	SqlSession sqlSession = sqlSessionFactory.openSession();
	try{
		return sqlSession.selectList("bean-mapper.sub",group);
	}catch(Exception e){
		throw e;
	}finally{
		sqlSession.close();
	}
}

}
