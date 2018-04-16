package reflection.field;

import java.lang.reflect.Field;

/**
 * 获取成员变量并调用：
 * 1.批量的
 * 		1).Field[] getFields() :获取所有的"公有字段"
 * 		2).Field[] getDeclaredFields() :获取所有字段，包括：私有、受保护、默认、公有；
 * 2.获取单个的： 
 *      1).public Field getField(String fieldName):获取某个"公有的"字段； 
 *      2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的) 
 * 
 * 		设置字段的值：
 * 		Field ——> public void set(Object obj,Object value)
 * 					参数说明：
 *  				1.obj：要设置的字段所在的对象；
 *					2.value：要为字段设置的值；			
 */
public class Fields {
	public static void main(String[] args) throws Exception {
		//1.获取Class对象
		Class<?> stuClass = Class.forName("reflection.field.Student");
		//2.获取字段
		System.out.println("************获取所有公有的字段********************");  
		Field[] fieldArray =stuClass.getFields();
		for (Field f : fieldArray) {
			System.out.println(f);
		}
		System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");  
		fieldArray = stuClass.getDeclaredFields();
		for (Field f : fieldArray) {
			System.out.println(f);
		}
		System.out.println("*************获取公有字段**并调用***********************************"); 
		Field field =stuClass.getField("name");
		System.out.println(field);
		//获取一个对象
		Object object =stuClass.getConstructor().newInstance();//产生Student对象==》Student s =new  Student()
		//为字段设置值
		field.set(object, "我爱罗");//为Student对象中的name属性赋值
		//验证
		Student stu =(Student) object;
		System.out.println("验证姓名： "+stu.name);
		
		System.out.println("**************获取所有类型的字段（包括私有）****并调用********************************");
		field =stuClass.getDeclaredField("phoneNum");
		System.out.println(field);
		field.setAccessible(true);//暴力反射，接触私有限定
		field.set(object, "15209282471");
		System.out.println("验证电话：  " + stu);
		
	}
}
