package kr.go.ntis.ev.cmn.service.impl;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import kr.go.ntis.ev.cmn.service.CommonService;
import kr.go.ntis.ev.cmn.service.LoginVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : TmpTempTemplate.java
 * @Description : TmpTempTemplate Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2016.07.12           최초생성
 *
 * @author 개발팀
 * @since 2016.07.12
 * @version 1.0
 * @see
 *  
 */

@Service("commonService")
public class CommonServiceImpl extends EgovAbstractServiceImpl implements CommonService {
	
	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/** SampleDAO */
    @Resource(name="commonDAO")
    private CommonDAO commonDAO;
    
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
	public String getStDt(int interval) throws Exception {
		// TODO Auto-generated method stub

		Calendar cal = Calendar.getInstance ( );
		cal.add(cal.MONTH, interval ); 
		String yyyy  = String.valueOf(cal.get(cal.YEAR ));
		String mm = String.valueOf(cal.get(cal.MONTH) + 1);
		if(mm.length() < 2)
			mm = "0"+mm;
		String dd   = String.valueOf(cal.get(cal.DATE ));
		if(dd.length() < 2)
			dd = "0"+dd;
		
		return yyyy+"-"+mm+"-"+dd;
	}

	// 페이지 정보 설정
	public void getPageInfo(PaginationInfo paginationInfo, int pageIndex) throws Exception {
		// TODO Auto-generated method stub
        
        paginationInfo.setCurrentPageNo(pageIndex);
        paginationInfo.setPageSize(propertiesService.getInt("pageSize"));
        paginationInfo.setRecordCountPerPage(propertiesService.getInt("recordCountPerPage"));
		
	}
	
	public void getPageInfo(PaginationInfo paginationInfo, int pageIndex, int recordCountPerPage) throws Exception{
		// TODO Auto-generated method stub
        
        paginationInfo.setCurrentPageNo(pageIndex);
        paginationInfo.setPageSize(propertiesService.getInt("pageSize"));
        paginationInfo.setRecordCountPerPage(recordCountPerPage);
		
	}
	
	
	// 과제평가이력정보 조회
	public List getPjtFnerCdList(String grpCd) throws Exception{
		return commonDAO.getPjtFnerCdList(grpCd);
	}
	
	// 기준년도 조회
    public List getStanYrList() throws Exception{
    	return commonDAO.getStanYrList();
    }
    
    // 공통코드 조회
    public List getCmnCdList(String grpCd) throws Exception{
    	return commonDAO.getCmnCdList(grpCd);
    }
    
    public List getNewDeptCdList() throws Exception{
    	return commonDAO.getNewDeptCdList();
    }
    
