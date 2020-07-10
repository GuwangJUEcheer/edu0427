package edu0427.spring.init;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu0427.spring.dao.mapper.PlayerMapper;
import edu0427.spring.vo.ClubInfo;
import edu0427.spring.vo.NationInfo;
@Component   //用spring来管理这个类
public class initInfo implements InitializingBean{
	@Autowired //使用Spring自我管理的标签
	private PlayerMapper playerMapper;
	//创建了两个空的容器
public static Map<Integer,ClubInfo> club=new HashMap<Integer,ClubInfo>();
public static Map<Integer,NationInfo> nation=new HashMap<Integer,NationInfo>();
@Override
public void afterPropertiesSet() throws Exception{
 	//拿到所有俱乐部信息
	initClub();
	initNation();
	
}
private void initNation() {
	List<NationInfo> nationList=playerMapper.getAllNation();
	for(NationInfo a:nationList) {
		nation.put(a.getNid(),a);
	}
	System.out.println("国籍初始化，数量"+nationList.size());
}
private void initClub() {
	List<ClubInfo> clubList=playerMapper.getAllClub();
	for(ClubInfo c:clubList) {
		club.put(c.getCid(),c);
	}
	System.out.println("俱乐部初始化，数量"+clubList.size());
}
}
