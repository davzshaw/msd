package net.davzshaw.MsdProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RenderController {

  @GetMapping({"/", "/home", "/index", "/index.html", "/home.html"})
  public String renderHome() {
    return "index";
  }

  @GetMapping({"/dashboard", "/dashboard.html"})
  public String renderDashboard() {
    return "dashboard";
  }

  @GetMapping({"/login", "/login.html"})
  public String renderLogin() {
    return "login";
  }

  @GetMapping({"/manage-data", "/manage-data.html"})
  public String renderManageData() {
    return "manage-data";
  }

  @GetMapping({"/register", "/register.html"})
  public String renderRegister() {
    return "register";
  }

  @GetMapping({"/user-management", "/user-management.html"})
  public String renderUserManagement() {
    return "user-management";
  }
  
}
