package com.hai.controller;

import com.hai.model.Ingredient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IngredientController {

    static List<Ingredient> ingredientList = new ArrayList<>();

    static {
        ingredientList.add(new Ingredient("Lettuce"));
        ingredientList.add(new Ingredient("Tomato"));
        ingredientList.add(new Ingredient("Mustard"));
        ingredientList.add(new Ingredient("Spourts"));
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("list", ingredientList);
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam(defaultValue = "Không có gì") String spice, Model model) {
        Ingredient ingredient = new Ingredient(spice);
        List<Ingredient> ingredientList1 = new ArrayList<>();
        ingredientList1.add(ingredient);
        model.addAttribute("list", ingredientList1);
        return "result";
    }
}
