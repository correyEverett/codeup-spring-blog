package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String showRollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable int guess, Model model) {
        int randomNumber = (int) Math.floor(Math.random() * 5) + 1;
        String message;

        if(guess == randomNumber){
            message = "Yay, you guessed correctly!";
        } else {
            message = "Sorry, try again!";
        }

        model.addAttribute("guess", guess);
        model.addAttribute("randomNumber",randomNumber);
        model.addAttribute("message", message);

        return "roll-results";
    }
}
