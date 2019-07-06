package com.springbank.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {
    @GetMapping("")
    public void getlogout(Model model, HttpSession session, HttpServletResponse response) throws IOException {
        session.invalidate();
    model.asMap().clear();
    response.sendRedirect("/login");
}
}