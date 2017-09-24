package kr.go.ntis.ev.mgnt.adsub.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.go.ntis.ev.mgnt.adsub.service.PjtFnerAdsubMgntVO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PjtFnerAdsubMgntDAO.java
 * @Description : PjtFnerAdsubMgnt DAO Class
 *                과제평가 가감점관리 DAO 클래스
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

@Repository("pjtFnerAdsubMgntDAO")
public class PjtFnerAdsubMgntDAO extends EgovAbstractDAO {

	
	/**
	 * 과제평가 가감점 목록을 조회한다.
	 * @param pjtFnerAdsubMgntVO - 조회할 정보가 담긴 VO
	 * @return 목록
	 * @exception Exception
	 */
	public List<?> selectPjtFnerAdsubMgntList(PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO) throws Exception{
		return list("kr.go.ntis.ev.mgnt.adsub.PjtFnerAdsubMgnt.selectPjtFnerAdsubMgntList", pjtFnerAdsubMgntVO);
	}

	/**
	 * 과제평가 가감점 목록 갯수를 조회한다. 
	 * @param pjtFnerAdsubMgntVO - 조회할 정보가 담긴 VO
	 * @return 목록 총 갯수
	 * @exception
	 */
	public int selectPjtFnerAdsubMgntListTotCnt(PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO){
		return (Integer)select("kr.go.ntis.ev.mgnt.adsub.PjtFnerAdsubMgnt.selectPjtFnerAdsubMgntListTotCnt", pjtFnerAdsubMgntVO);
	}
	

	/**
	 * 과제평가 가감점 상세내용을 조회한다.
	 * @param pjtFnerAdsubMgntVO - 조회할 정보가 담긴 pjtFnerAdsubMgntVO
	 * @return  상세정보
	 * @exception Exception
	 */
	public Map<?, ?> selectPjtFnerAdsubMgntInfo(PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO) throws Exception{
		return (Map<?, ?>)select("kr.go.ntis.ev.mgnt.adsub.PjtFnerAdsubMgnt.selectPjtFnerAdsubMgntInfo", pjtFnerAdsubMgntVO);
	}

	
	/**
	 * 과제평가 가감점 정보을 등록한다.
	 * @param pjtFnerAdsubMgntVO
	 * @return
	 * @throws Exception
	 */
	public String insertPjtFnerAdsubMgntInfoProc(PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO) throws Exception{
		return (String)insert("kr.go.ntis.ev.mgnt.adsub.PjtFnerAdsubMgnt.insertPjtFnerAdsubMgntInfoProc", pjtFnerAdsubMgntVO);
	}
	
	/**
	 * 과제평가 가감점 정보를 수정한다.
	 * @param pjtFnerAdsubMgntVO
	 * @return
	 * @throws Exception
	 */
	public void updatePjtFnerAdsubMgntInfoProc(PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO) throws Exception{
		update("kr.go.ntis.ev.mgnt.adsub.PjtFnerAdsubMgnt.updatePjtFnerAdsubMgntInfoProc", pjtFnerAdsubMgntVO);
	}
	
	/**
	 * 과제평가 가감점 정보를 삭제한다.
	 * @param pjtFnerAdsubMgntVO
	 * @return
	 * @throws Exception
	 */
	public int deletePjtFnerAdsubMgntInfoProc(PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO) throws Exception{
		return delete("kr.go.ntis.ev.mgnt.adsub.PjtFnerAdsubMgnt.deletePjtFnerAdsubMgntInfoProc", pjtFnerAdsubMgntVO);
	}
	
	
	
	
	/**
	 * 가감점 대상 조회
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List selectPjtFnerAdsubTrgtProc(Map paramMap) throws Exception{
		return list("kr.go.ntis.ev.mgnt.adsub.PjtFnerAdsubMgnt.selectPjtFnerAdsubTrgtProc", paramMap);
	}
	
	
	/**
	 * 가감점 대상 등록
	 * @param adsubMgntNo
	 * @param getAdsubTrgtCdArr
	 * @return
	 */
	public void insertPjtFnerAdsubTrgtProc(String adsubMgntNo, String[] getAdsubTrgtCdArr)  throws Exception{
		Map paramMap = null;
		
		for(int i=0; i<getAdsubTrgtCdArr.length; i++){
			paramMap = new HashMap();
			paramMap.put("adsubMgntNo", adsubMgntNo);
			paramMap.put("adsubTrgtCd", getAdsubTrgtCdArr[i]);
			
			insert("kr.go.ntis.ev.mgnt.adsub.PjtFnerAdsubMgnt.insertPjtFnerAdsubTrgtProc", paramMap);
		}
		
	}
	
	public void deletePjtFnerAdsubTrgtProc(String value) throws Exception{
		delete("kr.go.ntis.ev.mgnt.adsub.PjtFnerAdsubMgnt.deletePjtFnerAdsubTrgtProc", value);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
