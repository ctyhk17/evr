package kr.go.ntis.ev.cmn.service;


import kr.go.ntis.ev.cmn.service.CommonDefaultVO;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Class Name : LoginVO.java
 * @Description : LoginVO Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2016.08.12              최초생성
 *
 * @author 태장혁
 * @since 2016.08.12
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */
public class LoginVO {

	
	private String userId     = null;
	private String psnNm      = null;
	private String email      = null;
	private String blngOrgCd  = null;
	private String ruleCd     = null;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPsnNm() {
		return psnNm;
	}
	public void setPsnNm(String psnNm) {
		this.psnNm = psnNm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBlngOrgCd() {
		return blngOrgCd;
	}
	public void setBlngOrgCd(String blngOrgCd) {
		this.blngOrgCd = blngOrgCd;
	}
	public String getRuleCd() {
		return ruleCd;
	}
	public void setRuleCd(String ruleCd) {
		this.ruleCd = ruleCd;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
    
	
	
	
	

}
