package com.twschool.practice.service;

import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.RandomAnswerGenerator;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class GameService {

    Map<String, Integer> userInfo = new HashMap<>();
    GuessNumberGame guessNumberGame;

    public Map<String, Object> guess(String guess, String username) {
        if (userInfo.get("username") == null) {
            guessNumberGame = new GuessNumberGame(new RandomAnswerGenerator());
            userInfo.put(username, Integer.valueOf(0));
        }
        String result = guessNumberGame.guess(Arrays.asList(guess.split(" ")));
        if ("4A0B".equals(result)) {
            Integer nowMark = userInfo.get(username);
            nowMark += 3;
            userInfo.put(username, Integer.valueOf(0));
        }
        Map<String, Object> map = new HashMap<>();

        map.put("result", guessNumberGameConsole.guess(guess));
        return map;
    }
}
