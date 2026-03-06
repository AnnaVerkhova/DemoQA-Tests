package test.security;

public class EncryptPassword {
    public static void main(String[] args) {
        String password = "Password123!";
        String encrypted = CipherUtil.encrypt(password);
        System.out.println(encrypted);
    }
}
