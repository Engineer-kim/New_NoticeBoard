package com.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.SignUpDao;
import com.board.domain.Member;

@Service
public class SignUpServiceImpl implements SignUpService {

		@Autowired
		SignUpDao dao;
		
		@Override
		public int idCheck(String userId) {
			
			int result = dao.idCheck(userId);
			return result;
		}

		@Override
		public void signUp(Member vo) {
			dao.signUp(vo);
		}

		
		}

	

