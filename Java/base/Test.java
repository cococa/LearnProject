public class Test implements Cloneable,TT {
	public static void main(String[] args) {
		// Test t  = new Test();
		// Test t1 = t;

		// System.out.println(t);
		// System.out.println(t1);
		// // 这里t和t1 其实是一个对象

		// try {
		// 	Test cloneTest = (Test)t.clone();
		// 	// 调用clone方法后，cloneTest 和 t 指向的不是一个引用
		// 	System.out.println(t);
		// 	System.out.println(cloneTest);


		// 	System.out.println(String.format("clone class == result %s", cloneTest.getClass() == t.getClass()));
		// 	System.out.println(String.format("clone equals result %s", cloneTest.equals(t)));

		// } catch (CloneNotSupportedException e) {
		// 	// 如果没有实现Cloneable , 则可能跑出CloneNotSupportedException
		// 	System.out.println(e.toString());
		// }

		// int[] arr = new int[64 * 1024 * 1024];

		// // Loop 1
		// long time  = System.currentTimeMillis();
		// for (int i = 0; i < arr.length; i += 16) arr[i] *= 3;
		// System.out.println(System.currentTimeMillis() - time);



		Test t = new Test();
		t.cry();


	}



	public void cry(){
		System.out.println("123");
	}


}
