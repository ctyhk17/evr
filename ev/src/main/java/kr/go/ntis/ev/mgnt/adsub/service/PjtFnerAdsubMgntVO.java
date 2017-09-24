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
package kr.go.ntis.ev.mgnt.adsub.service;

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
public class PjtFnerAdsubMgntVO extends CommonDefaultVO {

	private String searchAdsubSlctCd           ;  // 검색조건_가감점구분 
	private String[] searchAdsubTrgtCd = null;  // 검색조건_가감점 대상
	private String searchAdsubDes              ;  // 검색조건_가감점내용
	
	
	private String adsubMgntNo             ;	// 가감점 관리번호
	private String adsubSlctCd             ;	// 구분
	private String adsubItem               ;	// 항목
	private String adsubDes                ;	// 내용
	
	private String adsubApplOrgSlctCd      ;	// 적용기관
	private String adsubGrantDes           ;	// 가감점 부여내용
	private String adsubApplStanDtSlctCd   ;	// 적용기준일자
	private String adsubApplProdDes        ;	// 적용기간
	private String adsubExamDes            ;	// 검토
	private String note                    ;	// 비고
	
	private String[] adsubTrgtCdArr           = null  ;    // 대상

	public String getSearchAdsubSlctCd() {
		return searchAdsubSlctCd;
	}

	public void setSearchAdsubSlctCd(String searchAdsubSlctCd) {
		this.searchAdsubSlctCd = searchAdsubSlctCd;
	}

	public String[] getSearchAdsubTrgtCd() {
		
		String[] ret = null; 
		
		if ( this.searchAdsubTrgtCd != null ) { 
			
			ret = new String[searchAdsubTrgtCd.length]; 
		    for (int i = 0; i < searchAdsubTrgtCd.length; i++) 
		    { 
		    	ret[i] = this.searchAdsubTrgtCd[i]; 
		    } 
		} 

		return ret;
		  
	}

	public void setSearchAdsubTrgtCd(String[] searchAdsubTrgtCd) {
		
		this.searchAdsubTrgtCd = new String[searchAdsubTrgtCd.length]; 
		for (int i = 0; i < searchAdsubTrgtCd.length; ++i)
		{
			this.searchAdsubTrgtCd[i] = searchAdsubTrgtCd[i]; 
		}

	}

	public String getSearchAdsubDes() {
		return searchAdsubDes;
	}

	public void setSearchAdsubDes(String searchAdsubDes) {
		this.searchAdsubDes = searchAdsubDes;
	}

	public String getAdsubMgntNo() {
		return adsubMgntNo;
	}

	public void setAdsubMgntNo(String adsubMgntNo) {
		this.adsubMgntNo = adsubMgntNo;
	}

	public String getAdsubSlctCd() {
		return adsubSlctCd;
	}

	public void setAdsubSlctCd(String adsubSlctCd) {
		this.adsubSlctCd = adsubSlctCd;
	}

	public String getAdsubItem() {
		return adsubItem;
	}

	public void setAdsubItem(String adsubItem) {
		this.adsubItem = adsubItem;
	}

	public String getAdsubDes() {
		return adsubDes;
	}

	public void setAdsubDes(String adsubDes) {
		this.adsubDes = adsubDes;
	}

	public String getAdsubApplOrgSlctCd() {
		return adsubApplOrgSlctCd;
	}

	public void setAdsubApplOrgSlctCd(String adsubApplOrgSlctCd) {
		this.adsubApplOrgSlctCd = adsubApplOrgSlctCd;
	}

	public String getAdsubGrantDes() {
		return adsubGrantDes;
	}

	public void setAdsubGrantDes(String adsubGrantDes) {
		this.adsubGrantDes = adsubGrantDes;
	}

	public String getAdsubApplStanDtSlctCd() {
		return adsubApplStanDtSlctCd;
	}

	public void setAdsubApplStanDtSlctCd(String adsubApplStanDtSlctCd) {
		this.adsubApplStanDtSlctCd = adsubApplStanDtSlctCd;
	}

	public String getAdsubApplProdDes() {
		return adsubApplProdDes;
	}

	public void setAdsubApplProdDes(String adsubApplProdDes) {
		this.adsubApplProdDes = adsubApplProdDes;
	}

	public String getAdsubExamDes() {
		return adsubExamDes;
	}

	public void setAdsubExamDes(String adsubExamDes) {
		this.adsubExamDes = adsubExamDes;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String[] getAdsubTrgtCdArr() {
		String[] ret = null; 
		
		if ( this.adsubTrgtCdArr != null ) { 
			
			ret = new String[adsubTrgtCdArr.length]; 
		    for (int i = 0; i < adsubTrgtCdArr.length; i++) 
		    { 
		    	ret[i] = this.adsubTrgtCdArr[i]; 
		    } 
		} 

		return ret;
	}

	public void setAdsubTrgtCdArr(String[] adsubTrgtCdArr) {
		this.adsubTrgtCdArr = new String[adsubTrgtCdArr.length]; 
		for (int i = 0; i < adsubTrgtCdArr.length; ++i)
		{
			this.adsubTrgtCdArr[i] = adsubTrgtCdArr[i]; 
		}
	}
	
	
	
	
}
