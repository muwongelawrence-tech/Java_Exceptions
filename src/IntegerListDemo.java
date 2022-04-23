import java.util.Scanner;

//creating user defined exception for alerting the user incase a wrong value is fed to the program
class InputException extends Exception {
    public InputException(String errorMessage) {
        super(errorMessage);
    }
}

public class IntegerListDemo {
    public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            //taking how many numbers user want to enter
            System.out.print("Enter how many number you want to enter :");
            int n = sc.nextInt();
            int sum = 0;
            //taking the user's input values
            for(int i=0; i<n; i++) {
                System.out.print("Enter the value "+(i+1)+" (-100 to 100) :");
                try {
                    int value = takeInput();
                    sum += value*value;
                } catch (InputException e) {
                    //displaying the exception
                    System.out.println(e.toString());
                    i--;
                }
            }
            //printing the result
            System.out.println("Sum of the squares of entered values is " + sum);
    }

    private static int takeInput() throws InputException {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        if(value<-100 || value>100) throw new InputException("Value exceeded the input range (-100 to 100)");
        else return value;
    }
}
