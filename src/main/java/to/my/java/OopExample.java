package to.my.java;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Jhon on 2016-01-07.
 */
public class OopExample {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("count: " + list.getCount());

        MyList<Integer> list2 = new MyList<>();
        list2.addAll(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("count: " + list2.getCount());
    }
}

class MySet<E> extends HashSet<E> {
    @Override
    public boolean addAll(final Collection<? extends E> c) {
        boolean modified = false;
        for(E e : c)
            if(add0(e))
                modified = true;
        return modified;
    }

    @Override
    public boolean add(final E e) {
        return add0(e);
    }

    private boolean add0(final E e) {
        return super.add(e);
    }
}
class MyList<E> extends MySet<E> {
    private int count;

    public int getCount() {
        return count;
    }

    @Override
    public boolean addAll(final Collection c) {
        count += c.size();
        return super.addAll(c);
    }

    @Override
    public boolean add(final E o) {
        count++;
        return super.add(o);
    }
}
