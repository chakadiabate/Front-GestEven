package com.kalanso.event.Service.Notification;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

@Service
@AllArgsConstructor
public class GenerateRandomString {

    public String generateRandomString() {
        String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";
        int LENGTH = 12;
        Random RANDOM = new SecureRandom();

        StringBuilder sb = new StringBuilder(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}
