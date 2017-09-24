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
package kr.go.ntis.ev.hist.pjt.service;

import kr.go.ntis.ev.cmn.service.CommonDefaultVO;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Class Name : PjtFnerHistVO.java
 * @Description : PjtFnerHistVO Class
 *                과제최종평가결과 VO
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 태장혁
 * @since 2016. 06.12
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */
public class PjtFnerHistVO extends CommonDefaultVO {

	// 검색조건
	private String searchStanYrFrom      ;      // 검색조건 대상기간_시작년도    	: 사업정보 (SH_PROG_INFO)
	private String searchStanYrTo        ;      // 검색조건 대상기간_종료년도       : 사업정보 (SH_PROG_INFO)
	private String searchDeptDivCd       ;      // 검색조건_신/구 부처구분코드 
	private String searchDeptCd          ;      // 검색조건 사업부처코드 (신규)     : 사업정보 (SH_PROG_INFO)
	private String searchBzNm            ;      // 검색조건 사업명                  : 사업정보 (SH_PROG_INFO)
	
	private String searchKorPjtNm        ;      // 검색조건 과제명                  : 과제기본정보 (SH_PJT_MAIN)
	private String searchPjtPrfrmOrgNm   ;      // 검색조건 수행기관명              : 과제기본정보 (SH_PJT_MAIN)
	private String searchPjtMgntOrgNm    ;      // 과제관리 기관                    : 과제기본정보 (SH_PJT_MAIN) PJT_MGNT_ORG_NM
	
	private String searchMngrHmNm        ;      // 검색조건 연구책임자명            : 참여인력정보 (SH_PRTCP_MP_INFO)
	private String searchRschHmNm        ;      // 검색조건 연구원명                : 참여인력정보 (SH_PRTCP_MP_INFO)
	
	private String searchPjtStopYn       ;      // 검색조건 과제중단여부            : 과제최종평가결과 (SH_PJT_FNER)
	
	private String searchRrno       ;      // 과학기술인등록번호            : 참여인력정보 (SH_PRTCP_MP_INFO)
	
	private String[] searchPjtPrfrmHOrgNm = null;  // 검색조건_수행기관(이형추가)
	
	private String pjtId                 ;		// 과제고유번호
	private String rrno                  ;		// 평가위원 과학기술인 번호
	
	private String orderItem = "ASESOR_HM_NM";
	private String orderDivCd ="ASC";
	
	// 2016.11.08 추가
	private String searchFlag = "N";	// 초기화면 검색 제어
	
	private String[] chk = null;
	
	
	
	public String[] getSearchPjtPrfrmHOrgNm() {
		
		String[] ret = null; 
		
		if ( this.searchPjtPrfrmHOrgNm != null ) { 
			
			ret = new String[searchPjtPrfrmHOrgNm.length]; 
		    for (int i = 0; i < searchPjtPrfrmHOrgNm.length; i++) 
		    { 
		    	ret[i] = this.searchPjtPrfrmHOrgNm[i]; 
		    } 
		} 

		return ret;
		  
	}

	public void setSearchPjtPrfrmHOrgNm(String[] searchPjtPrfrmHOrgNm) {
		
		this.searchPjtPrfrmHOrgNm = new String[searchPjtPrfrmHOrgNm.length]; 
		for (int i = 0; i < searchPjtPrfrmHOrgNm.length; ++i)
		{
			this.searchPjtPrfrmHOrgNm[i] = searchPjtPrfrmHOrgNm[i]; 
		}

	}
	
	
	
	
	
	public String[] getChk() {
		String[] ret = null; 
		
		if ( this.chk != null ) { 
			
			ret = new String[chk.length]; 
		    for (int i = 0; i < chk.length; i++) 
		    { 
		    	ret[i] = this.chk[i]; 
		    } 
		} 

		return ret;
	}

	public void setChk(String[] chk) {
		this.chk = new String[chk.length]; 
		for (int i = 0; i < chk.length; ++i)
		{
			this.chk[i] = chk[i]; 
		}
	}
	
	
	public String getSearchDeptDivCd() {
		return searchDeptDivCd;
	}
	public void setSearchDeptDivCd(String searchDeptDivCd) {
		this.searchDeptDivCd = searchDeptDivCd;
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
	public String getSearchStanYrFrom() {
		return searchStanYrFrom;
	}
	public void setSearchStanYrFrom(String searchStanYrFrom) {
		this.searchStanYrFrom = searchStanYrFrom;
	}
	public String getSearchStanYrTo() {
		return searchStanYrTo;
	}
	public void setSearchStanYrTo(String searchStanYrTo) {
		this.searchStanYrTo = searchStanYrTo;
	}
	public String getSearchDeptCd() {
		return searchDeptCd;
	}
	public void setSearchDeptCd(String searchDeptCd) {
		this.searchDeptCd = searchDeptCd;
	}
	public String getSearchBzNm() {
		return searchBzNm;
	}
	public void setSearchBzNm(String searchBzNm) {
		this.searchBzNm = searchBzNm;
	}
	public String getSearchKorPjtNm() {
		return searchKorPjtNm;
	}
	public void setSearchKorPjtNm(String searchKorPjtNm) {
		this.searchKorPjtNm = searchKorPjtNm;
	}
	public String getSearchPjtPrfrmOrgNm() {
		return searchPjtPrfrmOrgNm;
	}
	public void setSearchPjtPrfrmOrgNm(String searchPjtPrfrmOrgNm) {
		this.searchPjtPrfrmOrgNm = searchPjtPrfrmOrgNm;
	}
	public String getSearchPjtMgntOrgNm() {
		return searchPjtMgntOrgNm;
	}
	public void setSearchPjtMgntOrgNm(String searchPjtMgntOrgNm) {
		this.searchPjtMgntOrgNm = searchPjtMgntOrgNm;
	}
	public String getSearchMngrHmNm() {
		return searchMngrHmNm;
	}
	public void setSearchMngrHmNm(String searchMngrHmNm) {
		this.searchMngrHmNm = searchMngrHmNm;
	}
	public String getSearchRschHmNm() {
		return searchRschHmNm;
	}
	public void setSearchRschHmNm(String searchRschHmNm) {
		this.searchRschHmNm = searchRschHmNm;
	}
	public String getSearchPjtStopYn() {
		return searchPjtStopYn;
	}
	public void setSearchPjtStopYn(String searchPjtStopYn) {
		this.searchPjtStopYn = searchPjtStopYn;
	}
	public String getPjtId() {
		return pjtId;
	}
	public void setPjtId(String pjtId) {
		this.pjtId = pjtId;
	}
	public String getRrno() {
		return rrno;
	}
	public void setRrno(String rrno) {
		this.rrno = rrno;
	}

	
	public String getSearchFlag() {
		return searchFlag;
	}
	public void setSearchFlag(String searchFlag) {
		this.searchFlag = searchFlag;
	}

	public String getSearchRrno() {
		return searchRrno;
	}

	public void setSearchRrno(String searchRrno) {
		this.searchRrno = searchRrno;
	}
	
	
}
