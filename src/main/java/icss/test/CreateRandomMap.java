package icss.test;


import icss.service.ShuduService;

import java.util.ArrayList;
import java.util.Collections;

public class CreateRandomMap {
	public static void main(String[] args) {
		//����9*9�ĳ�ʼmap
		ShuduService sds = new ShuduService();
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
		ArrayList<Integer> lcal = sds.locationService(map);
		ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
		i = 0;
		while(i < lcal.size()) {
			//����ǰλ��i==all.size()��˵����ǰλ���ǵ�һ����д���ݣ�δ�洢�������Ŀ���д����
			if(i == all.size()) {
				//���ɵ�ǰλ������i��location
				location = lcal.get(i);
				//��ȡ��ǰlocationλ�������п���д�����֣��洢�ڼ���rnal(right number al)
				ArrayList<Integer> rnal = sds.rightNumberService(location, map);
				//���˼���sizeΪ0��˵��û�����ֿ��Ա���д��˵����һλ������д����
				if(rnal.size() == 0) {
					//������һ��λ��
					i--;
					location = lcal.get(i);		
					//����һ��λ��֮ǰ�����������Ϊ0
					map = sds.resetService(location, map);
				}else {
					//���Ҽ���
					Collections.shuffle(rnal);
					//��ȡ����д�ĵ�һ������
					int num = rnal.get(0);				
					//���������뵱ǰlocation�У�����һ���µ�map
					map = sds.insertService(num, location, map);
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
					map = sds.resetService(location, map);					
				}else {
					//����п�ѡ���֣���ȡ��һ����ѡ��������
					int num = rnal.get(0);
					map = sds.insertService(num, location, map);
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
		for(i = 0; i < 9; i++) {
			for(j = 0; j < 9; j++) {
				System.out.print(map[i][j]+"  |  ");
			}
			System.out.println();
			System.out.println("��������������������������������������������������������������������������������������������������������");		
		}
		
		
		
		
		
		
		
		
		
		
		
//		ShuduService sds = new ShuduService();
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("�����������ַ���");
//		String maps = scanner.next();
//		//һ���������� 
//		//String maps = "030000001800005070240000300007010050050900200009030046000000025004000080000000900";
//		//���ַ�����ȡ9*9��ά����map
//		int[][] map = sds.readMapService(maps);		
//		//����map�п���д����λ�ã���ԭʼ����Ϊ0��λ�ã����뼯��lacl(location al)
//		ArrayList<Integer> lcal = sds.locationService(map);
//		//ʵ����һ������Ϊ���ϵļ��ϣ����ڴ洢ÿ��λ�ã�location���пɹ�ѡ�����������д���ֵļ���(able al)
//		ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
//		int i = 0;
//		int location = 0;
//		//����ǰ������д��λ������i(��ǰlocation=lcal.get(i))���ڻ����lcal.size()��˵��������д���
//		while(i < lcal.size()) {
//			//����ǰλ��i==all.size()��˵����ǰλ���ǵ�һ����д���ݣ�δ�洢�������Ŀ���д����
//			if(i == all.size()) {
//				//���ɵ�ǰλ������i��location
//				location = lcal.get(i);
//				//��ȡ��ǰlocationλ�������п���д�����֣��洢�ڼ���rnal(right number al)
//				ArrayList<Integer> rnal = sds.rightNumberService(location, map);
//				//���˼���sizeΪ0��˵��û�����ֿ��Ա���д��˵����һλ������д����
//				if(rnal.size() == 0) {	
//					//������һ��λ��
//					i--;
//					location = lcal.get(i);
//					//����һ��λ��֮ǰ�����������Ϊ0
//					map = sds.resetService(location, map);
//				}else {
//					//��rnal���ϲ�Ϊ�գ�˵������һ�����ֿ��Ա���д����ȡ����д�ĵ�һ������
//					int num = rnal.get(0);				
//					//���������뵱ǰlocation�У�����һ���µ�map
//					map = sds.insertService(num, location, map);
//					//������д�������Ƴ����������д���ֵļ��ϴ��뱸ѡ������
//					rnal.remove(0);
//					all.add(rnal);
//					//������һλ��
//					i++;
//				}
//			//����ǰλ��i<all.size()(ʵ����iֻ�����������i����all.size��i����all.size-1)
//			//˵����ǰλ�����Ѿ���д�����ݲ�����Ϊ0����������������ּ��ϣ�ֱ�Ӵӱ��ü����е���������������
//			}else {
//				location = lcal.get(i);
//				//��ȡ���ü����е�ǰλ�õĿ�ѡ����
//				ArrayList<Integer> rnal = all.get(i);
//				if(rnal.size() == 0) {
//					//�����ѡ����Ϊ�գ�˵����λ�����޿������֣�������ռ����Ƴ�������������һλ����������Ϊ0
//					all.remove(i);
//					i--;
//					location = lcal.get(i);		
//					map = sds.resetService(location, map);					
//				}else {
//					//����п�ѡ���֣���ȡ��һ����ѡ��������
//					int num = rnal.get(0);
//					map = sds.insertService(num, location, map);
//					//�Ƴ�����Ŀ�ѡ����
//					rnal.remove(0);
//					//��ʣ���ѡ�������´��뱸�����ּ���
//					all.remove(i);
//					all.add(rnal);
//					//������һλ��
//					i++;
//				}
//			}		
//		}
//		//�������
//		for(i = 0; i < 9; i++) {
//			for(int j = 0; j < 9; j++) {
//				System.out.print(map[i][j]+"  |  ");
//			}
//			System.out.println();
//			System.out.println("��������������������������������������������������������������������������������������������������������");		
//		}
//		scanner.close();
	}
}
