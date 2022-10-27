package com.ssafy.admin.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

@RestController // @ResponseBody = 모든 String의 return이 @ResponseBody가 된다.
@RequestMapping("/admin")
public class AdminUserController {
	
	private MemberService memberService;
	
	public AdminUserController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> userList() { // ResponseEntity<Object Type = ?>
		try {
			List<MemberDto> list = memberService.listMember(null); // >>>>  JSON Array
			if (list!=null && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK); // 값, header
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // Void Object Type
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e); // 값, header
		}
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> userJoin(@RequestBody MemberDto memberDto) { // JSON Body로 넘어오므로 RequestBody
		try {
			memberService.joinMember(memberDto); 
			List<MemberDto> list = memberService.listMember(null); // >>>>  JSON Array
			if (list!=null && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK); // 값, header
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // Void Object Type
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e); // 값, header
		}
	}
	
	@GetMapping("/user/{userid}") // parameter로 넘어오는 인자값은 requestparam으로 받고 URL로 넘어오는 값은 @Pathvariable 
	public ResponseEntity<?> userView(@PathVariable("userid") String userId) { // ResponseEntity<Object Type = ?>
		try {
			MemberDto memberDto = memberService.getMember(userId); 
			if (memberDto!=null) {
				return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK); // 값, header
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // Void Object Type
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e); // 값, header
		}
	}
	
	@DeleteMapping("/user/{userid}") // parameter로 넘어오는 인자값은 requestparam으로 받고 URL로 넘어오는 값은 @Pathvariable 
	public ResponseEntity<?> userDelete(@PathVariable("userid") String userId) { // ResponseEntity<Object Type = ?>
		try {
			memberService.deleteMember(userId);
			List<MemberDto> list = memberService.listMember(null); // >>>>  JSON Array
			if (list!=null && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK); // 값, header
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // Void Object Type
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e); // 값, header
		}
	}
	
	@PutMapping("/user")
	public ResponseEntity<?> userModify(@RequestBody MemberDto memberDto) { // JSON Body로 넘어오므로 RequestBody
		try {
			memberService.modifyMember(memberDto); 
			List<MemberDto> list = memberService.listMember(null); // >>>>  JSON Array
			if (list!=null && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK); // 값, header
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // Void Object Type
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e); // 값, header
		}
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
