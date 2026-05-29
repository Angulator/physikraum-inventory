package de.physikraum.inventory.controller;

import de.physikraum.inventory.entity.Item;
import de.physikraum.inventory.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;
    public ItemController(ItemService itemService) { this.itemService = itemService; }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("items", itemService.findAll());
        return "items/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("item", new Item());
        return "items/create";
    }

    @PostMapping
    public String create(@ModelAttribute Item item, BindingResult result) {
        if (result.hasErrors()) return "items/create";
        itemService.save(item);
        return "redirect:/items";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Optional<Item> opt = itemService.findById(id);
        if (opt.isEmpty()) return "redirect:/items";
        model.addAttribute("item", opt.get());
        return "items/edit";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Item item) {
        item.setId(id);
        itemService.save(item);
        return "redirect:/items";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        itemService.delete(id);
        return "redirect:/items";
    }
}
