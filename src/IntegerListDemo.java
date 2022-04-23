import java.util.Scanner;

//creating user defined exception for alerting the user in case a wrong value is fed to the program
class InputException extends Exception {
    public InputException(String errorMessage) {
        super(errorMessage);
    }
}

public class IntegerListDemo {
    public static void main(String[] args){
            Scanner input = new Scanner(System.in);
            //Asking the user to enter how many numbers user they want.
            System.out.print("Enter list size: ");
            int listSize = input.nextInt();
            int total = 0;

            for(int i = 0; i < listSize; i++) {

                System.out.print("Enter the value "+ (i+1) +" in range (-100 to 100) :");
                try {
                    int value = getInput();
                    total += value*value;
                } catch (InputException error) {
                    //displaying the exception message
                    System.out.println(error.toString());
                    i--;
                }
            }
            //printing the result
            System.out.println("Sum of the squares of entered values is " + total);
    }

    private static int getInput() throws InputException {
        Scanner input = new Scanner(System.in);
        int value = input.nextInt();
        if(value < -100 || value > 100) throw new InputException("Value not in specified range of (-100 to 100)");
        else return value;
    }
}
