package edu0427.spring.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import edu0427.common.page.PaginationResult;
import edu0427.spring.vo.ClubInfo;
import edu0427.spring.vo.NationInfo;
import edu0427.spring.vo.PlayerInfo;

public interface PlayerService {
	Integer getTotalCount();
	
	PaginationResult<List<PlayerInfo>> getPlayerPage(Integer pageIndex, Integer pageSize);
	
	PlayerInfo getPlayerById(Integer pid);
	
	NationInfo getNationById(Integer nid);
	
	ClubInfo getClubById(Integer cid);
	
	List<NationInfo> getAllNation();
	
	List<ClubInfo> getAllClub();
	
	JSONArray getJsonAge();
	
	JSONObject getAvgOfOverallByNation();
}
