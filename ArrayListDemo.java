import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List numbers = new ArrayList();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        for (Object number : numbers){
            System.out.println(number);
        }

        Collections.sort(numbers);

        for (Object number : numbers){
            System.out.println(number);
        }

    }
}
