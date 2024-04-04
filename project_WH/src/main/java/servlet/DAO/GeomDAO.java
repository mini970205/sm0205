package servlet.DAO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GeomDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<Map<String, Object>> selectGeom(String name) {
		return sqlSession.selectList("SggMapper.selectGeom", name);
	}

	public Map<String, Object> selectB(String name) {
		System.out.println(name);
		return sqlSession.selectOne("SggMapper.selectB", name);
	}


}
