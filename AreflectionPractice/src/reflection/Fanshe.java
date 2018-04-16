package reflection;
/**
 * 获取Class对象的三种方式
 * 1.Object -->getClass();
 * 2.任何数据类型(包括基本数据类型)都有一个“静态的”class属性
 * 3.通过Class类的静态方法：forName(String className)(常用)
 *
 */
public class Fanshe {
	public static void main(String[] args){
		//第一种方式获取Class对象
		Student stu1 =new Student();//这里new 产生一个Student对象，一个Class对象
		Class<? extends Student> stuClass =stu1.getClass();//获取Class对象,只能获取无参构造方法
		System.out.println(stuClass.getName());
		
		//第二种方式获取Class对象
		Class<? extends Student> stuClass2 =Student.class;
		System.out.println(stuClass == stuClass2);//判断第一种方式获取的Class对象和第二种方式获取的是否是同一个
		
		
		//第三种方式获取Class对象
		try {
			Class<?> stuClass3 =Class.forName("reflection.Student");//注意此字符串必须是真实路径，就是带包名的类路径，
											//包名.类名
			System.out.println(stuClass2 == stuClass3);//判断三种方式获取的是否是同一个Class对象
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
