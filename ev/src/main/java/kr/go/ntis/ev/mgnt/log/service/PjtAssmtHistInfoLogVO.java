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
package kr.go.ntis.ev.mgnt.log.service;

import kr.go.ntis.ev.cmn.service.CommonDefaultVO;

/**
 * @Class Name : PjtAssmtHistInfoLogVO.java
 * @Description : PjtAssmtHistInfoLogVO Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2016.11.02           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2016.11.02
 * @version 2016.11.02
 * @see
 *
 */
public class PjtAssmtHistInfoLogVO extends CommonDefaultVO {

	
	private String searchUserId;
	private String searchUserNm;
	private String searchConnDtFrom;
	private String searchConnDtTo;
	private String searchConnIp;
	private String searchConnSlct;
	
	private String seq;

	
	
	public String getSearchUserId() {
		return searchUserId;
	}

	public void setSearchUserId(String searchUserId) {
		this.searchUserId = searchUserId;
	}

	public String getSearchUserNm() {
		return searchUserNm;
	}

	public void setSearchUserNm(String searchUserNm) {
		this.searchUserNm = searchUserNm;
	}

	public String getSearchConnDtFrom() {
		return searchConnDtFrom;
	}

	public void setSearchConnDtFrom(String searchConnDtFrom) {
		this.searchConnDtFrom = searchConnDtFrom;
	}

	public String getSearchConnDtTo() {
		return searchConnDtTo;
	}

	public void setSearchConnDtTo(String searchConnDtTo) {
		this.searchConnDtTo = searchConnDtTo;
	}

	public String getSearchConnIp() {
		return searchConnIp;
	}

	public void setSearchConnIp(String searchConnIp) {
		this.searchConnIp = searchConnIp;
	}

	

	public String getSearchConnSlct() {
		return searchConnSlct;
	}

	public void setSearchConnSlct(String searchConnSlct) {
		this.searchConnSlct = searchConnSlct;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	
	
	
	
}
