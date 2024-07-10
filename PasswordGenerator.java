import java.util.*;

public class PasswordGenerator {
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String PUNCTUATION = "!@#$%&*()_+-=[]|,./?><";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the desired password length: ");
            int length = scanner.nextInt();

            if (length <= 0) {
                System.out.println("Password length must be a positive number.");
                return;
            }
            System.out.println("Note: Y=Yes and N=No");
            System.out.print("Include uppercase letters? (Y/N): ");
            boolean includeUpper = getYesOrNo(scanner);
            System.out.print("Include lowercase letters? (Y/N): ");
            boolean includeLower = getYesOrNo(scanner);
            System.out.print("Include numbers? (Y/N): ");
            boolean includeDigits = getYesOrNo(scanner);
            System.out.print("Include special characters? (Y/N): ");
            boolean includePunctuation = getYesOrNo(scanner);

            try {
                String password = generatePassword(length, includeUpper, includeLower, includeDigits,
                        includePunctuation);
                System.out.println("Generated Password: " + password);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.print("Do you want to generate another password? (1=continue, 0=exit): ");
            int choice = scanner.nextInt();
            if (choice == 0) {
                System.out.println("Exiting program...");
                break;
            }
        }
        scanner.close();
    }

    private static boolean getYesOrNo(Scanner scanner) {
        String input = scanner.next();
        return input.equalsIgnoreCase("Y");
    }

    public static String generatePassword(int length, boolean includeUpper, boolean includeLower, boolean includeDigits,
            boolean includePunctuation) {
        StringBuilder charPool = new StringBuilder();
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        if (includeUpper) {
            charPool.append(UPPER);
            password.append(UPPER.charAt(random.nextInt(UPPER.length())));
        }
        if (includeLower) {
            charPool.append(LOWER);
            password.append(LOWER.charAt(random.nextInt(LOWER.length())));
        }
        if (includeDigits) {
            charPool.append(DIGITS);
            password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        }
        if (includePunctuation) {
            charPool.append(PUNCTUATION);
            password.append(PUNCTUATION.charAt(random.nextInt(PUNCTUATION.length())));
        }

        if (charPool.length() == 0) {
            throw new IllegalArgumentException("At least one character set must be selected!");
        }

        for (int i = password.length(); i < length; i++) {
            password.append(charPool.charAt(random.nextInt(charPool.length())));
        }

        return shuffleString(password.toString());
    }

    private static String shuffleString(String string) {
        List<Character> characters = new ArrayList<>();
        for (char c : string.toCharArray()) {
            characters.add(c);
        }
        Collections.shuffle(characters);
        StringBuilder shuffledString = new StringBuilder();
        for (char c : characters) {
            shuffledString.append(c);
        }
        return shuffledString.toString();
    }
}
