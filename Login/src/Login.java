import java.util.Scanner;

public class Login {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        //Calling enterCredential to run the app.
        enterCredentials(in);
    }

    static void enterCredentials(Scanner in){

        System.out.println("First name?");
        String firstName = in.nextLine();

        System.out.println("Last name?");
        String lastName = in.nextLine();

        System.out.println("Business domain name?");
        String busDomain = in.nextLine();

        validateData(firstName, lastName, busDomain, in);
       
    }

    //The function will processing and validate each fields user have just entered.
    static void validateData(String firstName, String lastName, String busDomain, Scanner in){

        //This loop is to validate the empty fields.
         while( firstName.isBlank() || firstName.isEmpty()
        ||      lastName.isBlank()  || lastName.isEmpty()
        ||      busDomain.isBlank() || busDomain.isEmpty())
            {
                if(firstName.isBlank() || firstName.isEmpty())
                    System.out.println("First name is empty, please provide a correct one.");

                if(lastName.isBlank() || lastName.isEmpty()) 
                    System.out.println("Last name is empty, please provide a correct one.");

                if(busDomain.isBlank() || busDomain.isEmpty())
                    System.out.println("Business domain is empty, please provide a correct one.");
                
                
                enterCredentials(in);
            }

        //This loop is to validate for the length of firstName or lastName.
        while(firstName.length() < 4 || lastName.length() < 4){

            if(firstName.length() < 4)
                System.out.println("First name length must be at least 4.");

            if(lastName.length() < 4)
                System.out.println("Last name length must be at least 4.");

            enterCredentials(in);
        }

        //This loop is to validate valid business domain.
        while(!busDomain.contains(".")){
            System.out.println("Business domain is not valid, example hamk.fi");

            enterCredentials(in);
        }

        //If everything above is good, we calling function generateEmail and generateUsername for next step.
        GenerateEmail(firstName, lastName, busDomain);
        GenerateUsername(firstName, lastName);
    }

    //Function generate email.
    static void GenerateEmail(String firstName, String lastName, String busDomain){
            System.out.println(firstName.toLowerCase()+"."
                                +lastName.toLowerCase()+"@"
                                +busDomain);
    }

    //Function generate username.
    static void GenerateUsername(String firstName, String lastName){
        //For substring last name, set the endIndex as lastName length (get the last element). And for beginIndex we substract for 4 (get 4 character forward from the end)
            System.out.println(firstName.toLowerCase().substring(0, 4)
                                +lastName.toLowerCase().substring(lastName.length() - 4 >= 0? 
                                lastName.length() - 4: 0, lastName.length()));
    }

}
