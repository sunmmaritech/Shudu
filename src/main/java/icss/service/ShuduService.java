package icss.service;


import icss.util.ShuduUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ShuduService {
	//ͨ��RightNumberDAO���صĲ���ֵ�����ص�ǰλ�ÿ�����д����������
	ShuduUtil sdu = new ShuduUtil();
	//��ȡ��ǰλ�ÿ���д���ֵļ���;
	public ArrayList<Integer> rightNumberService(int location,int[][] map){
		ArrayList<Integer> al = new ArrayList<Integer>();
		int mapi = location/9;
		int mapj = location%9;
		boolean flag = false;
		for(int num = 1; num <= 9; num++) {
			flag = sdu.rightNumberDAO(num, mapi, mapj, map);
			if(flag) {
				al.add(num);
			}
		}
		return al;	
	}
	
	//��ȡһ�����ȱ���Ϊ81���ַ�����ת����9*9int����
	public int[][] readMapService(String maps){
		return sdu.readMapDAO(maps);
	}
	// -- 
	public int[][] readMap1Service(String maps){
		return sdu.readMap1DAO(maps);
	}
	//��ȡһ��map,ת���ɳ���Ϊ81���ַ���
	public String readStringService(int[][] map) {
		return sdu.readStringDAO(map);
	}
	//--
	public String readString1Service(int[][] map) {
		return sdu.readString1DAO(map);
	}
	//��ȡ������дλ�õ�ArrayList
	public ArrayList<Integer> locationService(int[][] map){
		return sdu.locationDAO(map);
	}
	
	//���λ�ȡ������дλ�õ�ArrayList
	public ArrayList<Integer> locationSnakeService(int[][] map){
		return sdu.locationSnakeDAO(map);
	}
	
	//������д��numֵ����int[][] map��
	public int[][] insertService(int num,int location,int[][] map){
		return sdu.insertDAO(num, location, map);
	}
	
	//����locationλ�õ���ֵ��Ϊ0
	public int[][] resetService(int location,int[][]map) {
		return sdu.resetDAO(location, map);
	}
	//����һ��map
	public int[][] copyMap(int[][] map){
		int[][] map1;
		map1 = new int[9][9];
		for(int m = 0; m < 9;m++)
			for (int n = 0; n < 9; n++) {
				map1[m][n] = map[m][n];
			}
		return map1;
	}
	//��� ���ı�ԭmap
	public boolean tryGetSolution(int[][] map) {
		int[][] map1 = new int[9][9];
		for(int m = 0; m < 9;m++) {
			for(int n = 0; n < 9 ;n++) {
				map1[m][n] = map[m][n];
			}
		}
		return getSolution(map1);
	}
	//���
	public boolean getSolution(int[][] map) {
		ArrayList<Integer> lcal = locationService(map);
		//ʵ����һ������Ϊ���ϵļ��ϣ����ڴ洢ÿ��λ�ã�location���пɹ�ѡ�����������д���ֵļ���(able al)
		ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
		int i = 0;
		int location = 0;
		//����ǰ������д��λ������i(��ǰlocation=lcal.get(i))���ڻ����lcal.size()��˵��������д���
		while(i < lcal.size()) {
			//����ǰλ��i==all.size()��˵����ǰλ���ǵ�һ����д���ݣ�δ�洢�������Ŀ���д����
			if(i == all.size()) {
				//���ɵ�ǰλ������i��location
				location = lcal.get(i);
				//��ȡ��ǰlocationλ�������п���д�����֣��洢�ڼ���rnal(right number al)
				ArrayList<Integer> rnal = rightNumberService(location, map);
				//���˼���sizeΪ0��˵��û�����ֿ��Ա���д��˵����һλ������д����
				if(rnal.size() == 0) {
					if(i == 0) {
						return false;
					}
					//������һ��λ��
					i--;
					location = lcal.get(i);
					//����һ��λ��֮ǰ�����������Ϊ0
					map = resetService(location, map);
				}else {
					//��rnal���ϲ�Ϊ�գ�˵������һ�����ֿ��Ա���д����ȡ����д�ĵ�һ������
					int num = rnal.get(0);				
					//���������뵱ǰlocation�У�����һ���µ�map
					map = insertService(num, location, map);
					//������д�������Ƴ����������д���ֵļ��ϴ��뱸ѡ������
					rnal.remove(0);
					all.add(rnal);
					//������һλ��
					i++;
				}
			//����ǰλ��i<all.size()(ʵ����iֻ�����������i����all.size��i����all.size-1)
			//˵����ǰλ�����Ѿ���д�����ݲ�����Ϊ0����������������ּ��ϣ�ֱ�Ӵӱ��ü����е���������������
			}else {
				location = lcal.get(i);
				//��ȡ���ü����е�ǰλ�õĿ�ѡ����
				ArrayList<Integer> rnal = all.get(i);
				if(rnal.size() == 0) {
					if(i == 0) {
						return false;
					}
					//�����ѡ����Ϊ�գ�˵����λ�����޿������֣�������ռ����Ƴ�������������һλ����������Ϊ0
					all.remove(i);
					i--;
					location = lcal.get(i);		
					map = resetService(location, map);					
				}else {
					//����п�ѡ���֣���ȡ��һ����ѡ��������
					int num = rnal.get(0);
					map = insertService(num, location, map);
					//�Ƴ�����Ŀ�ѡ����
					rnal.remove(0);
					//��ʣ���ѡ�������´��뱸�����ּ���
					all.remove(i);
					all.add(rnal);
					//������һλ��
					i++;
				}
			}		
		}
		return true;
	}
	
	public int[][] createRandomMap(){
		int[][] map = new int[9][9];
		int i = 0;
		int j = 0;
		int location = 0;	
		for(i = 0; i < 9; i++) {
			for(j = 0; j < 9; j++) {
				map[i][j] = 0;
			}
		}
		//
		ArrayList<Integer> lcal = locationService(map);
		ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
		i = 0;
		while(i < lcal.size()) {
			//����ǰλ��i==all.size()��˵����ǰλ���ǵ�һ����д���ݣ�δ�洢�������Ŀ���д����
			if(i == all.size()) {
				//���ɵ�ǰλ������i��location
				location = lcal.get(i);
				//��ȡ��ǰlocationλ�������п���д�����֣��洢�ڼ���rnal(right number al)
				ArrayList<Integer> rnal = rightNumberService(location, map);
				//���˼���sizeΪ0��˵��û�����ֿ��Ա���д��˵����һλ������д����
				if(rnal.size() == 0) {
					//������һ��λ��
					i--;
					location = lcal.get(i);		
					//����һ��λ��֮ǰ�����������Ϊ0
					map = resetService(location, map);
				}else {
					//���Ҽ���
					Collections.shuffle(rnal);
					//��ȡ����д�ĵ�һ������
					int num = rnal.get(0);				
					//���������뵱ǰlocation�У�����һ���µ�map
					map = insertService(num, location, map);
					//������д�������Ƴ����������д���ֵļ��ϴ��뱸ѡ������
					rnal.remove(0);
					all.add(rnal);
					//������һλ��
					i++;
				}
			}else {
				location = lcal.get(i);
				//��ȡ���ü����е�ǰλ�õĿ�ѡ����
				ArrayList<Integer> rnal = all.get(i);
				if(rnal.size() == 0) {
					//�����ѡ����Ϊ�գ�˵����λ�����޿������֣�������ռ����Ƴ�������������һλ����������Ϊ0
					all.remove(i);
					i--;
					location = lcal.get(i);		
					map = resetService(location, map);					
				}else {
					//����п�ѡ���֣���ȡ��һ����ѡ��������
					int num = rnal.get(0);
					map = insertService(num, location, map);
					//�Ƴ�����Ŀ�ѡ����
					rnal.remove(0);
					//��ʣ���ѡ�������´��뱸�����ּ���
					all.remove(i);
					all.add(rnal);
					//������һλ��
					i++;
				}		
			}
		}
		return map;
	}
	
	//�������
	public void printMap(int[][] map) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(map[i][j]+"  |  ");
			}
			System.out.println();
			System.out.println("��������������������������������������������������������������������������������������������������������");		
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	//�����µ���Ŀ
	public int[][] createNewMap(int[][] map){
		ArrayList<Integer> rnal = null;
		int i = 0;
		int lastNum = 0;
		int location = 0;
		int mapi = 0;
		int mapj = 0;
		int j = 0;
		boolean flag = false;
		ArrayList<Integer> snlc = locationSnakeService(map);
		i = 0;
		while(i < snlc.size()) {
			location = snlc.get(i);
			mapi = location/9;
			mapj = location%9;
			lastNum = map[mapi][mapj];
			map[mapi][mapj] = 0;
 			rnal = rightNumberService(location, map);
 			if(rnal.size() == 1) {
				i++;
			}else {
				flag = false;
				for (j = 0; j < rnal.size() ; j++) {
					if(rnal.get(j) == lastNum) {
						rnal.remove(j);
					}
				}
				for (j = 0; j < rnal.size() ; j++) {
					map[mapi][mapj] = rnal.get(j);
					if(tryGetSolution(map) == true) {
						flag = true;
						break;
					}
				}
				if(flag == true) {
					map[mapi][mapj] = lastNum;
					i++;
				}else {
					map[mapi][mapj] = 0;
					i++;
				}
			}
		}
		System.out.println("success");
		return map;	
	}
	//�任����
	public int[][] changeMapService(int[][] map){
		Random r = new Random();
		int i = 0;
		int j = 0;
		int k = 0;
		for(k = 0; k < 3; k++) {
			i = r.nextInt(3);
			j = r.nextInt(3);
			if(i != j)
				sdu.changeInRowDAO(k, i, j, map);
		}
		for(k = 0; k < 3; k++) {
			i = r.nextInt(3);
			j = r.nextInt(3);
			if(i != j)
				sdu.changeInColDAO(k, i, j, map);
		}
		i = r.nextInt(3);
		j = r.nextInt(3);
		if(i != j)
			sdu.changeRowDAO(i, j, map);
		i = r.nextInt(3);
		j = r.nextInt(3);
		if(i != j)
			sdu.changeColDAO(i, j, map);
		for(k = 0; k < 3; k++) {
			i = r.nextInt(9)+1;
			j = r.nextInt(9)+1;
			if(i != j)
				sdu.changeNumDAO(i, j, map);
		}
		return map;
	}
	//�жϵ�ǰmap�Ƿ����Ҫ��
	public boolean testMap(int[][] map) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				int flag = map[i][j];
				if(flag != 0) {
					if(sdu.rightNumberDAO(map[i][j], i, j, map) == false)
						return false;
				}
			}
		}
		return true;
	}
	//��ȡ0�ĸ���
	public int getZeroNum(int[][] map) {
		int m = 0;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(map[i][j] == 0) {
					m++;
				}
			}
		}
		return m;
	}
	//����һ���������п���д��λ��
	public ArrayList<Integer> getNumLocation(int num,int[][] map){
		ArrayList<Integer> lcal = new ArrayList<Integer>();
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(sdu.rightNumberDAO(num, i, j, map) == true) {
					lcal.add(i*9+j);
				}
			}
		}
		return lcal;
	}
}
