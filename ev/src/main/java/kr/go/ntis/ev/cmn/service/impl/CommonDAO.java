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
package kr.go.ntis.ev.cmn.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

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

@Repository("commonDAO")
public class CommonDAO extends EgovAbstractDAO {

	// 과제평가이력정보 코드 조회
	public List getPjtFnerCdList(String grpCd) throws Exception{
		return list("kr.go.ntis.ev.cmn.Common.selectPjtFnerCdList", grpCd);
	}
	
	// 기준년도 조회
	public List getStanYrList() throws Exception{
		return list("kr.go.ntis.ev.cmn.Common.selectStanYrList", null);
    }

	// 공통코드 조회
	public List getCmnCdList(String grpCd) throws Exception{
		return list("kr.go.ntis.ev.cmn.Common.selectCmnCdList", grpCd);
    }
	
	// 신부처코드 조회
	public List getNewDeptCdList() throws Exception{
		return list("kr.go.ntis.ev.cmn.Common.getNewDeptCdList", null);
    }
		
	// 구부처코드 조회
	public List getOldDeptCdList() throws Exception{
		return list("kr.go.ntis.ev.cmn.Common.getOldDeptCdList", null);
    }
	

}
