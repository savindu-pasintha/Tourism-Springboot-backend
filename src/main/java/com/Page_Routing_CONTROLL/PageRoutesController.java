package com.Page_Routing_CONTROLL;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageRoutesController {
	
	@RequestMapping("/")
    public ModelAndView getDefault(){ return new ModelAndView("indexTemplate.html");}
	
	@RequestMapping("/page")
    public ModelAndView page(){ return new ModelAndView("page.html");}
	
	@RequestMapping(value = "/test", method = {RequestMethod.GET, RequestMethod.POST})
    public void test(HttpServletResponse response) throws IOException {
        System.out.println("HELLO WORLD");
        }

}
