package cn.celloud.day01;

/**
 * 有一个方法fun，它有一个参数 n（数字类型），其返回值是一个数组，
 * 该数组内是 n个随机且不重复的整数，且整数取值范围是 [2, 32]。
 * 1、可用性
 * 2、健壮性：即最基本的兼容性处理、边界处理，异常处理、用户输入校验。
 * 		很多时候，需求方不会明确告诉你这些逻辑怎么处理，但并不意味着你不需要处理。
 * 		健壮的程序，一定会将这些兼容性、边界、异常、输入做处理，以保证核心功能的正确输出。
 * 		当然，如果你的代码没有任何输入并不考虑兼容性（可能吗？）或者仅仅是内部函数，那这一步要求可以降低，并不意味着你可以完全不做。
 * 3、可靠性：尽可能在任何情况下，都返回一个可靠的结果，哪怕是异常情况下。
 * 			如果异常情况下不会造成太大影响的话（包括定位错误），就不用抛错或提示。（不是绝对的）
 * 4、宽容性：对需求宽容、对用户宽容、对调用者宽容、对维护者宽容。
 */
import java.util.ArrayList;
import java.util.Random;

public class Test {
	static int[] fun(int n){
		/*
		 * n的值是1到31之间的整数
		 */
		if(n>=1 && n<=31){
			//返回值类型是数组，个数是n
			int result[]= new int[n];
			Random random = new Random();
			//给random使用
			int nextInt = 0;
			//random生成不同的值时，count++
			int count = 0;
			//无论random生成什么值，resultcount++
			int resultcount = 0;
			//存储生成的不同的值
			ArrayList list = new ArrayList();
			//存储生成的所有值
			ArrayList resultList = new ArrayList();
			//只需要从0开始，跳出在在循环中设定
			for(int i = 0;;){
				//当生成的数已经达到数组上限时，必须退出循环
				if(count < n){
					//随机生成一个数，值在[2,32]   Math.floor(5.6)=5
					nextInt = (int) Math.floor(random.nextInt(31)+2);
					//封装值，测试观察时用到
					resultList.add(nextInt);
					//存储时，判断集合中是否已经存在相同值，不同值才能够存储
					if(!list.contains(nextInt)){
						//往list集合中添加元素
						list.add(nextInt);
						//往后跳一个格（只有存储不同值是才会操作这步骤）
						count++;
						//将生成的值赋值给对应位置的数组中
						result[i++] = nextInt;
					}
					//往后跳一个格（无论生成什么样的值都会操作这步骤）
					resultcount++;
				}else{
					break;
				}
			}
			//输出测试语句
			System.out.println("count: "+count + "  resultCount: "+resultcount+" resultList : "+resultList.toString());
			//返回最终结果
			return result;
		}
		return null;
	}
	public static void main(String[] args) {
		int[] fun = fun(5);
		if(fun!=null){
			for (int i : fun) {
				System.out.print(i+" ");
			}
		}else{
			System.out.println("n的取值范围是1-31");
		}
	}
}
