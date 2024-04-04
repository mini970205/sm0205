package servlet.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import servlet.DTO.SdDTO;
import servlet.service.ServletService;
import servlet.service.TlService;

@Controller
public class ServletController {
   @Resource(name = "ServletService")
   private ServletService servletService;
   
   @Resource(name="TlService")
   private TlService TlService;
   
   @RequestMapping(value = "/main.do")
   public String mainTest(ModelMap model) throws Exception {
      List<SdDTO> list = TlService.selectSd();
      model.addAttribute("sdlist",list);
      System.out.println(list.get(0).getSd_nm());
      return "main/main";
   }
   
   
   @RequestMapping("/test.do")
   public String test() {
      return "main/test";
   }
}