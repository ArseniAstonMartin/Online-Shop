package com.example.demo;

import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;

public class JWTSecretMakerTest {
    @Test
    public void createSecretKey() {
        SecretKey key = Jwts.SIG.HS512.key().build();
        String encodedKey = DatatypeConverter.printHexBinary(key.getEncoded());
        System.out.printf("Key = [%s]", encodedKey);
    }
}
