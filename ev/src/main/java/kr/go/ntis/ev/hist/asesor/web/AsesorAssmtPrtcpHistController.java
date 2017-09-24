package kr.go.ntis.ev.hist.asesor.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.go.ntis.ev.cmn.service.CommonService;
import kr.go.ntis.ev.cmn.service.LoginVO;
import kr.go.ntis.ev.hist.asesor.service.AsesorAssmtPrtcpHistService;
import kr.go.ntis.ev.hist.asesor.service.AsesorAssmtPrtcpHistVO;
import kr.go.ntis.ev.hist.pjt.service.PjtFnerHistVO;
import kr.go.ntis.ev.mgnt.log.service.PjtAssmtHistInfoLogService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : AsesorAssmtPrtcpHistController.java
 * @Description : AsesorAssmtPrtcpHist Controller Class
 *                평가위원 평가참여이력 컨트롤러
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

@Controller
public class AsesorAssmtPrtcpHistController {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** 서비스 */
	@Resource(name = "asesorAssmtPrtcpHistService")
	private AsesorAssmtPrtcpHistService asesorAssmtPrtcpHistService;
	
	@Resource(name = "pjtAssmtHistInfoLogService")
	private PjtAssmtHistInfoLogService pjtAssmtHistInfoLogService;

	
	/**
	 * 평가위원 평가참여이력 목록을 검색한다.
	 * @param asesorAssmtPrtcpHistVO - 검색할 정보가 담긴 asesorAssmtPrtcpHistVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/hist/asesor/EVAsesorAssmtPrtcpHistL.do")
	public String selectAsesorAssmtPrtcpHistList(
			@ModelAttribute("asesorAssmtPrtcpHistVO") AsesorAssmtPrtcpHistVO asesorAssmtPrtcpHistVO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request
			) throws Exception {

		
		// 통합로그 저장
		commonService.createTiberoTotlLog( session, request, "홈:평가참여이력검색:목록", "EV:02:0001");
		
		
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		//commonService.getPageInfo( paginationInfo, asesorAssmtPrtcpHistVO.getPageIndex());
		commonService.getPageInfo( paginationInfo, asesorAssmtPrtcpHistVO.getPageIndex(), asesorAssmtPrtcpHistVO.getRecordCountPerPage());

		asesorAssmtPrtcpHistVO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		asesorAssmtPrtcpHistVO.setLastIndex( paginationInfo.getLastRecordIndex() );
		
		
		if("Y".equals(asesorAssmtPrtcpHistVO.getSearchFlag()))
		{
			
			String searchOrgNm = asesorAssmtPrtcpHistVO.getSearchBlngOrgNm();
			String opCode = "lst_xml";
			
			List<?> horgList = commonService.getHeteromorphismDeptNm(searchOrgNm, opCode);
			
			// 이형기관명 검색 추가
			asesorAssmtPrtcpHistVO.setSearchBlngHOrgNm(horgList.toArray(new String[horgList.size()]));
			
			
			// 평가참여이력 검색
			List<?> resultList = asesorAssmtPrtcpHistService.selectAsesorAssmtPrtcpHistList(asesorAssmtPrtcpHistVO);
			model.addAttribute("resultList", resultList);
	
			// 평가참여이력 검색
			int totCnt = asesorAssmtPrtcpHistService.selectAsesorAssmtPrtcpHistListTotCnt(asesorAssmtPrtcpHistVO);
			paginationInfo.setTotalRecordCount(totCnt);
			model.addAttribute("paginationInfo", paginationInfo);
			
		} else {
			
			// 평가참여이력 검색
			List<?> resultList = null;
			model.addAttribute("resultList", resultList);
	
			// 평가참여이력 검색
			int totCnt = 0;
			paginationInfo.setTotalRecordCount(totCnt);
			model.addAttribute("paginationInfo", paginationInfo);
		}
		

		return "hist/asesor/EVAsesorAssmtPrtcpHistL";
	}

	
	
	
	/**
	 * 평가위원 평가참여이력 상세내용을 조회한다.
	 * @param asesorAssmtPrtcpHistVO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/hist/asesor/EVAsesorAssmtPrtcpHistR.do")
	public String selectAsesorAssmtPrtcpHistInfo(
			@ModelAttribute("asesorAssmtPrtcpHistVO") AsesorAssmtPrtcpHistVO asesorAssmtPrtcpHistVO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request
			) throws Exception {

		
		// 통합로그 저장
		commonService.createTiberoTotlLog( session, request, "홈:평가참여이력검색:상세", "EV:02:0002", asesorAssmtPrtcpHistVO.getRrno());
		
		// 유저아이디, 접속아이피
		LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");
		
		String userId = loginVO.getUserId();
		String connIp = request.getRemoteAddr();
		String connSlct = "2"; // 1:과제, 2:평가위원
		String userDfn1 = asesorAssmtPrtcpHistVO.getRrno();
		pjtAssmtHistInfoLogService.insertPjtAssmtHistInfoLogInfoProc(userId, loginVO.getPsnNm(), connIp, connSlct, userDfn1);
				
		
		Map<?,?> resultInfo = asesorAssmtPrtcpHistService.selectAsesorAssmtPrtcpHistInfo(asesorAssmtPrtcpHistVO);
		model.addAttribute("resultInfo", resultInfo);
		
		// 평가위원의 단계별 평가참여이력
		List<?> resultList = asesorAssmtPrtcpHistService.selectStepByAsesorAssmtPrtcpHistList(asesorAssmtPrtcpHistVO);
		model.addAttribute("resultList", resultList);
		
		
		return "hist/asesor/EVAsesorAssmtPrtcpHistR";
	}
	
	
	
}