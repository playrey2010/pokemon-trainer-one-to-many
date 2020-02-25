package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    TrainerRepository trainerRepository;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("trainers", trainerRepository.findAll());
        model.addAttribute("pokemons", pokemonRepository.findAll());
        return "index";
    }

    @GetMapping("/addTrainer")
    public String addTrainer(Model model) {
        model.addAttribute("trainer", new Trainer());
        return "trainerform";
    }

    @PostMapping("/processTrainer")
    public String processTrainer(@ModelAttribute Trainer trainer) {
        trainerRepository.save(trainer);
        return "redirect:/";
    }

    @GetMapping("/addPokemon")
    public String addPokemon(Model model) {
        model.addAttribute("trainers", trainerRepository.findAll());
        model.addAttribute("pokemon", new Pokemon());
        return "pokemonform";
    }

    @PostMapping("/processPokemon")
    public String processPokemon(@ModelAttribute Pokemon pokemon, @RequestParam(name = "trainer") String trainer) {
        pokemonRepository.save(pokemon);
        return "redirect:/";
    }
}
