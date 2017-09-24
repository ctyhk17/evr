package kr.go.ntis.ev.hist.search.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.go.ntis.ev.cmn.service.CommonService;
import kr.go.ntis.ev.hist.search.service.PjtFnerSearchService;
import kr.go.ntis.ev.hist.search.service.PjtFnerSearchVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : PjtFnerSearchController.java
 * @Description : PjtFnerSearchController Controller Class
 *                과제최종평가결과 검색 컨트롤러
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2016.07.27           최초생성
 *
 * @author 태장혁
 * @since 2016.07.27
 * @version 1.0
 * @see
 *  
 */

@Controller
public class PjtFnerSearchController {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** 서비스 */
	@Resource(name = "pjtFnerSearchService")
	private PjtFnerSearchService pjtFnerSearchService;


	/** Validator */
	//@Resource(name = "beanValidator")
	//protected DefaultBeanValidator beanValidator;

		
	/**
	 * 과제최종평가결과 검색 목록을 조회한다.
	 * @param pjtFnerSearchVO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/hist/search/EVPjtFnerSearchL.do")
	public String selectPjtFnerSearchList(
			@ModelAttribute("pjtFnerSearchVO") PjtFnerSearchVO pjtFnerSearchVO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request
			) throws Exception {

		
		// 통합로그 저장
		commonService.createTiberoTotlLog( session, request, "홈:검색:목록", "EV:04:0001");
		
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, pjtFnerSearchVO.getPageIndex());

		pjtFnerSearchVO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		pjtFnerSearchVO.setLastIndex( paginationInfo.getLastRecordIndex() );
		
		
		
		
		String searchOrgNm = pjtFnerSearchVO.getSearchWord();
		String opCode = "lst_xml";
		
		List<?> horgList = commonService.getHeteromorphismDeptNm(searchOrgNm, opCode);
		
		// 이형기관명 검색 추가
		pjtFnerSearchVO.setSearchHorgNm(horgList.toArray(new String[horgList.size()]));
		
		
		
		
		// 과제최종평가결과 검색 목록 조회
		List<?> pjtFnerResultList = pjtFnerSearchService.selectPjtFnerSearchList(pjtFnerSearchVO);
		model.addAttribute("pjtFnerResultList", pjtFnerResultList);

		// 과제최종평가결과 검색 목록 조회
		int totCnt = pjtFnerSearchService.selectPjtFnerSearchListTotCnt(pjtFnerSearchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		
		
		
		
		/** pageing setting */
		PaginationInfo paginationInfo1 = new PaginationInfo();
		commonService.getPageInfo( paginationInfo1, pjtFnerSearchVO.getPageIndex1());

		pjtFnerSearchVO.setFirstIndex( paginationInfo1.getFirstRecordIndex() );
		pjtFnerSearchVO.setLastIndex( paginationInfo1.getLastRecordIndex() );
		
		
		// 평가참여이력 검색 목록 조회
		List<?> asesorAssmtPrtcpResultList = pjtFnerSearchService.selectAsesorAssmtPrtcpSearchList(pjtFnerSearchVO);
		model.addAttribute("asesorAssmtPrtcpResultList", asesorAssmtPrtcpResultList);

		// 과제최종평가결과 검색 목록 조회
		int totCnt1 = pjtFnerSearchService.selectAsesorAssmtPrtcpSearchListTotCnt(pjtFnerSearchVO);
		paginationInfo1.setTotalRecordCount(totCnt1);
		model.addAttribute("paginationInfo1", paginationInfo1);
		
		

		return "hist/search/EVPjtFnerSearchL";
	}

	
	
	

}
