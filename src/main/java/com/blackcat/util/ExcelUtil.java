package com.blackcat.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Title
 * @Description
 * @author zhanghui
 * @date 2020年12月29日 14:29
 * @version V1.0
 * @see
 * @since V1.0
 */
public class ExcelUtil {

	/**
	 * 得到Workbook对象
	 * @param file
	 * @throws IOException
	 */
	public static Workbook getWorkBook(MultipartFile file) throws IOException {
		//这样写  excel 能兼容03和07
		InputStream is = file.getInputStream();
		Workbook hssfWorkbook = null;
		try {
			hssfWorkbook = new HSSFWorkbook(is);
		} catch (Exception ex) {
			is =file.getInputStream();
			hssfWorkbook = new XSSFWorkbook(is);
		}
		return hssfWorkbook;
	}

}
