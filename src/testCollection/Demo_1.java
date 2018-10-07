package testCollection;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;

import java.util.Iterator;



public class Demo_1 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("hello");
		c.add("java");
		Iterator it = c.iterator();
		while(it.hasNext()){
			String s = (String)it.next();
			System.out.println(s);
		}
	}


}



//分析迭代器iterator的原理 （通过源码分析）



//	public interface Iterable<T> {
//
//    /**
//     * Returns an iterator over a set of elements of type T.
//     *
//     * @return an Iterator.
//     */
//    Iterator<T> iterator();  //就一个iterator方法
//}

//
//public interface Iterator<E> {
//   
//    boolean hasNext();
//
//    
//    E next();
//
//    
//    void remove();
//}


//public interface Collection<E> extends Iterable<E> {
//
//	Iterator<E> iterator();//继承父接口，要有父类接口的方法，但在集合接口里没有具体实现
//}

//public interface List<E> extends Collection<E> {
//Iterator<E> iterator();  //同样还是没有具体实现，还是个接口
//}



//public class ArrayList<E> extends AbstractList<E> //具体实现类了
//implements List<E>, RandomAccess, Cloneable, java.io.Serializable
//{

//	public Iterator<E> iterator() {//返回类型是一个接口，那么实际的返回一定是他的子类对象
//	    return new Itr();
//	}


//	private class Itr implements Iterator<E> { //此时发现Itr是一个ArrayList类的内部类，是Iterator的子类对象，
//并且实现的Iterator<E>里的方法，这样就让不属于ArrayList集合类的其他集合类无法调用这个private Itr（迭代器）
//	    
//	
//	    public boolean hasNext() {
//	       ......
//	    }
//	
//	   
//	    public E next() {
//	      ......
//	    }
//	
//	    public void remove() {
//	       .......
//	   
//	}

//}	


//分析代码的执行过程
//Collection c = new ArrayList();
//c返回的是ArrayList对象，Java多态的存在，返回值是接口类型实际返回的必然是他的子类对象（编译看左面，执行看右面）
//c.add("hello");
//c.add("java");
//在集合中添加元素
//Iterator it = c.iterator();
//it 就是ArrayList的iterator方法，返回Itr(it=Itr)
//it.hasNext()就是Itr重写后的的hasNext()