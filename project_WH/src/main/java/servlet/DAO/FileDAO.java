package servlet.DAO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileDAO {

	@Autowired
	private SqlSession sqlSession;

	public void uploadFile(List<Map<String, Object>> list) {
		for (Map<String, Object> data : list) {
			sqlSession.insert("uploadFile.uploadFile", data);
		}
		
	}

	
}
