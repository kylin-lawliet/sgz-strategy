package com.blackcat.service;

import com.blackcat.vo.LineupExcelInfo;
import com.blackcat.vo.LineupGeneralTacticsExcelInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Title
 * @Description
 * @author zhanghui
 * @date 2020年12月24日 15:21
 * @version V1.0
 * @see
 * @since V1.0
 */
public interface PullDataService {

	String pullData() throws IOException;

	void saveLineupInfo(List<LineupExcelInfo> lineupList,List<LineupGeneralTacticsExcelInfo> lineupGTList) throws IOException;

}
