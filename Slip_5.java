import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

class EnumerationIteratorAdapter<T> implements Iterator<T> {
    private final Enumeration<T> enumeration;

    public EnumerationIteratorAdapter(Enumeration<T> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public T next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove not supported for Enumeration");
    }
}
public class Slip_5 {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Orange");

        Enumeration<String> enumeration = vector.elements();

        Iterator<String> iterator = new EnumerationIteratorAdapter<>(enumeration);

        System.out.println("Using Iterator with Enumeration:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
