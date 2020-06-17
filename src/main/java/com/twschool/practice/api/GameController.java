package com.twschool.practice.api;

import com.twschool.practice.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GameController {
    @Autowired
    GameService gameService;
    Map<String, Object> userInfo = new HashMap();

    @GetMapping("/game")
    public Map<String, Object> guess(@RequestParam String guess,@RequestParam String username) {

        Map<String, Object> map = null;
        map = gameService.guess(guess,username);
        map.put("input", guess);
        return map;
    }

    @GetMapping("/history")
    public Map<String, Object> history() {
        Map<String, Object> map = new HashMap<>();
        map.put("result", "input:1 2 3 4 output:4A0B");
        return map;
    }

}
