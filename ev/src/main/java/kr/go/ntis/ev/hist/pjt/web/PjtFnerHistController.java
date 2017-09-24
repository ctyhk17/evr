package kr.go.ntis.ev.hist.pjt.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.go.ntis.ev.cmn.service.CommonService;
import kr.go.ntis.ev.cmn.service.LoginVO;
import kr.go.ntis.ev.hist.pjt.service.PjtFnerHistService;
import kr.go.ntis.ev.hist.pjt.service.PjtFnerHistVO;
import kr.go.ntis.ev.mgnt.adsub.service.PjtFnerAdsubMgntVO;
import kr.go.ntis.ev.mgnt.log.service.PjtAssmtHistInfoLogService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : PjtFnerHistController.java
 * @Description : PjtFnerHistController Controller Class
 *                과제최종평가이력 컨트롤러
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
public class PjtFnerHistController {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** 서비스 */
	@Resource(name = "pjtFnerHistService")
	private PjtFnerHistService pjtFnerHistService;
	
	@Resource(name = "pjtAssmtHistInfoLogService")
	private PjtAssmtHistInfoLogService pjtAssmtHistInfoLogService;


	/** Validator */
	//@Resource(name = "beanValidator")
	//protected DefaultBeanValidator beanValidator;

		
	/**
	 * 과제최종평가이력 목록을 검색한다.
	 * @param pjtFnerHistVO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/hist/pjt/EVPjtFnerHistL.do")
	public String selectPjtFnerHistList(
			@ModelAttribute("pjtFnerHistVO") PjtFnerHistVO pjtFnerHistVO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request
			) throws Exception {
		
		// 통합로그 저장
		commonService.createTiberoTotlLog( session, request, "홈:최종평가결과검색:목록", "EV:01:0001");
		

		
		// 검색조건 코드 조회
		// 기준년도
		List stanYrFromList = commonService.getStanYrList();
		model.addAttribute("stanYrFromList", stanYrFromList);
		
		// 기준년도
		List stanYrToList = commonService.getStanYrList();
		model.addAttribute("stanYrToList", stanYrToList);
		
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		//commonService.getPageInfo( paginationInfo, pjtFnerHistVO.getPageIndex());
		commonService.getPageInfo( paginationInfo, pjtFnerHistVO.getPageIndex(), pjtFnerHistVO.getRecordCountPerPage());

		
		pjtFnerHistVO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		pjtFnerHistVO.setLastIndex( paginationInfo.getLastRecordIndex() );
			
		if("Y".equals(pjtFnerHistVO.getSearchFlag()))
		{	
			
			String searchOrgNm = pjtFnerHistVO.getSearchPjtPrfrmOrgNm();
			String opCode = "lst_xml";
			
			List<?> horgList = commonService.getHeteromorphismDeptNm(searchOrgNm, opCode);
			
			// 이형기관명 검색 추가
			pjtFnerHistVO.setSearchPjtPrfrmHOrgNm(horgList.toArray(new String[horgList.size()]));
			
			// 과제최종평가결과 목록 조회
			List<?> resultList = pjtFnerHistService.selectPjtFnerHistList(pjtFnerHistVO);
			model.addAttribute("resultList", resultList);
			
			// 과제최종평가결과 목록 건수 조회
			int totCnt = pjtFnerHistService.selectPjtFnerHistListTotCnt(pjtFnerHistVO);
			paginationInfo.setTotalRecordCount(totCnt);
			model.addAttribute("paginationInfo", paginationInfo);
		
		}else{	// dummy
			// 과제최종평가결과 목록 조회
			List<?> resultList = null;
			model.addAttribute("resultList", resultList);

			// 과제최종평가결과 목록 건수 조회
			int totCnt = 0;
			paginationInfo.setTotalRecordCount(totCnt);
			model.addAttribute("paginationInfo", paginationInfo);
		}
		
		

		return "hist/pjt/EVPjtFnerHistL";
	}

	
	
	
	/**
	 * 과제최종평가이력 상세내용을 조회한다.
	 * @param pjtFnerHistVO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/hist/pjt/EVPjtFnerHistR.do")
	public String selectPjtFnerHistInfo(
			@ModelAttribute("pjtFnerHistVO") PjtFnerHistVO pjtFnerHistVO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request
			) throws Exception {

		
		// 통합로그 저장
		commonService.createTiberoTotlLog( session, request, "홈:최종평가결과검색:상세", "EV:01:0002", pjtFnerHistVO.getPjtId());
		
		// 유저아이디, 접속아이피
		// 접속 이력 기능 사용 안함
		LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");
		
		String userId = loginVO.getUserId();
		String connIp = request.getRemoteAddr();
		String connSlct = "1"; // 1:과제, 2:평가위원
		String userDfn1 = pjtFnerHistVO.getPjtId();
		pjtAssmtHistInfoLogService.insertPjtAssmtHistInfoLogInfoProc(userId, loginVO.getPsnNm(), connIp, connSlct, userDfn1);
		
		
		// 과제최종평가결과 상세내용
		Map<?,?> resultInfo = pjtFnerHistService.selectPjtFnerHistInfo(pjtFnerHistVO);
		model.addAttribute("resultInfo", resultInfo);
		
		
		// 기관별평가등급 목록 조회
		List<?> orgAssmtGrdList = pjtFnerHistService.selectOrgAssmtGrdList(pjtFnerHistVO);
		model.addAttribute("orgAssmtGrdList", orgAssmtGrdList);
		
		// 기관코드 
		String srcOrgId = (String)resultInfo.get("srcOrgId");
		if(srcOrgId == null)
			srcOrgId = ""; 

		//기관별 중단 유형별 사유 (트리 구조)
		List<?> stopTypeRsonCdList = pjtFnerHistService.selectStopTypeRsonCdList(srcOrgId);
		model.addAttribute("stopTypeRsonCdList", stopTypeRsonCdList);

		
		
		// 기관별 중단유형 목록 조회
		//List<?> stopTypeCdList = pjtFnerHistService.selectStopTypeCdList(srcOrgId);
		//model.addAttribute("stopTypeCdList", stopTypeCdList);
		
		// 기관별 중단사유 목록 조회
		//List<?> stopRsonCdList = pjtFnerHistService.selectStopRsonCdList(srcOrgId);
		//model.addAttribute("stopRsonCdList", stopRsonCdList);

		
		// 가감점코드 목록 조회
		// 2016-11-08 가감점 코드 목록 화면에서 제거
		//List<?> adsubCdList = pjtFnerHistService.selectAdsubCdList(pjtFnerHistVO);
		//model.addAttribute("adsubCdList", adsubCdList);
		
		
		// 과제최종평가결과 평가위원 목록 조회
		List<?> resultList = pjtFnerHistService.selectAsesorList(pjtFnerHistVO);
		model.addAttribute("resultList", resultList);
		
		return "hist/pjt/EVPjtFnerHistR";
	}
	
	/**
	 * 부처목록 조회
	 * @param searchDeptDivCd
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/hist/pjt/EVDeptCdL.do")
	public ModelAndView selectDeptCdList(
			@RequestParam("searchDeptDivCd") String searchDeptDivCd,
			ModelMap model,
			HttpSession session
			) throws Exception {

		
		
		ModelAndView modelAndView = new ModelAndView();
		
    	
		List<?> deptCdList = null;
		
    	if("NEW".equals(searchDeptDivCd))
    	{
    		// 신부처 코드 조회
    		//deptCdList = commonService.getCmnCdList("GT040");
    		deptCdList = commonService.getNewDeptCdList();
    	}else if("OLD".equals(searchDeptDivCd)){
    		// 구부처 코드 조회
    		deptCdList = commonService.getOldDeptCdList();
    	}else{
    		
    	}
		
    	
    	Map resultMap = new HashMap();   
    	
    	resultMap.put("deptCdList", deptCdList);
    	
    	modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	
	
	
	/**
	 * 최종평가결과 검색 엑셀 다운로드
	 * @param pjtFnerHistVO
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 * @throws Exception
	 * 2016.11.08 엑셀 다운로드 추가
	 */
	@RequestMapping(value="/hist/pjt/EVPjtFnerHistE.do")
	public ModelAndView downloadExcelFile(
			@ModelAttribute("pjtFnerHistVO") PjtFnerHistVO pjtFnerHistVO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request
			) throws Exception{
		
    	// 세션    	 
    	String[] headerList = {
    			  "순번"
    			, "기준년도"
    			, "부처명"
    			, "수행기관명"
    			, "과제명"
    			, "연구책임자명"
    			, "평가결과_점수"
    			, "평가결과_등급"
    			, "과제중단여부"   
    			, "가·감점 후보추천"
    			};
    	String[] columnList = {
    			  "rn"
    			, "stanYr"
    			, "progMstrNm"
    			, "pjtPrfrmOrgNm"
    			, "korPjtNm"
    			, "mngrHmNm"
    			, "pjtFinalAssmtPts"
    			, "pjtFinalAssmtGrdDes"
    			, "pjtStopYn"   
    			, "abevRecommend"
    			};
    	
    	
    	List<?> bodyList = pjtFnerHistService.selectPjtFnerHistListForExcel(pjtFnerHistVO);
    	
    	
		
		Map map = new HashMap();
		
		map.put("excelFileName", "최종평가결과");
		map.put("excelSheetName", "최종평가결과");
		map.put("excelTitle", "최종평가결과");
		
		map.put("headerList", headerList);
		map.put("columnList", columnList);
		map.put("bodyList", bodyList);
		
		return new ModelAndView("ntisExcelView", map);
	}	

	

}
