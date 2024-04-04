package servlet.DAO;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import servlet.DTO.SdDTO;

@Repository
public class SdDAO{
	
	@Autowired
	private SqlSession sqlSession;

	public List<SdDTO> selectSd() {
		return sqlSession.selectList("SdMapper.selectSd");
	}
	


	
	
	
}
