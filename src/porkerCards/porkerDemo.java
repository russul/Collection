package porkerCards;

import java.util.ArrayList;

import java.util.Collections;

/*
 * 用集合类工具Collections模拟洗牌(shuffle(List)随机置换集合元素)发牌动作
 * 
 * 
 */
public class porkerDemo {
	public static void main(String[] args) {
		// 创建牌盒
		ArrayList<String> arr = new ArrayList<String>();
		// 装牌，每副扑克54张牌，四个花色，为了添加方便，建立花色和数值两个数组
		String[] colors = { "♠", "♥", "♣", "♦" };
		String[] numbers = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"J", "Q", "K" };

		for (String c : colors) {
			for (String n : numbers) {
				arr.add(c.concat(n));
			}
		}

		arr.add("小王");
		arr.add("大王");
		// System.out.println(arr);
		//

		// 洗牌
		Collections.shuffle(arr);
		// System.out.println(arr);

		// 发牌,给三个人发牌,集合遍历,斗地主
		ArrayList<String> p1 = new ArrayList<String>();
		ArrayList<String> p2 = new ArrayList<String>();
		ArrayList<String> p3 = new ArrayList<String>();
		ArrayList<String> dipai = new ArrayList<String>();

		for (int x = 0; x < arr.size(); x++) {
			if (x >= arr.size() - 3) {
				dipai.add(arr.get(x));
			}
			if (x % 3 == 0) {
				p1.add(arr.get(x));
			} else if (x % 3 == 1) {
				p2.add(arr.get(x));
			} else {
				p3.add(arr.get(x));
			}
		}

		// 看牌
		lookPorker(p1);
		lookPorker(p2);
		lookPorker(p3);
		lookPorker(dipai);

	}

	public static void lookPorker(ArrayList<String> arr) {
		for (String a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
}
/*
 * 这样做的缺点是每个人的牌是没有顺序的，似乎不符合我们真实的情景。
 */