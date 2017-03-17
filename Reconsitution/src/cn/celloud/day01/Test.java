package cn.celloud.day01;

/**
 * 有一个方法fun，它有一个参数 n（数字类型），其返回值是一个数组，
 * 该数组内是 n个随机且不重复的整数，且整数取值范围是 [2, 32]。
 * 1、可用性
 * 2、健壮性：即最基本的兼容性处理、边界处理，异常处理、用户输入校验。
 * 		很多时候，需求方不会明确告诉你这些逻辑怎么处理，但并不意味着你不需要处理。
 * 		健壮的程序，一定会将这些兼容性、边界、异常、输入做处理，以保证核心功能的正确输出。
 * 		当然，如果你的代码没有任何输入并不考虑兼容性（可能吗？）或者仅仅是内部函数，那这一步要求可以降低，并不意味着你可以完全不做。
 */
import java.util.ArrayList;
import java.util.Random;

public class Test {
	static int[] fun(int n){
		/*
		 * n的值是1到31之间的整数
		 */
		if(n>=1 && n<=31){
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
		return null;
	}
	public static void main(String[] args) {
		int[] fun = fun(32);
		if(fun!=null){
			for (int i : fun) {
				System.out.print(i+" ");
			}
		}else{
			System.out.println("n的取值范围是1-31");
		}
	}
}
