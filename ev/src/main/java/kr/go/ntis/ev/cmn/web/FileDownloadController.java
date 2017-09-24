package kr.go.ntis.ev.cmn.web;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 파일 다운로드 컨트롤
 * @author Administrator
 *
 */

@Controller
public class FileDownloadController {
	
	// 로그
		private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/**
	 * 첨부파일 다운로드
	 * @param requestedFilePath
	 * @param requestedFile
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/FileDownload.do")
	public void downloadAttFile(
			@RequestParam(value = "orgFileNm")       String orgFileNm,
			@RequestParam(value = "fileNm")       String fileNm,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		
		
		String mimeType = "application/x-msdownload; charset=utf-8";
		
		String filePath = "/data/home/ev/upload_file/"; 

		File file = new File(filePath+orgFileNm);
		int fileSize = (int)file.length();
		
		
		if (fileSize > 0) {
			
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
			
			try{
				response.setBufferSize(fileSize);
				response.setContentType(mimeType);
				response.setHeader("Content-Disposition", "attachment; filename=\"" + java.net.URLEncoder.encode(fileNm,"UTF-8") + "\"");
				
				response.setContentLength(fileSize);
				
				FileCopyUtils.copy(in, response.getOutputStream());
				
				
			} catch(FileNotFoundException fnfe){
				
				PrintWriter printwriter = response.getWriter();
				printwriter.println("<html>");
				printwriter.println("<br><br><br><h2>Could not get file name:<br>" + fileNm + "</h2>");
				printwriter.println("<br><br><br><center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
				printwriter.println("<br><br><br>&copy; webAccess");
				printwriter.println("</html>");
				printwriter.flush();
				printwriter.close();
			
			} catch(IOException fnfe){
				
				PrintWriter printwriter = response.getWriter();
				printwriter.println("<html>");
				printwriter.println("<br><br><br><h2>Could not get file name:<br>" + fileNm + "</h2>");
				printwriter.println("<br><br><br><center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
				printwriter.println("<br><br><br>&copy; webAccess");
				printwriter.println("</html>");
				printwriter.flush();
				printwriter.close();
				
			}finally{
				 try
		          {
					 if(in != null)
					 {
						 in.close();
						 in = null;
					 }
		          } catch(IOException e){
		        	  LOGGER.debug("IOException");
		          }
				
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}
			
		}
		
	}
	
	
}
