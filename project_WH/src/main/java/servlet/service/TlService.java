package servlet.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import servlet.DTO.SdDTO;
import servlet.DTO.SggDTO;

@Service
public interface TlService {

	List<SggDTO> selectSgg(String name);
	
	List<SdDTO> selectSd();

	List<Map<String, Object>> selectGeom(String name);
	
	Map<String, Object> selectB(String name);
	
	List<Map<String, Object>> natural();
	
	List<Map<String, Object>> deung();

	List<Map<String, Object>> sdChart();

	List<Map<String, Object>> getChart(String sdcd);

}
