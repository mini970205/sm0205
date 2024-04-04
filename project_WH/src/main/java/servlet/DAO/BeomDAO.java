package servlet.DAO;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BeomDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public List<Map<String, Object>> natural() {
		return sqlSession.selectList("BeomMapper.natural");
	}

	public List<Map<String, Object>> deung() {
		return sqlSession.selectList("BeomMapper.deung");
	}

}
