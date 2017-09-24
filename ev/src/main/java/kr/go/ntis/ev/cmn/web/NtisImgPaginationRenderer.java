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
package kr.go.ntis.ev.cmn.web;

import egovframework.rte.ptl.mvc.tags.ui.pagination.AbstractPaginationRenderer;


import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

/**
 * @Class Name : NtisImgPaginationRenderer
 * @Description : NtisImgPaginationRenderer Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2016-09-06    태장혁         최초생성
 *
 * @author 개발팀
 * @since 2016-09-06
 * @version 1.0
 * @see
 *
 */
public class NtisImgPaginationRenderer extends AbstractPaginationRenderer implements ServletContextAware{

	private ServletContext servletContext;

	public NtisImgPaginationRenderer() {
		// no-op
	}

	/**
	* PaginationRenderer
	*
	* @see 개발프레임웍크 실행환경 개발팀
	*/
	public void initVariables() {
		
		firstPageLabel    = "<a href=\"#\" class=\"pre\" onclick=\"{0}({1}); return false;\">" + "처음</a>&#160;";
		previousPageLabel = "<a href=\"#\" class=\"pre\" onclick=\"{0}({1}); return false;\">" + "이전</a>&#160;";
		
		currentPageLabel = "<strong class=\"on\">{0}</strong>&#160;";
		otherPageLabel   = "<a href=\"#\" onclick=\"{0}({1}); return false;\">{2}</a>";
		
		
		nextPageLabel = "<a href=\"#\" class=\"next\" onclick=\"{0}({1}); return false;\">" + "다음</a>&#160;";
		lastPageLabel = "<a href=\"#\" class=\"next\" onclick=\"{0}({1}); return false;\">" + "끝</a>&#160;";
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		initVariables();
	}
}
