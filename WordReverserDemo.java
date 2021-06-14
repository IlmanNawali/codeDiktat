import java.util.Scanner;

public class WordReverserDemo {
    public static void main(String[] args) {
        String kata;
        WordReverser reverse= new WordReverser();
        Scanner sc = new Scanner(System.in);
        System.out.print("Input kalimat (0 untuk keluar): ");
        kata = sc.nextLine();
        while(!kata.equals("0")){
            System.out.println("Hasil Pembalikan: " + reverse.reverseWord(kata));
            System.out.print("Input kalimat (0 untuk keluar): ");
            kata= sc.nextLine();
        }

    }
}
