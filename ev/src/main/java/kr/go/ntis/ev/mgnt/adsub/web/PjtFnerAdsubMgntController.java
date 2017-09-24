package kr.go.ntis.ev.mgnt.adsub.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.go.ntis.ev.cmn.service.CommonService;
import kr.go.ntis.ev.mgnt.adsub.service.PjtFnerAdsubMgntService;
import kr.go.ntis.ev.mgnt.adsub.service.PjtFnerAdsubMgntVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : PjtFnerAdsubMgntController.java
 * @Description : PjtFnerAdsubMgnt Controller Class
 *                과제평가 가감점관리 컨트롤러
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
public class PjtFnerAdsubMgntController {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** 서비스 */
	@Resource(name = "pjtFnerAdsubMgntService")
	private PjtFnerAdsubMgntService pjtFnerAdsubMgntService;


	
	/**
	 * 과제평가 가감점관리 목록을 검색한다.
	 * @param pjtFnerAdsubMgntVO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mgnt/adsub/EVPjtFnerAdsubMgntL.do")
	public String selectPjtFnerAdsubMgntList(
			@ModelAttribute("pjtFnerAdsubMgntVO") PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		
		commonService.isAdminRuleCd(session, response);
		
		// 통합로그 저장
		commonService.createTiberoTotlLog( session, request, "홈:가감점관리:목록", "EV:03:0001");
		
		

		// 가감점 구분코드
		List<?> adsubSlctCdList = commonService.getPjtFnerCdList("ER001");
		model.addAttribute("adsubSlctCdList", adsubSlctCdList);
		
		// 대상 구분코드
		List<?> adsubTrgtCdList = commonService.getPjtFnerCdList("ER004");
		model.addAttribute("adsubTrgtCdList", adsubTrgtCdList);
		
		
		// 체크박스 기본 체크
		if(pjtFnerAdsubMgntVO.getSearchAdsubTrgtCd() == null){
			String[] tempArr = new String[adsubTrgtCdList.size()];
			Map tempMap = null;
			
			for(int i=0; i<tempArr.length; i++){
				tempMap = (Map)adsubTrgtCdList.get(i);
				tempArr[i] = (String)tempMap.get("cd"); 
			}
			
			pjtFnerAdsubMgntVO.setSearchAdsubTrgtCd(tempArr);
		}
		
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		//commonService.getPageInfo( paginationInfo, pjtFnerAdsubMgntVO.getPageIndex());
		commonService.getPageInfo( paginationInfo, pjtFnerAdsubMgntVO.getPageIndex(), pjtFnerAdsubMgntVO.getRecordCountPerPage());
		
		pjtFnerAdsubMgntVO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		pjtFnerAdsubMgntVO.setLastIndex( paginationInfo.getLastRecordIndex() );
		
		// 과제평가 가감점 목록
		List<?> resultList = pjtFnerAdsubMgntService.selectPjtFnerAdsubMgntList(pjtFnerAdsubMgntVO);
		model.addAttribute("resultList", resultList);

		int totCnt = pjtFnerAdsubMgntService.selectPjtFnerAdsubMgntListTotCnt(pjtFnerAdsubMgntVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		                   
		return "mgnt/adsub/EVPjtFnerAdsubMgntL";
	}

	
	
	
	/**
	 * 과제평가 가감점 상세내용을 조회한다.
	 * @param pjtFnerAdsubMgntVO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mgnt/adsub/EVPjtFnerAdsubMgntR.do")
	public String selectPjtFnerAdsubMgntInfo(
			@ModelAttribute("pjtFnerAdsubMgntVO") PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		commonService.isAdminRuleCd(session, response);
		
		// 통합로그 저장
		commonService.createTiberoTotlLog( session, request, "홈:가감점관리:상세", "EV:03:0002");
		
		Map<?,?> resultInfo = pjtFnerAdsubMgntService.selectPjtFnerAdsubMgntInfo(pjtFnerAdsubMgntVO);
		model.addAttribute("resultInfo", resultInfo);
		
		return "mgnt/adsub/EVPjtFnerAdsubMgntR";
	}
	
	
	/**
	 * 과제평가 가감점 등록 화면으로 이동한다.
	 * @param pjtFnerAdsubMgntVO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mgnt/adsub/EVPjtFnerAdsubMgntI.do")
	public String insertPjtFnerAdsubMgntInfo(
			@ModelAttribute("pjtFnerAdsubMgntVO") PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		commonService.isAdminRuleCd(session, response);
		
		// 통합로그 저장
		commonService.createTiberoTotlLog( session, request, "홈:가감점관리:등록", "EV:03:0003");
				
		// 가감점 구분코드
		List<?> adsubSlctCdList = commonService.getPjtFnerCdList("ER001");
		model.addAttribute("adsubSlctCdList", adsubSlctCdList);
		
		// 적용기관코드
		List<?> adsubApplOrgSlctCdList = commonService.getPjtFnerCdList("ER002");
		model.addAttribute("adsubApplOrgSlctCdList", adsubApplOrgSlctCdList);
		
		// 적용기준일자구분코드
		List<?> adsubApplStanDtSlctCdList = commonService.getPjtFnerCdList("ER003");
		model.addAttribute("adsubApplStanDtSlctCdList", adsubApplStanDtSlctCdList);
		
		// 대상 구분코드
		List<?> adsubTrgtCdList = commonService.getPjtFnerCdList("ER004");
		model.addAttribute("adsubTrgtCdList", adsubTrgtCdList);
		
		model.addAttribute("adsubTrgtCdListCnt", adsubTrgtCdList.size());
		
		
		
		
		return "mgnt/adsub/EVPjtFnerAdsubMgntI";
	}
	
	/**
	 * 과제평가 가감점 내용을 등록 처리 한다.
	 * @param pjtFnerAdsubMgntVO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mgnt/adsub/EVPjtFnerAdsubMgntIProc.do")
	public ModelAndView insertPjtFnerAdsubMgntInfoProc(
			@ModelAttribute("pjtFnerAdsubMgntVO") PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {

		
		commonService.isAdminRuleCd(session, response);
		
		// 가감점 항목 저장
		String adsubMgntNo = pjtFnerAdsubMgntService.insertPjtFnerAdsubMgntInfoProc(pjtFnerAdsubMgntVO);
		
		// 대상등록
		pjtFnerAdsubMgntService.insertPjtFnerAdsubTrgtProc(adsubMgntNo, pjtFnerAdsubMgntVO.getAdsubTrgtCdArr());
		
		
		Map resultMap = new HashMap();   
    	resultMap.put("rtnMsg", "1");     
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}


	/**
	 * 과제평가 가감점 수정 화면으로 이동한다.
	 * @param pjtFnerAdsubMgntVO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mgnt/adsub/EVPjtFnerAdsubMgntU.do")
	public String updatePjtFnerAdsubMgntInfo(
			@ModelAttribute("pjtFnerAdsubMgntVO") PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		commonService.isAdminRuleCd(session, response);
		
		// 통합로그 저장
		commonService.createTiberoTotlLog( session, request, "홈:가감점관리:수정", "EV:03:0004");
				
		// 가감점 구분코드
		List<?> adsubSlctCdList = commonService.getPjtFnerCdList("ER001");
		model.addAttribute("adsubSlctCdList", adsubSlctCdList);
		
		// 적용기관코드
		List<?> adsubApplOrgSlctCdList = commonService.getPjtFnerCdList("ER002");
		model.addAttribute("adsubApplOrgSlctCdList", adsubApplOrgSlctCdList);
		
		// 적용기준일자구분코드
		List<?> adsubApplStanDtSlctCdList = commonService.getPjtFnerCdList("ER003");
		model.addAttribute("adsubApplStanDtSlctCdList", adsubApplStanDtSlctCdList);
		
		// 대상 구분코드
		List<?> adsubTrgtCdList = commonService.getPjtFnerCdList("ER004");
		model.addAttribute("adsubTrgtCdList", adsubTrgtCdList);
		
		model.addAttribute("adsubTrgtCdListCnt", adsubTrgtCdList.size());
				
				
		// 가감점 상세정보 조회
		Map<?,?> resultInfo = pjtFnerAdsubMgntService.selectPjtFnerAdsubMgntInfo(pjtFnerAdsubMgntVO);
		model.addAttribute("resultInfo", resultInfo);
		
		// 가감점 대상목록 조회
		List<?> resultAdsubTrgtCdList = pjtFnerAdsubMgntService.selectPjtFnerAdsubTrgtProc(resultInfo);
		model.addAttribute("resultAdsubTrgtCdList", resultAdsubTrgtCdList);
		
		
		
		pjtFnerAdsubMgntVO.setAdsubMgntNo((String)resultInfo.get("adsubMgntNo"));
		pjtFnerAdsubMgntVO.setAdsubSlctCd((String)resultInfo.get("adsubSlctCd"));
		pjtFnerAdsubMgntVO.setAdsubItem((String)resultInfo.get("adsubItem"));
		pjtFnerAdsubMgntVO.setAdsubDes((String)resultInfo.get("adsubDes"));
		pjtFnerAdsubMgntVO.setAdsubApplOrgSlctCd((String)resultInfo.get("adsubApplOrgSlctCd"));
		pjtFnerAdsubMgntVO.setAdsubGrantDes((String)resultInfo.get("adsubGrantDes"));
		pjtFnerAdsubMgntVO.setAdsubApplStanDtSlctCd((String)resultInfo.get("adsubApplStanDtSlctCd"));
		pjtFnerAdsubMgntVO.setAdsubApplProdDes((String)resultInfo.get("adsubApplProdDes"));
		pjtFnerAdsubMgntVO.setAdsubExamDes((String)resultInfo.get("adsubExamDes"));
		pjtFnerAdsubMgntVO.setNote((String)resultInfo.get("note"));
		
		return "mgnt/adsub/EVPjtFnerAdsubMgntU";
	}
	
	/**
	 * 과제평가 가감점 내용을 수정 처리 한다.
	 * @param pjtFnerAdsubMgntVO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mgnt/adsub/EVPjtFnerAdsubMgntUProc.do")
	public ModelAndView updatePjtFnerAdsubMgntInfoProc(
			@ModelAttribute("pjtFnerAdsubMgntVO") PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {

		
		commonService.isAdminRuleCd(session, response);
		
		pjtFnerAdsubMgntService.updatePjtFnerAdsubMgntInfoProc(pjtFnerAdsubMgntVO);
		
		
		// 대상삭제
		pjtFnerAdsubMgntService.deletePjtFnerAdsubTrgtProc(pjtFnerAdsubMgntVO.getAdsubMgntNo());
				
		// 대상등록
		pjtFnerAdsubMgntService.insertPjtFnerAdsubTrgtProc(pjtFnerAdsubMgntVO.getAdsubMgntNo(), pjtFnerAdsubMgntVO.getAdsubTrgtCdArr());
		
		Map resultMap = new HashMap();   
    	resultMap.put("rtnMsg", "1");     
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * 과제평가 가감점 내용을 삭제 처리 한다.
	 * @param pjtFnerAdsubMgntVO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mgnt/adsub/EVPjtFnerAdsubMgntDProc.do")
	public ModelAndView deletePjtFnerAdsubMgntInfoProc(
			@ModelAttribute("pjtFnerAdsubMgntVO") PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {

		
		commonService.isAdminRuleCd(session, response);
		
		pjtFnerAdsubMgntService.deletePjtFnerAdsubMgntInfoProc(pjtFnerAdsubMgntVO);
		
		Map resultMap = new HashMap();   
		resultMap.put("rtnMsg", "1");      
    	
    	
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
		
	}
	
	
	
	
}
