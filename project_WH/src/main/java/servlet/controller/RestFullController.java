package servlet.controller;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import servlet.DTO.SggDTO;
import servlet.service.FileService;
import servlet.service.TlService;

@RestController
public class RestFullController {

	@Resource(name = "TlService")
	private TlService tlService;
	
	@Resource(name="FileService")
	private FileService fileService;
	
	
	@PostMapping("/selectSgg.do")
	   public Map<String,Object> selectSgg(@RequestParam("test") String name) {
	      List<SggDTO> list = tlService.selectSgg(name);
	      List<Map<String, Object>> geom = tlService.selectGeom(name);
	      
	      Map<String,Object> map = new HashMap<String, Object>();
	      
	      map.put("list", list);
	      map.put("geom", geom);
	      
	      System.out.println(list);
	      return map;
	   }
	
	@PostMapping("/selectB.do")
	    public Map<String, Object> selectB(@RequestParam("sggzoom") String name) {
		Map<String, Object> geom = tlService.selectB(name);
		System.out.println(name);
		System.out.println(geom);
	      return geom;
	   }
	
	@PostMapping("/legend.do")
	public Map<String, Object> legend(@RequestParam("legend") String legend) {
		
	    Map<String, Object> response = new HashMap<>();
	    
	    if (legend.equals("deung")) {
	    	response.put("legend",tlService.deung());
	    	System.out.println(tlService.deung());	        
	    } else if (legend.equals("natural")) {
	    	response.put("legend",tlService.natural());
	    	System.out.println(tlService.natural());	        
	    }
	    return response;
	}
	
	@PostMapping("/chart.do")
	public Map<String, Object> chart(@RequestParam("sdcd") String sdcd) {
		Map<String, Object> response = new HashMap<>();
		response.put("chartData", sdcd);
		return response;
	}
	
	

	@PostMapping("/fileUpload.do")
	public void fileUpload(@RequestParam("testfile") MultipartFile multi) throws IOException {

		System.out.println(multi.getOriginalFilename());
		System.out.println(multi.getName());
		System.out.println(multi.getContentType());
		System.out.println(multi.getSize());

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		InputStreamReader isr = new InputStreamReader(multi.getInputStream());
		BufferedReader br = new BufferedReader(isr);

		String line = null;
		while ((line = br.readLine()) != null) {
			Map<String, Object> m = new HashMap<String, Object>();
			String[] lineArr = line.split("\\|");

			System.out.println(Arrays.toString(lineArr));
			m.put("yearMonthUse", lineArr[0]); // 사용년월
			m.put("landLocation", lineArr[1]); // 대지위치
			m.put("roadLandLocation", lineArr[2]); // 도로명대지위치 
			m.put("sggCode", lineArr[3]); // 시군구코드
			m.put("bjdCode", lineArr[4]); // 법정동코드 
			m.put("landCode", lineArr[5]); // 대지구분코드 
			m.put("bun", lineArr[6]); // 번 
			m.put("ji", lineArr[7]); // 지 
			m.put("newAddNumber", lineArr[8]); // 새주소일련번호
			m.put("newRoadCode", lineArr[9]); // 새주소도로코드 
			m.put("newLandCode", lineArr[10]);// 새주소지상지하코드
			m.put("newbonbeon", !lineArr[11].isEmpty() ? Integer.parseInt(lineArr[11]) : 0); // 새주소본번 
			m.put("newbubeon", lineArr[12] == "" ? Integer.parseInt(lineArr[12]) : 0); // 새주소부번 
			m.put("usage", lineArr[13] == "" ? Integer.parseInt(lineArr[13]) : 0); // 사용량
           
			list.add(m);
		}
		fileService.uploadFile(list);

		br.close();
		isr.close();
	}
}
