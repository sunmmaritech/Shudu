package icss.test;


import icss.service.ShuduService;

public class Test {

	public static void main(String[] args) {
		ShuduService sds = new ShuduService();
		//�����⣬�������
//		int[][] map = sds.createRandomMap();
//		int[][] map1 = sds.copyMap(map);
//		sds.createNewMap(map1);
//		int[][] map2 = sds.copyMap(map1);
//		sds.getSolution(map2);
//		sds.printMap(map);
//		System.out.println();
//		System.out.println();
//		sds.printMap(map1);
//		System.out.println();
//		System.out.println();
//		System.out.println(sds.readStringService(map2));
//		sds.printMap(map2);
		
		
		int[][] map = sds.createRandomMap();
		sds.printMap(map);
		sds.createNewMap(map);
		sds.printMap(map);
		String maps = sds.readString1Service(map);
		System.out.println(maps);
		int[][] map1 = sds.readMap1Service(maps);
		sds.printMap(map1);
		/*sds.printMap(map);
		sds.changeMapService(map);
		sds.printMap(map);
		sds.getSolution(map);
		sds.printMap(map);*/
		
		
		
	}

}
