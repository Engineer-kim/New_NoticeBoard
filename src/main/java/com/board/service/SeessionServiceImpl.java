package com.board.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.board.dao.SeessionDao;
import com.board.domain.Member;

@Service
public class SeessionServiceImpl implements SeessionService {

	@Inject
	SeessionDao dao;
	
	@Override
	public int passCheck(Member vo) {
		int result = dao.passCheck(vo);
		return result;
	}

	
	@Override
	public void seession(Member vo,HttpSession session) {
		dao.seession(vo,session);
	}
	
}
