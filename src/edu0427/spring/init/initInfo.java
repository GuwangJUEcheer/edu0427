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
@Component   //��spring�����������
public class initInfo implements InitializingBean{
	@Autowired //ʹ��Spring���ҹ���ı�ǩ
	private PlayerMapper playerMapper;
	//�����������յ�����
public static Map<Integer,ClubInfo> club=new HashMap<Integer,ClubInfo>();
public static Map<Integer,NationInfo> nation=new HashMap<Integer,NationInfo>();
@Override
public void afterPropertiesSet() throws Exception{
 	//�õ����о��ֲ���Ϣ
	initClub();
	initNation();
	
}
private void initNation() {
	List<NationInfo> nationList=playerMapper.getAllNation();
	for(NationInfo a:nationList) {
		nation.put(a.getNid(),a);
	}
	System.out.println("������ʼ��������"+nationList.size());
}
private void initClub() {
	List<ClubInfo> clubList=playerMapper.getAllClub();
	for(ClubInfo c:clubList) {
		club.put(c.getCid(),c);
	}
	System.out.println("���ֲ���ʼ��������"+clubList.size());
}
}
