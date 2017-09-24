package kr.go.ntis.ev.mgnt.log.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.go.ntis.ev.cmn.service.CommonService;
import kr.go.ntis.ev.mgnt.log.service.PjtAssmtHistInfoLogService;
import kr.go.ntis.ev.mgnt.log.service.PjtAssmtHistInfoLogVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : PjtAssmtHistInfoLogController.java
 * @Description : PjtAssmtHistInfoLogController Class
 *                과제평가이력정보 로그 컨트롤러
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2016.11.02           최초생성
 *
 * @author 태장혁
 * @since 2016.07.12
 * @version 1.0
 * @see
 *  
 */

@Controller
public class PjtAssmtHistInfoLogController {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** 서비스 */
	@Resource(name = "pjtAssmtHistInfoLogService")
	private PjtAssmtHistInfoLogService pjtAssmtHistInfoLogService;


	
	/**
	 * 과제평가이력정보 로그 목록을 검색한다.
	 * @param pjtAssmtHistInfoLogVO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mgnt/log/EVPjtAssmtHistInfoLogL.do")
	public String selectPjtAssmtHistInfoLogList(
			@ModelAttribute("pjtAssmtHistInfoLogVO") PjtAssmtHistInfoLogVO pjtAssmtHistInfoLogVO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		commonService.isAdminRuleCd(session, response);
		
		// 통합로그 저장
		commonService.createTiberoTotlLog( session, request, "홈:접속이력관리:목록", "EV:05:0001");
		
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
//		commonService.getPageInfo( paginationInfo, pjtAssmtHistInfoLogVO.getPageIndex());
		commonService.getPageInfo( paginationInfo, pjtAssmtHistInfoLogVO.getPageIndex(), pjtAssmtHistInfoLogVO.getRecordCountPerPage());
		
		pjtAssmtHistInfoLogVO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		pjtAssmtHistInfoLogVO.setLastIndex( paginationInfo.getLastRecordIndex() );
		
		// 과제평가이력정보 로그 목록
		List<?> resultList = pjtAssmtHistInfoLogService.selectPjtAssmtHistInfoLogList(pjtAssmtHistInfoLogVO);
		model.addAttribute("resultList", resultList);

		int totCnt = pjtAssmtHistInfoLogService.selectPjtAssmtHistInfoLogListTotCnt(pjtAssmtHistInfoLogVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		                   
		return "mgnt/log/EVPjtAssmtHistInfoLogL";
	}

	
	
	
	/**
	 * 과제평가이력정보 로그 상세내용을 조회한다.
	 * @param pjtAssmtHistInfoLogVO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mgnt/log/EVPjtAssmtHistInfoLogR.do")
	public String selectPjtAssmtHistInfoLogInfo(
			@ModelAttribute("pjtAssmtHistInfoLogVO") PjtAssmtHistInfoLogVO pjtAssmtHistInfoLogVO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request
			) throws Exception {

		
		// 통합로그 저장
		commonService.createTiberoTotlLog( session, request, "홈:접속이력관리:상세", "EV:05:0002");
		
		Map<?,?> resultInfo = pjtAssmtHistInfoLogService.selectPjtAssmtHistInfoLogInfo(pjtAssmtHistInfoLogVO);
		model.addAttribute("resultInfo", resultInfo);
		
		return "mgnt/log/EVPjtAssmtHistInfoLogR";
	}
	
	
}
