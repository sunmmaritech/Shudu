package icss.test;


import icss.service.ShuduService;

import java.util.ArrayList;

public class CreateNewMap {
	public static void main(String[] args) {
		ArrayList<Integer> rnal = null;
		int i = 0;
		int lastNum = 0;
		int location = 0;
		int mapi = 0;
		int mapj = 0;
		int j = 0;
		boolean flag = false;
		ShuduService sds = new ShuduService();
		int[][] map = sds.createRandomMap();
		for(i = 0; i < 9; i++) {
			for(j = 0; j < 9; j++) {
				System.out.print(map[i][j]+"  |  ");
			}
			System.out.println();
			System.out.println("��������������������������������������������������������������������������������������������������������");		
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		ArrayList<Integer> snlc = sds.locationSnakeService(map);
//		System.out.println(snlc.size());
		i = 0;
		while(i < snlc.size()) {
			location = snlc.get(i);
			mapi = location/9;
			mapj = location%9;
			lastNum = map[mapi][mapj];
			map[mapi][mapj] = 0;
 			rnal = sds.rightNumberService(location, map);
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
					ShuduService sds1 = new ShuduService();
					if(sds1.tryGetSolution(map) == true) {
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
		int m = 0;
		for(i = 0; i < 9; i++) {
			for(j = 0; j < 9; j++) {
				if(map[i][j] != 0) 
					m++;
				System.out.print(map[i][j]+"  |  ");
			}
			System.out.println();
			System.out.println("��������������������������������������������������������������������������������������������������������");		
		}
		System.out.println();
		System.out.println(m);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		sds.getSolution(map);
		for(i = 0; i < 9; i++) {
			for(j = 0; j < 9; j++) {
				System.out.print(map[i][j]+"  |  ");
			}
			System.out.println();
			System.out.println("��������������������������������������������������������������������������������������������������������");		
		}
		
	}
}
