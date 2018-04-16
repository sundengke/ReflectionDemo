package cn.reflection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

/**  反射方法的其它使用之---通过反射运行配置文件内容
 * 
 * 我们利用反射和配置文件，可以使：应用程序更新时，对源码无需进行任何修改
 * 我们只需要将新类发送给客户端，并修改配置文件即可
 */
public class Demo {
	public static void main(String[] args) throws Exception{
		//1.通过反射获取Class对象
		Class<?> stuClazz =Class.forName(getValue("className"));
		//2.获取 show() 方法
		Method method =stuClazz.getMethod(getValue("methodName"));
		//3.调用 show() 方法
		method.invoke(stuClazz.getConstructor().newInstance());
	}
	
	public static String getValue(String key) throws IOException{
		Properties pro =new Properties();//获取配置文件对象
		FileReader in =new FileReader("C://apps//pro.txt");//获取输入流
		pro.load(in);
		in.close();
		return pro.getProperty(key);
	}
	/**
	 * 当我们升级这个系统时，不要Student类，而需要新写一个Student2的类时，
	 * 这时只需要更改pro.txt的文件内容就可以了。代码就一点不用改动
	 */
}
