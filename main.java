import java.util.Properties;
import java.util.Scanner;
import java.io.InputStream;

public class main {
	private static Properties languangeProperties;
	private static String currentLanguangeCode;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		languangeProperties = new Properties();
		currentLanguangeCode = "en_US"; // Default languange
		loadLanguangeProperties(); // Call loadLanguangeProperties method

		System.out.println("Choose a languange: ");
		System.out.println("1. English");
		System.out.println("2. Bahasa Indonesia");
		int choiceLang = scan.nextInt();

		switch (choiceLang) {
			case 1:
				changeLanguange("en_US"); // Call changeLanguange with parameter "en_US"
				break;
			case 2:
				changeLanguange("id_ID"); // Call changeLanguange with parameter "id_ID"
				break;
			default:
				System.out.println("Invalid choice!");
				break;
		}

		displayWelcomeMessage();
		displayMenuMessage();


	}

	private static void loadLanguangeProperties() {
		try {
			InputStream input = main.class.getClassLoader().getResourceAsStream(currentLanguangeCode + ".properties");
			languangeProperties.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void changeLanguange(String newLanguangeCode) {
		currentLanguangeCode = newLanguangeCode;
		loadLanguangeProperties();
	}

	private static void displayWelcomeMessage() {
		System.out.println(languangeProperties.getProperty("welcomeMessage", "Message not found"));
	}

	private static void displayMenuMessage() {
		String menuMessage = languangeProperties.getProperty("menuMessage", "Message not found");
		menuMessage = menuMessage.replace("\\", System.lineSeparator());
		System.out.println(menuMessage);
	}
}