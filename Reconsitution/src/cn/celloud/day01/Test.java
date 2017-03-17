package cn.celloud.day01;

/**
 * 有一个方法fun，它有一个参数 n（数字类型），其返回值是一个数组，
 * 该数组内是 n 个随机且不重复的整数，且整数取值范围是 [2, 32]。
 */
import java.util.ArrayList;
import java.util.Random;

public class Test {
	static int[] fun(int n){
		int result[]= new int[n];
		Random random = new Random();
		int nextInt = 0;
		int count = 0;
		int resultcount = 0;
		ArrayList list = new ArrayList();
		ArrayList resultList = new ArrayList();
		for(int i = 0;;){
			if(count < n){
				nextInt = (int) Math.floor(random.nextInt(31)+2);
				resultList.add(nextInt);
				if(!list.contains(nextInt)){
					list.add(nextInt);
					count++;
					result[i++] = nextInt;
				}
				resultcount++;
			}else{
				break;
			}
		}
		System.out.println("count: "+count + "  resultCount: "+resultcount+" resultList : "+resultList.toString());
		return result;
	}
	public static void main(String[] args) {
		int[] fun = fun(10);
		for (int i : fun) {
			System.out.print(i+" ");
		}
	}
}
