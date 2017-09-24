package kr.go.ntis.ev.mgnt.adsub.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.go.ntis.ev.mgnt.adsub.service.PjtFnerAdsubMgntService;
import kr.go.ntis.ev.mgnt.adsub.service.PjtFnerAdsubMgntVO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : PjtFnerAdsubMgntServiceImpl.java
 * @Description : PjtFnerAdsubMgnt Service Implements Class
 *                과제평가 가감점관리 인터페이스 구현 클래스
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2016.07.12           최초생성
 *
 * @author 태장혁
 * @since 2016.07.12
 * @version 1.0
 * @see
 *  
 */

@Service("pjtFnerAdsubMgntService")
public class PjtFnerAdsubMgntServiceImpl extends EgovAbstractServiceImpl implements PjtFnerAdsubMgntService {

	/** DAO 선언 */
	@Resource(name = "pjtFnerAdsubMgntDAO")
	private PjtFnerAdsubMgntDAO pjtFnerAdsubMgntDAO;

	
	
	/**
	 * 과제평가 가감점 목록을 조회한다.
	 * @param pjtFnerAdsubMgntVO - 조회할 정보가 담긴 VO
	 * @return 목록
	 * @exception Exception
	 */
	public List<?> selectPjtFnerAdsubMgntList(PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO) throws Exception{
		return pjtFnerAdsubMgntDAO.selectPjtFnerAdsubMgntList(pjtFnerAdsubMgntVO);
	}

	/**
	 * 과제평가 가감점 목록 갯수를 조회한다. 
	 * @param pjtFnerAdsubMgntVO - 조회할 정보가 담긴 VO
	 * @return 목록 총 갯수
	 * @exception
	 */
	public int selectPjtFnerAdsubMgntListTotCnt(PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO){
		return pjtFnerAdsubMgntDAO.selectPjtFnerAdsubMgntListTotCnt(pjtFnerAdsubMgntVO);
	}
	

	/**
	 * 과제평가 가감점 상세내용을 조회한다.
	 * @param pjtFnerAdsubMgntVO - 조회할 정보가 담긴 pjtFnerAdsubMgntVO
	 * @return  상세정보
	 * @exception Exception
	 */
	public Map<?, ?> selectPjtFnerAdsubMgntInfo(PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO) throws Exception{
		return pjtFnerAdsubMgntDAO.selectPjtFnerAdsubMgntInfo(pjtFnerAdsubMgntVO);
	}

	
	/**
	 * 과제평가 가감점 정보을 등록한다.
	 * @param pjtFnerAdsubMgntVO
	 * @return
	 * @throws Exception
	 */
	public String insertPjtFnerAdsubMgntInfoProc(PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO) throws Exception{
		return pjtFnerAdsubMgntDAO.insertPjtFnerAdsubMgntInfoProc(pjtFnerAdsubMgntVO);
	}
	
	/**
	 * 과제평가 가감점 정보를 수정한다.
	 * @param pjtFnerAdsubMgntVO
	 * @return
	 * @throws Exception
	 */
	public void updatePjtFnerAdsubMgntInfoProc(PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO) throws Exception{
		pjtFnerAdsubMgntDAO.updatePjtFnerAdsubMgntInfoProc(pjtFnerAdsubMgntVO);
	}
	
	/**
	 * 과제평가 가감점 정보를 삭제한다.
	 * @param pjtFnerAdsubMgntVO
	 * @return
	 * @throws Exception
	 */
	public int deletePjtFnerAdsubMgntInfoProc(PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO) throws Exception{
		return pjtFnerAdsubMgntDAO.deletePjtFnerAdsubMgntInfoProc(pjtFnerAdsubMgntVO);
	}
	
	
	/**
	 * 가감점 대상 조회
	 */
	public List selectPjtFnerAdsubTrgtProc(Map paramMap) throws Exception{
		return pjtFnerAdsubMgntDAO.selectPjtFnerAdsubTrgtProc(paramMap);
	}
	
	/**
	 * 가감점 대상 등록
	 * @param adsubMgntNo
	 * @param getAdsubTrgtCdArr
	 * @return
	 */
	public void insertPjtFnerAdsubTrgtProc(String adsubMgntNo, String[] getAdsubTrgtCdArr)  throws Exception{
		pjtFnerAdsubMgntDAO.insertPjtFnerAdsubTrgtProc(adsubMgntNo, getAdsubTrgtCdArr);
	}
	
	/**
	 * 가감점 대상 삭제
	 */
	public void deletePjtFnerAdsubTrgtProc(String value) throws Exception{
		pjtFnerAdsubMgntDAO.deletePjtFnerAdsubTrgtProc(value);
	}
	

}