    public List getOldDeptCdList() throws Exception{
    	return commonDAO.getOldDeptCdList();
    }
    
    
    /**
     * 통합로그 저장
     */
    public void createTiberoTotlLog( HttpSession session, HttpServletRequest request, String paramUrlKwd, String paramOptionPos ) throws Exception 
    {
    	
    	LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");
    	
    	String svcCd       = "EV";    				     				// 서비스 구분코드 (필수)
    	String userIp      = request.getRemoteAddr();	 				// 사용자 IP주소   (필수)
    	String userId      = loginVO.getUserId();						// 사용자 ID
    	String userTypeCd  = loginVO.getRuleCd();						// 사용자 유형코드
		String blngOrgCd   = loginVO.getBlngOrgCd();					// 사용자 기관코드
		String prePgUrl    = request.getHeader("REFERER");              // 이전 URL 정보
		String accessPgUrl = request.getRequestURL().toString();        // 현재 URL 정보 (필수)
		String urlKwd      = URLEncoder.encode(paramUrlKwd, "euc-kr");  // 페이지 타이틀 정보 (필수)
		String seachKwd    = "";                    					// 검색어 정보
		String optionCd    = "1";		            					// 유효 페이지뷰 (필수)
		String optionDes   = "";                    					// 검색어, 선택사항
		String userAgent   = request.getHeader("USER-AGENT");           // 사용자 OS 및 Agent 정보 (필수)
		String screenSize  = "";                    					// 사용자 화면 해상도
		String optionPos  = paramOptionPos;                     		// 페이지 위치 통계용 (필수)
		
		
		
		
		StringBuffer logData = new StringBuffer();
	    
	    logData.append("svc_cd=").append(svcCd);
		logData.append("&user_ip=").append(userIp);
		logData.append("&user_id=").append(userId);
		logData.append("&user_type_cd=").append( userTypeCd );     /* 로그인 사용자 TYPE 로딩 */
		logData.append("&blng_org_cd=").append(  blngOrgCd  );     /* 로그인 사용자 기관코드 로딩 */ 
		logData.append("&pre_pg_url=").append(prePgUrl);
		logData.append("&access_pg_url=").append(accessPgUrl);
		logData.append("&url_kwd=").append(urlKwd);
		logData.append("&search_kwd=").append(seachKwd);
		logData.append("&option_cd=").append(optionCd);
		logData.append("&option_des=").append(optionDes);
		logData.append("&user_agent=").append(userAgent);
		logData.append("&screen_size=").append(screenSize);
		logData.append("&option_pos=").append(optionPos);
		
	    
		java.io.OutputStream out = null;

	    try {
	    	
	       if(svcCd == null ||  "".equals(svcCd) ){
		   	   new Exception("서비스코드를 입력하여 주십시오");
	       }
	       
	       
	       if(paramUrlKwd == null ||  "".equals(paramUrlKwd) ){
	    	   new Exception("현재 페이지 타이틀 정보를 입력하여 주십시오");
	       }
	       
	       if(optionCd == null ||  "".equals(optionCd) ){
	    	   new Exception("유효 페이뷰를 입력하여 주십시오");
	       }
	       
	       if(optionPos == null ||  "".equals(optionPos) ){
	    	   new Exception("페이지 Depth 를 입력하여 주십시오");
	       }
		      
		   java.net.URL url = new java.net.URL("https://logger.ntis.go.kr/logInsert2.jsp");
		   
		   java.net.HttpURLConnection urlConnection = (java.net.HttpURLConnection) url.openConnection();
		   urlConnection.setDoInput(true);
		   urlConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		   urlConnection.setAllowUserInteraction(false);
		   urlConnection.setRequestMethod("POST");
		   urlConnection.setDoOutput(true);
		   
		   String paramstr = logData.toString();
		   out    = urlConnection.getOutputStream();
		   out.write(paramstr.getBytes());
		   out.flush();
		   //urlConnection.getInputStream();
		       
	   }catch (Exception e) {
		   LOGGER.debug("createTiberoTotlLog Exception");
	   }finally{
		   if(out != null)
		   {
			   out.close();
		   }
		   out = null;
	   }
	    
    }
    
    
    /**
     * 통합로그 저장
     */
    public void createTiberoTotlLog( HttpSession session, HttpServletRequest request, String paramUrlKwd, String paramOptionPos, String paramSearchKwd ) throws Exception 
    {
    	
    	LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");
    	
    	String svcCd       = "EV";    				     				// 서비스 구분코드 (필수)
    	String userIp      = request.getRemoteAddr();	 				// 사용자 IP주소   (필수)
    	String userId      = loginVO.getUserId();						// 사용자 ID
    	String userTypeCd  = loginVO.getRuleCd();						// 사용자 유형코드
		String blngOrgCd   = loginVO.getBlngOrgCd();					// 사용자 기관코드
		String prePgUrl    = request.getHeader("REFERER");              // 이전 URL 정보
		String accessPgUrl = request.getRequestURL().toString();        // 현재 URL 정보 (필수)
		String urlKwd      = URLEncoder.encode(paramUrlKwd, "euc-kr");  // 페이지 타이틀 정보 (필수)
		String seachKwd    = paramSearchKwd;                    		// 검색어 정보
		String optionCd    = "1";		            					// 유효 페이지뷰 (필수)
		String optionDes   = "";                    					// 검색어, 선택사항
		String userAgent   = request.getHeader("USER-AGENT");           // 사용자 OS 및 Agent 정보 (필수)
		String screenSize  = "";                    					// 사용자 화면 해상도
		String optionPos  = paramOptionPos;                     		// 페이지 위치 통계용 (필수)
		
		
		
		
		StringBuffer logData = new StringBuffer();
	    
	    logData.append("svc_cd=").append(svcCd);
		logData.append("&user_ip=").append(userIp);
		logData.append("&user_id=").append(userId);
		logData.append("&user_type_cd=").append( userTypeCd );     /* 로그인 사용자 TYPE 로딩 */
		logData.append("&blng_org_cd=").append(  blngOrgCd  );     /* 로그인 사용자 기관코드 로딩 */ 
		logData.append("&pre_pg_url=").append(prePgUrl);
		logData.append("&access_pg_url=").append(accessPgUrl);
		logData.append("&url_kwd=").append(urlKwd);
		logData.append("&search_kwd=").append(seachKwd);
		logData.append("&option_cd=").append(optionCd);
		logData.append("&option_des=").append(optionDes);
		logData.append("&user_agent=").append(userAgent);
		logData.append("&screen_size=").append(screenSize);
		logData.append("&option_pos=").append(optionPos);
		
	    
		java.io.OutputStream out = null;

	    try {
	    	
	       if(svcCd == null ||  "".equals(svcCd) ){
		   	   new Exception("서비스코드를 입력하여 주십시오");
	       }
	       
	       
	       if(paramUrlKwd == null ||  "".equals(paramUrlKwd) ){
	    	   new Exception("현재 페이지 타이틀 정보를 입력하여 주십시오");
	       }
	       
	       if(optionCd == null ||  "".equals(optionCd) ){
	    	   new Exception("유효 페이뷰를 입력하여 주십시오");
	       }
	       
	       if(optionPos == null ||  "".equals(optionPos) ){
	    	   new Exception("페이지 Depth 를 입력하여 주십시오");
	       }
		      
		   java.net.URL url = new java.net.URL("https://logger.ntis.go.kr/logInsert2.jsp");
		   
		   java.net.HttpURLConnection urlConnection = (java.net.HttpURLConnection) url.openConnection();
		   urlConnection.setDoInput(true);
		   urlConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		   urlConnection.setAllowUserInteraction(false);
		   urlConnection.setRequestMethod("POST");
		   urlConnection.setDoOutput(true);
		   
		   String paramstr = logData.toString();
		   out    = urlConnection.getOutputStream();
		   out.write(paramstr.getBytes());
		   out.flush();
		   //urlConnection.getInputStream();
		       
	   }catch (Exception e) {
		   LOGGER.debug("createTiberoTotlLog Exception");
	   }finally{
		   if(out != null)
		   {
			   out.close();
		   }
		   out = null;
	   }
	    
    }
    
    
    
