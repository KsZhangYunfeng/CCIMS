package com.eshore.nrms.sysmgr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshore.khala.common.model.PageConfig;
import com.eshore.khala.core.data.api.dao.IBaseDao;
import com.eshore.khala.core.service.impl.BaseServiceImpl;
import com.eshore.nrms.sysmgr.dao.IScoreDao;
import com.eshore.nrms.sysmgr.dao.IStuBasicInfoDao;
import com.eshore.nrms.sysmgr.dao.IStuClassDao;
import com.eshore.nrms.sysmgr.pojo.Score;
import com.eshore.nrms.sysmgr.pojo.StuBasicInfo;
import com.eshore.nrms.sysmgr.pojo.StuClass;
import com.eshore.nrms.sysmgr.pojo.UserInfo;
import com.eshore.nrms.sysmgr.service.IScoreService;
import com.eshore.nrms.sysmgr.service.IStuBasicInfoService;
import com.eshore.nrms.sysmgr.service.IStuClassService;
import com.eshore.nrms.util.PageUtil;
import com.eshore.nrms.vo.PageVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ScoreServiceImpl extends BaseServiceImpl<Score> implements IScoreService {

	@Autowired
	private IScoreDao scoreDao;

	
	@Override
	public Score queryScoreByScoreId(Integer scoreId) {
		Score score = this.scoreDao.queryScoreByScoreId(scoreId);
		return score;
	}

	@Override
	public PageVo<Score> queryScoreListByPage(Score score, PageConfig page) {
		List<Score> list = this.scoreDao.queryScoreList(score, page);
		return PageUtil.getPageList(page, list);
	}



	@Override
	public Integer getScoreCountByStuId(String sno) {
		return this.scoreDao.getScoreCountByStuId(sno) ;
	}

	@Override
	public IBaseDao<Score> getDao() {
		return scoreDao;
	}

	
	

}
