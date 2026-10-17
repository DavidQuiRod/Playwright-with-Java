package academy.playwright;
import com.microsoft.playwright.CLI;

public class InstalarNavegadores {
    public static void main(String [] args) throws Exception{
        CLI.main(new String[] {"install", "chromium"});
    }
}
