package ru.java413.homework16.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.java413.homework16.services.TeacherService;


@Controller
@RequestMapping("/main")
public class MainController {
    @Autowired
    private TeacherService teacherService;


    @GetMapping("/list")
    public String mainPage(Model model) {
        model.addAttribute("title", "Home Page");
        model.addAttribute("teachers", teacherService.findAll());
        return "index";
    }

    @GetMapping("/addAuthor")
    public String addAuthor(Model model) {
        teacherService.generationData(5);
        return "redirect:/main/list";
    }

    @GetMapping("/clear")
    public String clear(Model model) {
        teacherService.deleteAll();
        return "redirect:/main/list";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(Model model, @PathVariable Long id) {
        teacherService.deleteById(id);
        return "redirect:/main/list";
    }

    @GetMapping("/sort")
    public String sorting(@RequestParam String field,
                          @RequestParam(defaultValue = "asc") String direction,
                          Model model) {
        model.addAttribute("teachers", teacherService.sortByField(field, direction));
        model.addAttribute("sortField", field);
        model.addAttribute("sortDirection", direction);
        return "index";
    }
}
