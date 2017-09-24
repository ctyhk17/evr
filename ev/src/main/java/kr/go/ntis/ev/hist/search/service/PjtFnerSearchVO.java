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
package kr.go.ntis.ev.hist.search.service;

import kr.go.ntis.ev.cmn.service.CommonDefaultVO;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Class Name : PjtFnerSearchVO.java
 * @Description : PjtFnerSearchVO Class
 *                과제최종평가결과 검색 VO
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
public class PjtFnerSearchVO extends CommonDefaultVO {

	
	private String dummy;
	private String[] searchHorgNm = null;
	


	public String[] getSearchHorgNm() {
		
		String[] ret = null; 
		
		if ( this.searchHorgNm != null ) { 
			
			ret = new String[searchHorgNm.length]; 
		    for (int i = 0; i < searchHorgNm.length; i++) 
		    { 
		    	ret[i] = this.searchHorgNm[i]; 
		    } 
		} 

		return ret;
		  
	}

	public void setSearchHorgNm(String[] searchHorgNm) {
		
		this.searchHorgNm = new String[searchHorgNm.length]; 
		for (int i = 0; i < searchHorgNm.length; ++i)
		{
			this.searchHorgNm[i] = searchHorgNm[i]; 
		}

	}
	
	public String getDummy() {
		return dummy;
	}

	public void setDummy(String dummy) {
		this.dummy = dummy;
	}
	
	
	
}
