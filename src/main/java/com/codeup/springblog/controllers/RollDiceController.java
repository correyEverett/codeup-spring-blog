package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String guess(@RequestParam(name = "n") int number, Model model) {
        int randomNumber = (int) Math.floor(Math.random() * 5) + 1;

        model.addAttribute("n", "You guessed " + number);
        model.addAttribute(randomNumber);
        return "roll-dice";
    }
}
