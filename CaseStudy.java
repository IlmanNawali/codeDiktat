/**
 * Ilman Nawali
 */
import java.util.Scanner;
import java.util.Arrays;

public class CaseStudy{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] n = new int[5];

        for (int i=0; i < n.length; i++) {
            System.out.print("Input Array ke-"+(1+i)+": ");
            n[i] = sc.nextInt();
        }
        System.out.println("## Angka Hasil Input ##");
        for (int i=0; i < n.length; i++){
            System.out.println(n[i]);;
        }
        Arrays.sort(n);
        System.out.println("## Angka Setelah Diurutkan ##");
        for (int nilai : n){
            System.out.println(nilai);;
        }
    }
}
