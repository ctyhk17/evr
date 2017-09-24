package kr.go.ntis.ev.itr.idx.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.go.ntis.ev.cmn.service.CommonService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.fdl.property.EgovPropertyService;

/**
 * @Class Name : PjtFnerHistItrController.java
 * @Description : PjtFnerHistItr Controller Class
 * 				과제평가이력정보 인트로 페이지
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
public class PjtFnerHistItrController {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	


	/**
	 * 과제평가이력정보 인트로 페이지를 조회한다.
	 * @param tmpTmpTemplateVO - 조회할 정보가 담긴 TmpTmpTemplateVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/itr/idx/EVPjtFnerHistItrR.do")
	public String selectPjtFnerHistItrInfo(
			ModelMap model,
			HttpServletRequest request,
			HttpSession session
			) throws Exception {

		// 통합로그 저장
		commonService.createTiberoTotlLog( session, request, "홈:메인페이지", "EV:00:0001");

		return "itr/idx/EVPjtFnerHistItrR";
	}

	
	
}
