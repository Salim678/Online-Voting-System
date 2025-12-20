import service.AuthService;
import model.Voter;

public class Main {
    public static void main(String[] args) {
        AuthService auth = new AuthService();
        
        // Sample registration test
        Voter v = new Voter(0, "Test User", "test@gmail.com", "1234", false);
        boolean result = auth.register(v);

        if (result)
            System.out.println("User Registered Successfully");
        else
            System.out.println("Registration Failed");
    }
}
