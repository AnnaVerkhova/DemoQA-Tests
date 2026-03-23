package test.security;

public class EncryptPassword {
    public static void main(String[] args) {
        String password = "Password123!";
        String encrypted = CipherUtil.encrypt(password);
        System.out.println(encrypted);
    }

    public static void encryptPasswordDB(String[] args) {
        String passwordDB = "123qwe456";
        String encryptedBD = CipherUtil.encrypt(passwordDB);
        System.out.println(encryptedBD);
    }
}
