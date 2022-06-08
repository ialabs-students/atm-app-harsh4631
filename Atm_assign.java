
import java.util.Scanner;

public class Atm_assign {

    public static void deposit(int[] arr, Scanner sc) {
        System.out.println("2000?");
        int twoThousand = sc.nextInt();
        System.out.println("500?");
        int fiveHundred = sc.nextInt();
        System.out.println("200?");
        int twoHundred = sc.nextInt();
        System.out.println("100?");
        int hundred= sc.nextInt();

        if (twoThousand < 0 || fiveHundred < 0 || twoHundred< 0 || hundred < 0) {
            System.out.println("incorrect deposit amount");
            return;
        }
        if (twoThousand == 0 && fiveHundred == 0 && twoHundred == 0 && hundred== 0) {
            System.out.println("Deposit amount cannot be zero");
            return;
        }
        arr[0] = twoThousand;
        arr[1] = fiveHundred;
        arr[2] = twoHundred;
        arr[3] = hundred;

        System.out.println("Balance: 2000s=" + arr[0] + ",500s=" + arr[1] + ",200s=" + arr[2] + ",100s=" + arr[3]
                + ", Total=" + Toatalbalance(arr));

    }

    private static int Toatalbalance(int[] arr) {

        return (arr[0] * 2000) + (arr[1] * 500) + (arr[2] * 200) + (arr[3] * 100);
    }

    public static void withdraw(int[] arr, Scanner sc) {
        int cb = Toatalbalance(arr);
        System.out.println("Enter amount");
        int amount = sc.nextInt();

        if (amount == 0 || amount < 0 || amount > cb) {
            System.out.println("incorrect or insufficient funds");
            return;
        }
        // dispensed count

        int twoThousant = 0, fiveHundred = 0, twoHundred = 0, hundred = 0;

        while (arr[0] != 0 && 2000 <= amount) {
            twoThousant++;
            arr[0]--;
            amount -= 2000;
        }

        while (arr[1] != 0 && 500 <= amount) {
            fiveHundred++;
            arr[1]--;
            amount -= 500;
        }
        while (arr[2] != 0 && 200 <= amount) {
            twoHundred++;
            arr[2]--;
            amount -= 200;
        }
        while (arr[3] != 0 && 100 <= amount) {
            hundred++;
            arr[3]--;
            amount -= 100;
        }

        System.out.println("Dispensed: 2000s=" + twoThousant + ",500s=" + fiveHundred + ",200s=" + twoHundred + ",100s="
                + hundred);

        System.out.println("Balance: 2000s=" + arr[0] + ",500s=" + arr[1] + ",200s=" + arr[2] + ",100s=" + arr[3]
                + ", Total=" + Toatalbalance(arr));

    }

    public static void main(String[] args) {

        int[] arr = new int[4];

        int a = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("0.Exit \n1.Deposit Amount \n2.Withdraw Amount ");
        int input = sc.nextInt();

        while (input != 0) {
            if (input == 1) {
                deposit(arr, sc);
               a = Toatalbalance(arr);
            } else if (input == 2) {
                withdraw(arr, sc);

            } else {
                break;
            }

            System.out.println("0.Exit \n1.Deposit Amount \n2.Withdraw Amount ");
            input = sc.nextInt();

        }

    }

}