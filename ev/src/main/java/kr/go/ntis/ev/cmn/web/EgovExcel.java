/*
 * Copyright 2011 MOPAS(Ministry of Public Administration and Security).

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

import java.awt.Font;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;

import org.springframework.web.servlet.view.document.AbstractExcelView;


/**
 * 엑셀 생성
 * @author Administrator
 *
 */
public class EgovExcel extends AbstractExcelView {

	/**
	 * 엑셀파일을 설정하고 생성한다.
	 * @param model
	 * @param wb
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@Override
	protected void buildExcelDocument(
			Map map,
			HSSFWorkbook wb, 
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		
		String excelFileName  = (String)map.get("excelFileName");
		String excelSheetName = (String)map.get("excelSheetName");
		String excelTitle          = (String)map.get("excelTitle");
		
		String[] headerList = (String[])map.get("headerList");
		String[] columnList = (String[])map.get("columnList");
		List bodyList = (List) map.get("bodyList");
		
		
		// Cell 스타일 설정
		CellStyle headerStyle = wb.createCellStyle();
		
		HSSFFont hssFont = wb.createFont();
		hssFont.setFontName("맑은 고딕");
		
		headerStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		hssFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		hssFont.setColor(HSSFColor.BLACK.index);
		
		headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);   
		headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);   
		headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);   
		headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		headerStyle.setFont(hssFont);
		
		CellStyle defaultStyle = wb.createCellStyle();
		
		defaultStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		defaultStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		defaultStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		defaultStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);

		
		
		
		// 시트 생성
		HSSFSheet sheet = wb.createSheet(excelSheetName);
		sheet.setDefaultColumnWidth(30);
		//sheet.setDefaultRowHeight((short)400);
		
		
		// 타이틀 설정
		HSSFRow sheetDescription = sheet.createRow(0);
		sheetDescription.createCell(0).setCellValue(excelTitle);
		sheetDescription.getCell(0).setCellStyle(headerStyle);
	    sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headerList.length-1));
	    
		
		
	    HSSFCell cell = null;		
		
	    // put text in first cell
		//cell = getCell(sheet, 0, 0);
		
 
		// 헤더 생성
		for(int i=0; i<headerList.length; i++)
		{
			setText(getCell(sheet, 1, i), headerList[i]);
			getCell(sheet, 1, i).setCellStyle(headerStyle);
			
		}
		
		// 내용 생성
		Map excelMap;
			
		for (int i = 0; i < bodyList.size(); i++) {
				excelMap = (Map)bodyList.get(i);
 
				for(int j=0; j<columnList.length; j++)
				{
					cell = getCell(sheet, 2 + i, j);
					
					if("null".equals(String.valueOf(excelMap.get(columnList[j]))))
					{
						setText(cell, "" );
						cell.setCellStyle(defaultStyle);
					}else{
						setText(cell, String.valueOf(excelMap.get(columnList[j])) );
						cell.setCellStyle(defaultStyle);
					}
				}
		}


		response.setContentType("application/x-msdownload; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + java.net.URLEncoder.encode(excelFileName, "UTF-8") + ".xls\"");
			 
		
		
		
	}

}
