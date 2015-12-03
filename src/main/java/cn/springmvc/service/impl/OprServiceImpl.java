package cn.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.OprDAO;
import cn.springmvc.model.TblOprInfo;
import cn.springmvc.service.OprService;
@Service(value="OprSrviceImpl")
public class OprServiceImpl implements OprService {
	@Autowired
	OprDAO OPRdao;
	public TblOprInfo selectAll() {
		// TODO Auto-generated method stub
		return OPRdao.selectAll();
	}

}
