package kr.go.ntis.ev.cmn.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.go.ntis.ev.cmn.service.CommonService;
import kr.go.ntis.ev.cmn.service.LoginService;
import kr.go.ntis.ev.cmn.service.LoginVO;
import kr.go.ntis.ev.hist.pjt.service.PjtFnerHistService;
import kr.go.ntis.ev.hist.pjt.service.PjtFnerHistVO;
import kr.go.ntis.sso.api.SSOApiManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.initech.eam.smartenforcer.SECode;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : LoginController.java
 * @Description : LoginController Controller Class
 *                로그인 컨트롤러
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
public class NtisGlobalController {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	
	/**
	 * NTIS 홈페이지 글로벌 메뉴를 보여준다.
	 * @param
	 * @param
	 * @return
	 * @exception Exception
	 */
	@RequestMapping("/globalMenu.do")
	public String globalMenu(HttpServletRequest req,HttpServletResponse res, HttpSession session) throws Exception {
		
		
		String paraReturnURI = req.getRequestURL().toString();
		
		URL ocu;
		
		ocu = new URL("https://www.ntis.go.kr/ThGlobalMenu.do");
		         
		//BufferedReader in = new BufferedReader(new InputStreamReader(ocu.openStream());
		// 2015.07.08 한글깨짐 현상으로 "utf-8" 추가
		// 외부에서 넘어오기 때문에 euc-kr로 해야 한글이 안깨짐  
		BufferedReader in = new BufferedReader(new InputStreamReader(ocu.openStream(),"euc-kr"));
		           
		String inputLine = ""; 
		StringBuilder fullLine = new StringBuilder();
		
		while ((inputLine = in.readLine()) != null){
			fullLine.append(inputLine);
			fullLine.append("\n");  /* java Script 오류 해결  15.01.08 */
		}
		
		PrintWriter out = null;
		               
		res.setCharacterEncoding("utf-8");    
		res.setContentType("text/xml; charset=utf-8"); 
		try {
			out = res.getWriter();     
			out.print(fullLine.toString());
		}catch(Exception e){
			
			LOGGER.debug(" globalMenu Exception...............");
		} finally {
			out.flush();
			in.close();
		}
		
		
		return null;
	}
	
	/**
	 * NTIS 홈페이지 글로벌 사용자 메뉴를 보여준다.
	 * @param
	 * @param
	 * @return
	 * @exception Exception
	 */ 
	@RequestMapping("/globalUserMenu.do")
	public String globalUserMenu(HttpServletRequest req,HttpServletResponse res, HttpSession session) throws Exception {
		
		
		SSOApiManager ssoApi = new SSOApiManager();
		String ssoId = ssoApi.getSsoId( req );
		
			
			
		String paraUserId = ssoId;
		String paraReturnURI = req.getRequestURL().toString();
		
		URL ocu;
		
		paraReturnURI = "https://www.ntis.go.kr";
		ocu = new URL("https://www.ntis.go.kr/ThGlobalUserMenu.do?ssoId=" + paraUserId + "&returnURI=" + paraReturnURI);
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(ocu.openStream(),"euc-kr"));
		      
		String inputLine = "";
		StringBuilder fullLine = new StringBuilder();
		
		while ((inputLine = in.readLine()) != null){
			fullLine.append(inputLine);
			fullLine.append("\n");  /* java Script 오류 해결  15.01.08 */			
		}
		
		PrintWriter out = null;
		
		res.setContentType("text/xml; charset=utf-8"); 
		try {
			out = res.getWriter();
			out.print(fullLine.toString());
		}catch(Exception e){
			LOGGER.debug(" globalUserMenu Exception...............");
		} finally {
			out.flush();
			in.close();
		}
		return null;
	}
	
	
	

}
