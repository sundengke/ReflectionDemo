package cn.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 通过反射越过泛型检查
 *
 * 例如：有一个String 泛型的集合，怎么向这个集合添加一个Integer类型的值？
 */
public class Demo2 {
	public static void main(String[] args) throws Exception {
		ArrayList<String> strList =new ArrayList<String>();
		strList.add("aaa");
		strList.add("bbb");
		
		//strList.add(100);
		//获取ArrayList的Class对象，反向的调用add()方法，添加数据
		Class<? extends ArrayList> listclazz =strList.getClass();//得到 strList对象的字节码对象
		//获取add()方法
		Method method =listclazz.getMethod("add", Object.class);
		//调用add()方法
		method.invoke(strList,100);
		
		for(Object obj : strList){
			System.out.println(obj);
		}
	}
}
