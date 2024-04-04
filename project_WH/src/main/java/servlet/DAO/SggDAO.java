package servlet.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import servlet.DTO.SggDTO;

@Repository
public class SggDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<SggDTO> selectSgg(String name) {
		return sqlSession.selectList("selectSgg", name);
	}
}
