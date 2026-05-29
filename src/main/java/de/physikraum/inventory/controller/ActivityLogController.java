package de.physikraum.inventory.controller;

import de.physikraum.inventory.service.ActivityLogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logs")
public class ActivityLogController {
    private final ActivityLogService logService;
    public ActivityLogController(ActivityLogService logService) { this.logService = logService; }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("logs", logService.findAll());
        return "logs/list";
    }
}
