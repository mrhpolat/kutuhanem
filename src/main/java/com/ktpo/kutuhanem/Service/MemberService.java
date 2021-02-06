package com.ktpo.kutuhanem.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktpo.kutuhanem.model.Member;
import com.ktpo.kutuhanem.repo.MemberRepository;

@Service
public class MemberService {

	@Autowired
	MemberRepository repository;

	public List<Member> getAllMember() {
		List<Member> memberList = repository.findAll();
		if (memberList.size() > 0)
			return memberList;
		else
			return new ArrayList<Member>();

	}

	public Member getMemberId(Long id) throws Exception {
		Optional<Member> member = repository.findById(id);

		if (member.isPresent())
			return member.get();
		else
			throw new Exception("No employee record exist for given id");
	}

	public Member createOrUpdateMember(Member entity) throws Exception {
		return repository.save(entity);
	}

	public void deleteMemberById(Long id) throws Exception {
		Optional<Member> member = repository.findById(id);

		if (member.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new Exception("No employee record exist for given id");
		}
	}
}
