package reflection.method;

public class ParentClass {
	
	public void parentMethod(String name){
		System.out.println("ParentClass中爸爸的名字： "+name);
	}
	
	private void parentMethod2(int age){
		System.out.println("ParentClass中爸爸的年龄： "+age);
	}
}
