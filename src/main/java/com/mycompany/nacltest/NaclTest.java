package com.mycompany.nacltest;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.abstractj.kalium.crypto.SealedBox;

public class NaclTest {
    public static void main(String[] args) throws Exception {
        SealedBox sb = new org.abstractj.kalium.crypto.SealedBox(Files.readAllBytes(Paths.get("/tmp/pubkey.sodium")), Files.readAllBytes(Paths.get("/tmp/prikey.sodium")));
        byte[] plaintext = sb.decrypt(Files.readAllBytes(Paths.get("/tmp/ciphertext.sodium")));
        System.out.println(plaintext.length);
    }
}
