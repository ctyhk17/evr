/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package kr.go.ntis.ev.hist.asesor.service;

import kr.go.ntis.ev.cmn.service.CommonDefaultVO;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Class Name : SampleDefaultVO.java
 * @Description : SampleDefaultVO Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */
public class AsesorAssmtPrtcpHistVO extends CommonDefaultVO {

	
	private String searchAsesorHmNm          ;  // 검색조건_평가위원명           
	private String searchBlngOrgNm           ;  // 검색조건_소속기관
	
	private String[] searchBlngHOrgNm = null;  // 검색조건_소속기관(이형추가)
	
	
	private String searchGenderDivCd         ;  // 검색조건_성별                 
	private String searchSpAreaCd            ;  // 검색조건_전문분야      
	
	private String searchPjtAssmtPrtcpYrFrom ;  // 검색조건_평가참여기간_시작년도
	private String searchPjtAssmtPrtcpYrTo   ;  // 검색조건_평가참여기간_종료년도
	private String searchAssmtPhaseCd        ;  // 검색조건_평가단계
	private String searchRrno                ;  // 검색조건_과학기술인등록번호
	
	private String rrno;
	
	private String orderItem = "PJT_PRFRM_ORG_NM";
	private String orderDivCd ="ASC";
	
	// 2016.11.08 추가
	private String searchFlag = "N";	// 초기 검색 여부 플래스
	
	
	
	public String[] getSearchBlngHOrgNm() {
		
		String[] ret = null; 
		
		if ( this.searchBlngHOrgNm != null ) { 
			
			ret = new String[searchBlngHOrgNm.length]; 
		    for (int i = 0; i < searchBlngHOrgNm.length; i++) 
		    { 
		    	ret[i] = this.searchBlngHOrgNm[i]; 
		    } 
		} 

		return ret;
		  
	}

	public void setSearchBlngHOrgNm(String[] searchBlngHOrgNm) {
		
		this.searchBlngHOrgNm = new String[searchBlngHOrgNm.length]; 
		for (int i = 0; i < searchBlngHOrgNm.length; ++i)
		{
			this.searchBlngHOrgNm[i] = searchBlngHOrgNm[i]; 
		}

	}
	
	
	
	
	public String getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}
	public String getOrderDivCd() {
		return orderDivCd;
	}
	public void setOrderDivCd(String orderDivCd) {
		this.orderDivCd = orderDivCd;
	}
	public String getSearchRrno() {
		return searchRrno;
	}
	public void setSearchRrno(String searchRrno) {
		this.searchRrno = searchRrno;
	}
	public String getSearchAssmtPhaseCd() {
		return searchAssmtPhaseCd;
	}
	public void setSearchAssmtPhaseCd(String searchAssmtPhaseCd) {
		this.searchAssmtPhaseCd = searchAssmtPhaseCd;
	}
	public String getRrno() {
		return rrno;
	}
	public void setRrno(String rrno) {
		this.rrno = rrno;
	}
	public String getSearchAsesorHmNm() {
		return searchAsesorHmNm;
	}
	public void setSearchAsesorHmNm(String searchAsesorHmNm) {
		this.searchAsesorHmNm = searchAsesorHmNm;
	}
	public String getSearchBlngOrgNm() {
		return searchBlngOrgNm;
	}
	public void setSearchBlngOrgNm(String searchBlngOrgNm) {
		this.searchBlngOrgNm = searchBlngOrgNm;
	}
	public String getSearchGenderDivCd() {
		return searchGenderDivCd;
	}
	public void setSearchGenderDivCd(String searchGenderDivCd) {
		this.searchGenderDivCd = searchGenderDivCd;
	}
	public String getSearchSpAreaCd() {
		return searchSpAreaCd;
	}
	public void setSearchSpAreaCd(String searchSpAreaCd) {
		this.searchSpAreaCd = searchSpAreaCd;
	}
	public String getSearchPjtAssmtPrtcpYrFrom() {
		return searchPjtAssmtPrtcpYrFrom;
	}
	public void setSearchPjtAssmtPrtcpYrFrom(String searchPjtAssmtPrtcpYrFrom) {
		this.searchPjtAssmtPrtcpYrFrom = searchPjtAssmtPrtcpYrFrom;
	}
	public String getSearchPjtAssmtPrtcpYrTo() {
		return searchPjtAssmtPrtcpYrTo;
	}
	public void setSearchPjtAssmtPrtcpYrTo(String searchPjtAssmtPrtcpYrTo) {
		this.searchPjtAssmtPrtcpYrTo = searchPjtAssmtPrtcpYrTo;
	}
	
	
	public String getSearchFlag() {
		return searchFlag;
	}
	public void setSearchFlag(String searchFlag) {
		this.searchFlag = searchFlag;
	}
	

	

}
