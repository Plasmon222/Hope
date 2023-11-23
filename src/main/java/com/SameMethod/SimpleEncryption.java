package com.SameMethod;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: Plasmon222
 * @Date: 2023/11/20/9:13
 * @Description: 使用异或方法  简单的对数字进行加密
 */
//public class SimpleEncryption {
//    public static void main(String[] args) {
//        int number = 18;
//        int key = 1008611;
//        int encryptedNumber = encrypt(number, key);
//        System.out.println("加密后的数字： " + encryptedNumber);
//
//        int decryptedNumber = decrypt(encryptedNumber, key);
//        System.out.println("解密后的数字： " + decryptedNumber);
//    }
//
//    public static int encrypt(int number, int key) {
//        return number ^ key;
//    }
//
//    public static int decrypt(int encryptedNumber, int key) {
//        return encryptedNumber ^ key;
//    }
//
//}
//public class SimpleEncryption {
//    public static void main(String[] args) {
//        String input = "surveyId=12";
//        int shift = 3;
//        String encrypted = encrypt(input, shift);
//        System.out.println("加密后的字符串： " + encrypted);
//
//        String decrypted = decrypt(encrypted, shift);
//        System.out.println("解密后的字符串： " + decrypted);
//    }
//
//    public static String encrypt(String input, int shift) {
//        StringBuilder encrypted = new StringBuilder();
//        for (char c : input.toCharArray()) {
//            if (Character.isLetter(c)) {
//                char base = Character.isLowerCase(c) ? 'a' : 'A';
//                c = (char) (((c - base + shift) % 26) + base);
//            }
//            encrypted.append(c);
//        }
//        return encrypted.toString();
//    }
//
//    public static String decrypt(String input, int shift) {
//        return encrypt(input, 26 - shift);
//    }
//}
public class SimpleEncryption {
//    public static void main(String[] args) {
//        String input = "18";
//        int offset = 3; // 字母偏移量
//        int numOffset = 5; // 数字偏移量
//        String encrypted = encrypt(input, offset, numOffset);
//        System.out.println("加密后的字符串： " + encrypted);
//    }
//
//    public static String encrypt(String input, int offset, int numOffset) {
//        char[] chars = input.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if (Character.isLetter(chars[i])) {
//                chars[i] = (char) (chars[i] + offset);
//            } else if (Character.isDigit(chars[i])) {
//                chars[i] = (char) (chars[i] - numOffset);
//            }
//        }
//        return new String(chars);
//    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String originalString = "18";
        // 创建MD5摘要对象
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(originalString.getBytes(StandardCharsets.UTF_8));
        // 计算哈希值
        byte[] result = messageDigest.digest();
        // 将哈希值转换为十六进制字符串
        String hexString = new HexBinaryAdapter().marshal(result);
        System.out.println("Original String: " + originalString);
        System.out.println("SHA-256 Hash: " + hexString.toLowerCase());

    }
}

