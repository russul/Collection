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



//����������iterator��ԭ�� ��ͨ��Դ�������



//	public interface Iterable<T> {
//
//    /**
//     * Returns an iterator over a set of elements of type T.
//     *
//     * @return an Iterator.
//     */
//    Iterator<T> iterator();  //��һ��iterator����
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
//	Iterator<E> iterator();//�̳и��ӿڣ�Ҫ�и���ӿڵķ��������ڼ��Ͻӿ���û�о���ʵ��
//}

//public interface List<E> extends Collection<E> {
//Iterator<E> iterator();  //ͬ������û�о���ʵ�֣����Ǹ��ӿ�
//}



//public class ArrayList<E> extends AbstractList<E> //����ʵ������
//implements List<E>, RandomAccess, Cloneable, java.io.Serializable
//{

//	public Iterator<E> iterator() {//����������һ���ӿڣ���ôʵ�ʵķ���һ���������������
//	    return new Itr();
//	}


//	private class Itr implements Iterator<E> { //��ʱ����Itr��һ��ArrayList����ڲ��࣬��Iterator���������
//����ʵ�ֵ�Iterator<E>��ķ������������ò�����ArrayList������������������޷��������private Itr����������
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


//���������ִ�й���
//Collection c = new ArrayList();
//c���ص���ArrayList����Java��̬�Ĵ��ڣ�����ֵ�ǽӿ�����ʵ�ʷ��صı�Ȼ������������󣨱��뿴���棬ִ�п����棩
//c.add("hello");
//c.add("java");
//�ڼ��������Ԫ��
//Iterator it = c.iterator();
//it ����ArrayList��iterator����������Itr(it=Itr)
//it.hasNext()����Itr��д��ĵ�hasNext()