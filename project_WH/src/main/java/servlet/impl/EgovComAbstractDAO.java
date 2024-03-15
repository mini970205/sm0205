package servlet.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

public abstract class EgovComAbstractDAO extends EgovAbstractMapper{
	
	@Resource(name="sqlSession")
	public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
		super.setSqlSessionFactory(sqlSession);
	}
}