    public void isAdminRuleCd(HttpSession session, HttpServletResponse response) throws Exception{
    	
    	LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");
    	
    	String ruleCd = loginVO.getRuleCd();
    	
    	if(!"EV9999".equals(ruleCd)){
    		response.sendRedirect("/html/authError.html");
    	}
    }
    
    
    // 이형부서목록 검색
    public List getHeteromorphismDeptNm(String searchOrgNm, String opCode) throws Exception{
    	
    	String horgApiUrl = propertiesService.getString("horgApiUrl");
    	String apprvKey = propertiesService.getString("apprvKey");
    	

    	URL url = null;
    	
    	StringBuffer sb =null;
    	StringBuffer bodyStr = null;
    	
    	BufferedReader in = null;
    	
    	HttpsURLConnection conn = null;
    	PrintWriter pw = null;
    	String inputLine = null;
    	
    	DocumentBuilderFactory dbf = null;
    	DocumentBuilder db = null;
    	
    	String xmlMsg = null;
    	InputSource ips = null;
    	Document doc = null;
    	Element root = null;
    	NodeList statusNodeList = null;
    	NodeList recordNodeList = null;
    	Node recordNode = null;
    	NamedNodeMap recordNodeAttr = null;
    	
    	String reCode      = null;
    	String orgCd       = null;
        String orgNm       = null;
        String stdOrgCd    = null;
        String stdOrgKorNm = null;
        
        List<String> rtnOrgList = new ArrayList<String>(); 
        
    	
    	try {					
	    	url = new URL(horgApiUrl);
	    	conn = (HttpsURLConnection)url.openConnection();	    	   
	    	
	    	conn.setRequestMethod("POST");
	    	//conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	    	//요청명 한글 깨짐현상 발생시 Content-Type 에 charset=UTF-8 또는 EUC-KR을 사용하여 처리
	    	//conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8;");  
	    	// UTF-8은 운영에서 안됨
	    	conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=EUC-KR;");
	    	conn.setConnectTimeout(5000);
	    	conn.setRequestProperty("Connection","close");
	    	conn.setUseCaches(false);
	    	conn.setDoInput(true);
	    	conn.setDoOutput(true);		 
	    	bodyStr =  new StringBuffer();
	    	bodyStr.append("opCode="+opCode);
	    	bodyStr.append("&orgNm="+searchOrgNm);
	    	bodyStr.append("&apprvKey="+apprvKey);
	    	
	    	
//	    	System.out.println("====================");
//    		System.out.println(bodyStr.toString());
//    		System.out.println("====================");
    		
    		
//    		System.out.println("utf-8 -> euc-kr        : " + new String(bodyStr.toString().getBytes("utf-8"), "euc-kr"));
//    		System.out.println("utf-8 -> ksc5601       : " + new String(bodyStr.toString().getBytes("utf-8"), "ksc5601"));
//    		System.out.println("utf-8 -> x-windows-949 : " + new String(bodyStr.toString().getBytes("utf-8"), "x-windows-949"));
//    		System.out.println("utf-8 -> iso-8859-1    : " + new String(bodyStr.toString().getBytes("utf-8"), "iso-8859-1"));
//    		System.out.println("iso-8859-1 -> euc-kr        : " + new String(bodyStr.toString().getBytes("iso-8859-1"), "euc-kr"));
//    		System.out.println("iso-8859-1 -> ksc5601       : " + new String(bodyStr.toString().getBytes("iso-8859-1"), "ksc5601"));
//    		System.out.println("iso-8859-1 -> x-windows-949 : " + new String(bodyStr.toString().getBytes("iso-8859-1"), "x-windows-949"));
//    		System.out.println("iso-8859-1 -> utf-8         : " + new String(bodyStr.toString().getBytes("iso-8859-1"), "utf-8"));
//    		System.out.println("euc-kr -> utf-8         : " + new String(bodyStr.toString().getBytes("euc-kr"), "utf-8"));
//    		System.out.println("euc-kr -> ksc5601       : " + new String(bodyStr.toString().getBytes("euc-kr"), "ksc5601"));
//    		System.out.println("euc-kr -> x-windows-949 : " + new String(bodyStr.toString().getBytes("euc-kr"), "x-windows-949"));
//    		System.out.println("euc-kr -> iso-8859-1    : " + new String(bodyStr.toString().getBytes("euc-kr"), "iso-8859-1"));
//    		System.out.println("ksc5601 -> euc-kr        : " + new String(bodyStr.toString().getBytes("ksc5601"), "euc-kr"));
//    		System.out.println("ksc5601 -> utf-8         : " + new String(bodyStr.toString().getBytes("ksc5601"), "utf-8"));
//    		System.out.println("ksc5601 -> x-windows-949 : " + new String(bodyStr.toString().getBytes("ksc5601"), "x-windows-949"));
//    		System.out.println("ksc5601 -> iso-8859-1    : " + new String(bodyStr.toString().getBytes("ksc5601"), "iso-8859-1"));
//    		System.out.println("x-windows-949 -> euc-kr     : " + new String(bodyStr.toString().getBytes("x-windows-949"), "euc-kr"));
//    		System.out.println("x-windows-949 -> utf-8      : " + new String(bodyStr.toString().getBytes("x-windows-949"), "utf-8"));
//    		System.out.println("x-windows-949 -> ksc5601    : " + new String(bodyStr.toString().getBytes("x-windows-949"), "ksc5601"));
//    		System.out.println("x-windows-949 -> iso-8859-1 : " + new String(bodyStr.toString().getBytes("x-windows-949"), "iso-8859-1"));
    		
    		
    		
	    	
	
	    	//PrintWriter pw = new PrintWriter(new OutputStreamWriter(conn.getOutputStream()));
	    	//결과값이 한글깨짐현상 발생시(getOutputStream 캐릭터셋 변경)
	    	//pw = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(),"UTF-8"));
	    	pw = new PrintWriter(new OutputStreamWriter(conn.getOutputStream()));
	    	pw.write(bodyStr.toString());
	    	pw.flush();
	    	
	    	//in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
	    	in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
	    	//in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    	sb = new StringBuffer();
	    	
	    	while ((inputLine = in.readLine()) != null){	
	    		sb.append(inputLine);
	    	}
	    	in.close();
    	} catch (Exception e) {
    		LOGGER.debug("getHeteromorphismDeptNm Exception");
    	}finally{
    		if(in !=null){
		    	try {
		    		in.close();
		    	}catch (IOException ie) {
		    		ie.printStackTrace();
		    	}
	    	}
    	}		
    	
    	
    	
    	// XML 파싱
    	try{
    		
    		dbf = DocumentBuilderFactory.newInstance();
    		db = dbf.newDocumentBuilder();
    		
    		LOGGER.info("====================");
    		LOGGER.info(sb.toString());
    		LOGGER.info("====================");
    		
    		LOGGER.info("utf-8 -> euc-kr        : " + new String(sb.toString().getBytes("utf-8"), "euc-kr"));
    		LOGGER.info("utf-8 -> ksc5601       : " + new String(sb.toString().getBytes("utf-8"), "ksc5601"));
    		LOGGER.info("utf-8 -> x-windows-949 : " + new String(sb.toString().getBytes("utf-8"), "x-windows-949"));
    		LOGGER.info("utf-8 -> iso-8859-1    : " + new String(sb.toString().getBytes("utf-8"), "iso-8859-1"));
    		LOGGER.info("iso-8859-1 -> euc-kr        : " + new String(sb.toString().getBytes("iso-8859-1"), "euc-kr"));
    		LOGGER.info("iso-8859-1 -> ksc5601       : " + new String(sb.toString().getBytes("iso-8859-1"), "ksc5601"));
    		LOGGER.info("iso-8859-1 -> x-windows-949 : " + new String(sb.toString().getBytes("iso-8859-1"), "x-windows-949"));
    		LOGGER.info("iso-8859-1 -> utf-8         : " + new String(sb.toString().getBytes("iso-8859-1"), "utf-8"));
    		LOGGER.info("euc-kr -> utf-8         : " + new String(sb.toString().getBytes("euc-kr"), "utf-8"));
    		LOGGER.info("euc-kr -> ksc5601       : " + new String(sb.toString().getBytes("euc-kr"), "ksc5601"));
    		LOGGER.info("euc-kr -> x-windows-949 : " + new String(sb.toString().getBytes("euc-kr"), "x-windows-949"));
    		LOGGER.info("euc-kr -> iso-8859-1    : " + new String(sb.toString().getBytes("euc-kr"), "iso-8859-1"));
    		LOGGER.info("ksc5601 -> euc-kr        : " + new String(sb.toString().getBytes("ksc5601"), "euc-kr"));
    		LOGGER.info("ksc5601 -> utf-8         : " + new String(sb.toString().getBytes("ksc5601"), "utf-8"));
    		LOGGER.info("ksc5601 -> x-windows-949 : " + new String(sb.toString().getBytes("ksc5601"), "x-windows-949"));
    		LOGGER.info("ksc5601 -> iso-8859-1    : " + new String(sb.toString().getBytes("ksc5601"), "iso-8859-1"));
    		LOGGER.info("x-windows-949 -> euc-kr     : " + new String(sb.toString().getBytes("x-windows-949"), "euc-kr"));
    		LOGGER.info("x-windows-949 -> utf-8      : " + new String(sb.toString().getBytes("x-windows-949"), "utf-8"));
    		LOGGER.info("x-windows-949 -> ksc5601    : " + new String(sb.toString().getBytes("x-windows-949"), "ksc5601"));
    		LOGGER.info("x-windows-949 -> iso-8859-1 : " + new String(sb.toString().getBytes("x-windows-949"), "iso-8859-1"));
    		
        	xmlMsg = sb.toString();
        	xmlMsg = xmlMsg.replace("<![CDATA[", "");
        	xmlMsg = xmlMsg.replace("]]>", "");
        	
    		ips = new InputSource(new StringReader(xmlMsg));
    		
    		doc = db.parse(ips);
    		
    		
    		// 루트 엘리먼트 접근
            root = doc.getDocumentElement();
            
            statusNodeList = root.getElementsByTagName("reCode");
            for(int i=0; i<statusNodeList.getLength(); i++) 
            {
            	Node statusNode = statusNodeList.item(i);
            	if(statusNode.getNodeType() == Node.ELEMENT_NODE) {
            		reCode = statusNode.getChildNodes().item(0).getNodeValue();
                }
            	
            }
            
            recordNodeList = root.getElementsByTagName("record");
            
            
            
            
            for(int i=0; i<recordNodeList.getLength(); i++) 
            {
                
            	recordNode = recordNodeList.item(i);
                
                recordNodeAttr = recordNode.getAttributes(); // 속성 값을 리턴
                
                orgCd       = recordNodeAttr.getNamedItem("orgCd").getNodeValue();
                orgNm       = recordNodeAttr.getNamedItem("orgNm").getNodeValue();
                stdOrgCd    = recordNodeAttr.getNamedItem("stdOrgCd").getNodeValue();
                stdOrgKorNm = recordNodeAttr.getNamedItem("stdOrgKorNm").getNodeValue();
                
                
                rtnOrgList.add(orgNm);
                
                
            }
    		
    		
    	}catch(Exception e){
    		LOGGER.debug("getHeteromorphismDeptNm Exception");
    	}
    	

    	
    	
    	return rtnOrgList;
    }
    
    
    
    
    
    
}
