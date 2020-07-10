package edu0427.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import edu0427.common.page.Pagination;
import edu0427.common.page.PaginationResult;
import edu0427.spring.dao.mapper.PlayerMapper;
import edu0427.spring.init.initInfo;
import edu0427.spring.service.PlayerService;
import edu0427.spring.vo.ChartData;
import edu0427.spring.vo.ClubInfo;
import edu0427.spring.vo.NationInfo;
import edu0427.spring.vo.PlayerInfo;

@Component
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerMapper playerMapper;

	@Override
	public Integer getTotalCount() {
		// 鑾峰彇鎵�鏈夌悆鍛樻暟閲�
		return playerMapper.getTotalCount();
	}

	@Override
	public PaginationResult<List<PlayerInfo>> getPlayerPage(Integer pageIndex, Integer pageSize) {
		// 获取分页的球员列表信息
		Pagination pagination = new Pagination(pageIndex, pageSize);
		pagination.setTotalCount(getTotalCount());
		// 查询一次，得到10个结果
		List<PlayerInfo> list = playerMapper.getPlayers(pagination.getCursor(), pagination.getOffset());
		/*为了得到每一个数据而去遍历查到的集合
		缺点：增加查询时间，增加了20倍的查询时长*/
		for (PlayerInfo player : list) {
			// 循环查询俱乐部和国家的信息
		    //player.setClub(playerMapper.getClubById(player.getCid()));
			//player.setNation(playerMapper.getNationById(player.getNid()));
			player.setClub(initInfo.club.get(player.getCid()));
			player.setNation(initInfo.nation.get(player.getNid()));
		}

		pagination.setCurrentPageCount(list.size());

		PaginationResult<List<PlayerInfo>> result = new PaginationResult<List<PlayerInfo>>(pagination, list);

		return result;
	}

	@Override
	public NationInfo getNationById(Integer nid) {
		// TODO 閫氳繃鍥藉ID鑾峰彇鍥藉淇℃伅
		return null;
	}

	@Override
	public ClubInfo getClubById(Integer cid) {
		// TODO 鑾峰彇淇变箰閮ㄤ俊鎭�
		return null;
	}

	@Override
	public List<NationInfo> getAllNation() {
		// TODO 鑾峰彇鎵�鏈夊浗瀹朵俊鎭�
		return null;
	}

	@Override
	public List<ClubInfo> getAllClub() {
		// TODO 鑾峰彇鎵�鏈変勘涔愰儴淇℃伅
		return null;
	}

	@Override
	public PlayerInfo getPlayerById(Integer pid) {
		return playerMapper.getPlayerById(pid);
	}

	@Override
	public JSONArray getJsonAge() {
		List<ChartData> list = playerMapper.getDataOfAge();
		JSONArray array = new JSONArray();
		for (ChartData data : list) {
			JSONObject json = new JSONObject();
			json.put("value", data.getValue());
			json.put("name", data.getKey());
			array.add(json);
		}

		return array;
	}

	@Override
	public JSONObject getAvgOfOverallByNation() {
		JSONObject result = new JSONObject();
		List<ChartData> list = playerMapper.getAvgOfOverallByNation();
		JSONArray xAxis = new JSONArray();
		JSONArray series = new JSONArray();
		for (ChartData data : list) {
			xAxis.add(data.getKey());
			series.add(data.getValue());
		}
		result.put("xAxis", xAxis);
		result.put("series", series);
		return result;
	}

}
