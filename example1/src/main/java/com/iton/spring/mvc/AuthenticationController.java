package com.iton.spring.mvc;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iton.sprint.dto.User;
import com.iton.sprint.dto.UserDAO;
import com.iton.sprint.dto.UserDTO;
import com.iton.sprint.dto.UserDetails;

@Controller
public class AuthenticationController {
	
	@RequestMapping(value="/")
	public String authenticateUser(ModelMap modelMap,HttpSession httpSession){
		modelMap.addAttribute("user", new User());
		System.out.println("first step");
		return "login";
	}
	@RequestMapping(value="login",method=RequestMethod.POST )
	public String authenticationProcess(@ModelAttribute("user")User user,ModelMap modelMap,HttpSession httpSession){
		System.out.println("LLLLLLLLL 2nd step");
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		UserDTO userDTO=new UserDTO();
		userDTO.setUser(user);
		httpSession.setAttribute("dto",userDTO);
		modelMap.addAttribute("userDetails", new UserDetails());
		return "result";
	}
	@RequestMapping(value="userDetails",method=RequestMethod.POST)
	public String detailsgathering(@ModelAttribute("userData")UserDetails userDetails,ModelMap modelMap,HttpSession httpSession){
		System.out.println("LLLLLLLL");
		UserDTO dto=(UserDTO) httpSession.getAttribute("dto");
		dto.setUserDetails(userDetails);
		httpSession.setAttribute("dto",dto);
		//dto.setUserDetails(userDetails);
	//	UserDAO dao=dtoToDAOConvertion(dto);
		modelMap.addAttribute("dto", dto);
		System.out.println(userDetails);
		System.out.println(dto);
		return "result1";
	}
	@RequestMapping(value="userDetails1",method=RequestMethod.POST )
	public String detailsgathering1(@ModelAttribute("userData1")UserDetails userDetails,ModelMap modelMap,HttpSession httpSession){
		System.out.println("LLLLLL0000000LL");
		UserDTO dto=(UserDTO) httpSession.getAttribute("dto");
		dto.setUserDetails(userDetails);
		httpSession.setAttribute("dto",dto);
		//UserDAO dao=dtoToDAOConvertion(dto);
		//modelMap.addAttribute("dao", dao);
		System.out.println(userDetails);
		
		return "result1";
	}
	private UserDAO dtoToDAOConvertion(UserDTO dto) {
		UserDAO dao=new UserDAO();
		dao.setAge(dto.getUserDetails().getUserAge());
		dao.setFrom(dto.getUserDetails().getVilalge());
		dao.setNameClass(dto.getUserDetails().getClassName());
		dao.setUserName(dto.getUser().getUserName());
		dao.setPassword(dto.getUser().getPassword());
		return dao;
	}
		
}
