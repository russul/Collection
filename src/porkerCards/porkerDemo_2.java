package porkerCards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

/*
 *这是对porkerDemo的改进，使得每个人手里的牌都是有序的
 *思路见具体笔记 ：
 * 
 * 
 */
public class porkerDemo_2 {
	public static void main(String[] args) {
		// 创建牌盒
		HashMap<Integer, String> hm = new HashMap<Integer, String>();

		// 装牌
		String[] colors = { "♠", "♥", "♣", "♦" };
		String[] numbers = { "3", "4", "5", "6", "7", "8", "9", "10",
				"J", "Q", "K" ,"A", "2" };  //斗地主单排顺序
		int x = 0;
		for (String n : numbers) {
			for (String c : colors) {
				hm.put(x++, c.concat(n));
			}
		}
		
		hm.put(x++,"小王");
		hm.put(x++,"大王");
		// System.out.println(hm);

		// 洗牌,这里洗的是牌的索引而不再是牌了，创建arr是为了用public static void shuffle(List<?> list)
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < hm.size(); i++) {
			arr.add(i);
		}

		Collections.shuffle(arr);

		// 发牌，这里也是把牌的索引发给玩家，而不是牌，用TreeSet接受牌的索引，由于TreeSet元素是唯一的，排序的
		TreeSet<Integer> p1 = new TreeSet<Integer>();
		TreeSet<Integer> p2 = new TreeSet<Integer>();
		TreeSet<Integer> p3 = new TreeSet<Integer>();
		TreeSet<Integer> dipai = new TreeSet<Integer>();
		
		

		for (int j = 0; j < arr.size(); j++) {
			if (j >= arr.size() - 3) {
				dipai.add(arr.get(j));
			}
			if (j % 3 == 0) {
				p1.add(arr.get(j));
			} else if (j % 3 == 1) {
				p2.add(arr.get(j));
			} else {
				p3.add(arr.get(j));
			}
		}
		
		//看牌，通过得到的索引再到hashMap里寻找牌
		lookPorkers(hm, p1);
		lookPorkers(hm, p2);
		lookPorkers(hm, p3);
		lookPorkers(hm, dipai);
	}
	
	
	public static void lookPorkers(HashMap<Integer,String> hm, TreeSet<Integer> ts){
		for(Integer i:ts){
			System.out.print(hm.get(i)+" ");
		}
		System.out.println();
	}

}
