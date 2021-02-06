package com.ktpo.kutuhanem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktpo.kutuhanem.Service.MemberService;
import com.ktpo.kutuhanem.model.Member;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService service;

	@GetMapping("/list")
	public ResponseEntity<List<Member>> getAllEmployees() {
		List<Member> list = service.getAllMember();
		
		return new ResponseEntity<List<Member>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Member> getEmployeeById(@PathVariable("id") Long id) throws Exception {
		Member entity = service.getMemberId(id);

		return new ResponseEntity<Member>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/ins")
	public ResponseEntity<Member> createOrUpdateEmployee(@RequestBody Member user) throws Exception {
		System.out.println(user.toString());
		Member updated = service.createOrUpdateMember(user);
		return new ResponseEntity<Member>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/del/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws Exception {
		service.deleteMemberById(id);
		return HttpStatus.FORBIDDEN;
	}
}
