package icss.util;

import java.util.ArrayList;

public class ShuduUtil {
	//��ȡһ�����ȱ���Ϊ81���ַ�����ת����9*9int����
	public int[][] readMapDAO(String maps){
		char[] charmap = maps.toCharArray();
		int[][] map = new int[9][9]; 
		for(int i = 0; i < 9;i++) {
			for(int j = 0; j < 9 ;j++) {
				map[i][j] = charmap[i*9+j]-'0';
			}
		}
		return map;
	}
	//��ȡһ���Զ��ŷָ����ַ�����ת����9*9int����
	public int[][] readMap1DAO(String maps){
		String[] stringMap = maps.split(",");
		int[][] map = new int[9][9]; 
		for(int i = 0; i < 9;i++) {
			for(int j = 0; j < 9 ;j++) {
				map[i][j] = Integer.parseInt(stringMap[i*9+j]);
			}
		}
		return map;
	}
	//��ȡһ��map,ת���ɳ���Ϊ81���ַ���
	public String readStringDAO(int[][] map) {
		String maps = "";
		for(int i = 0; i < 9;i++) {
			for(int j = 0; j < 9 ;j++) {
				Integer k = map[i][j];
				maps = maps.concat(k.toString());
			}
		}
		return maps;
	}
	//��ȡһ��map,ת�����Զ��ŷָ���ַ���
	public String readString1DAO(int[][] map) {
		String maps = "";
		for(int i = 0; i < 9;i++) {
			for(int j = 0; j < 9 ;j++) {
				Integer k = map[i][j];
				if(maps == "") {
					maps = maps.concat(k.toString());
				}else {
					maps = maps.concat(","+k.toString());
				}			
			}
		}
		return maps;
	}
	//���������Ƿ������д
	public boolean rightNumberDAO(int num,int mapi,int mapj,int[][]map) {
		for(int i = 0; i < 9; i++) {
			if(num == map[i][mapj]) {
				return false;
			}
		}
		for(int j = 0; j < 9; j++) {
			if(num == map[mapi][j]) {
				return false;
			}
		}
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(mapi/3 == i/3 && mapj/3 == j/3 && num == map[i][j] && !(mapi == i && mapj == j)) {
					return false;
				}
			}
		}
		return true;
	}
	//���������Ƿ������д���ɣ�
	public boolean rightNumber1DAO(int num,int mapi,int mapj,int[][]map) {	
		for(int i = 0; i < 9; i++) {
			if(num == map[i][mapj]) {
				return false;
			}
		}
		for(int j = 0; j < 9; j++) {
			if(num == map[mapi][j]) {
				return false;
			}
		}
		if(mapi < 3) {
			if(mapj <3) {
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						if(num == map[i][j]) {
							return false;
						}
					}					
				}
			}else if(mapj < 6 ) {
				for(int i = 0; i < 3; i++) {
					for(int j = 3; j < 6; j++) {
						if(num == map[i][j]) {
							return false;
						}
					}					
				}
			}else {
				for(int i = 0; i < 3; i++) {
					for(int j = 6; j < 9; j++) {
						if(num == map[i][j]) {
							return false;
						}
					}					
				}
			}
		}else if(mapi < 6){
			if(mapj <3) {
				for(int i = 3; i < 6; i++) {
					for(int j = 0; j < 3; j++) {
						if(num == map[i][j]) {
							return false;
						}
					}					
				}
			}else if(mapj < 6 ) {
				for(int i = 3; i < 6; i++) {
					for(int j = 3; j < 6; j++) {
						if(num == map[i][j]) {
							return false;
						}
					}					
				}
			}else {
				for(int i = 3; i < 6; i++) {
					for(int j = 6; j < 9; j++) {
						if(num == map[i][j]) {
							return false;
						}
					}					
				}
			}
		}else {
			if(mapj <3) {
				for(int i = 6; i < 9; i++) {
					for(int j = 0; j < 3; j++) {
						if(num == map[i][j]) {
							return false;
						}
					}					
				}
			}else if(mapj < 6 ) {
				for(int i = 6; i < 9; i++) {
					for(int j = 3; j < 6; j++) {
						if(num == map[i][j]) {
							return false;
						}
					}					
				}
			}else {
				for(int i = 6; i < 9; i++) {
					for(int j = 6; j < 9; j++) {
						if(num == map[i][j]) {
							return false;
						}
					}					
				}
			}
		}
		return true;
	}
	
	//��ȡ������дλ�õ�ArrayList
	public ArrayList<Integer> locationDAO(int[][] map){
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(map[i][j] == 0) {
					al.add(i*9+j);
				}
			}
		}
		return al;
	}
	//���λ�ȡ������дλ�õ�ArrayList 
	public ArrayList<Integer> locationSnakeDAO(int[][] map){
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i = 0; i < 9; i++) {
			if(i%2 == 0) {
				for(int j = 0; j < 9; j++) {
					if(map[i][j] != 0) {
						al.add(i*9+j);
					}
				}
			}else {
				for(int j = 8; j >= 0; j--) {
					if(map[i][j] != 0) {
						al.add(i*9+j);
					}
				}
			}
			
		}
		return al;
	}
	//������д��numֵ����int[][] map��
	public int[][] insertDAO(int num,int location,int[][] map){
		int mapi = location/9;
		int mapj = location%9;
		map[mapi][mapj] = num;
		return map;
	}
	
	//����locationλ�õ���ֵ��Ϊ0
	public int[][] resetDAO(int location,int[][]map) {
		int mapi = location / 9;
		int mapj = location % 9;
		map[mapi][mapj] = 0;
		return map;
	}
	//���������ڣ�0��1��2���������н���
	public int[][] changeInRowDAO(int row,int row1,int row2,int[][] map){
		int m = row*3 + row1;
		int n = row*3 + row2;
		int temp = 0;
		for(int j = 0; j < 9; j++) {
			temp = map[m][j];
			map[m][j] = map[n][j];
			map[n][j] = temp;
		}	
		return map;
	}
	//���������ڣ�0��1��2���������н���
	public int[][] changeInColDAO(int col,int col1,int col2,int[][] map){
		int m = col*3 + col1;
		int n = col*3 + col2;
		int temp = 0;
		for(int i = 0; i < 9; i++) {
			temp = map[i][m];
			map[i][m] = map[i][n];
			map[i][n] = temp;
		}	
		return map;
	}
	//����������֮�佻��
	public int[][] changeRowDAO(int row1,int row2,int[][] map){
		int m = row1*3;
		int n = row2*3;
		int temp = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				temp = map[m+i][j];
				map[m+i][j] = map[n+i][j];
				map[n+i][j] = temp;
			}
		}
		return map;		
	}
	//����������֮�佻��
	public int[][] changeColDAO(int col1,int col2,int[][] map){
		int m = col1*3;
		int n = col2*3;
		int temp = 0;
		for(int j = 0; j < 3; j++) {
			for(int i = 0; i < 9; i++) {
				temp = map[i][m+j];
				map[i][m+j] = map[i][n+j];
				map[i][n+j] = temp;
			}
		}
		return map;		
	}
	//������������֮�佻��
	public int[][] changeNumDAO(int m,int n,int[][] map){
		for(int i = 0; i < 9;i++) {
			for(int j = 0; j < 9 ;j++) {
				if(map[i][j] == m) {
					map[i][j] = n;
				}else if(map[i][j] == n){
					map[i][j] = m;
				}	
			}
		}
		return map;
	}
}
