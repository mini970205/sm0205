package servlet.service;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import servlet.DAO.BeomDAO;
import servlet.DAO.ChartDAO;
import servlet.DAO.GeomDAO;
import servlet.DAO.SdDAO;
import servlet.DAO.SggDAO;
import servlet.DTO.SdDTO;
import servlet.DTO.SggDTO;

@Service("TlService")
public class TlServiceImpl implements TlService{
	
	@Autowired
	private SdDAO sdDAO;
	
	@Autowired
	private SggDAO sggDAO;
	
	@Autowired
	private GeomDAO geomDAO;
	
	@Autowired
	private BeomDAO beomDAO;
	
	@Autowired
	private ChartDAO chartDAO;
	
	@Override
	public List<SggDTO> selectSgg(String name) {
		return sggDAO.selectSgg(name);
	}

	@Override
	public List<SdDTO> selectSd() {
		return sdDAO.selectSd();
	}

	@Override
	public List<Map<String, Object>> selectGeom(String name) {
		return geomDAO.selectGeom(name);
	}

	@Override
	public Map<String, Object> selectB(String name) {
		return geomDAO.selectB(name);

	}

	@Override
	public List<Map<String, Object>> natural() {
		return beomDAO.natural();
	}

	@Override
	public List<Map<String, Object>> deung() {
		return beomDAO.deung();
	}

	@Override
	public List<Map<String, Object>> sdChart() {
		return chartDAO.sdChart();
	}

	@Override
	public List<Map<String, Object>> getChart(String sdcd) {
		return chartDAO.getChart(sdcd);
	}


	

	


}
