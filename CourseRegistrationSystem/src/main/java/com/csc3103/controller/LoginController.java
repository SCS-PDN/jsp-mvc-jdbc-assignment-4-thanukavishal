package com.csc3103.controller;

import java.sql.*;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.sql.DataSource;

@Controller
public class LoginController {

    @Autowired
    DataSource dataSource;
    
    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request) throws Exception {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Connection con = dataSource.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM students WHERE email=? AND password=?"
        );

        ps.setString(1, email);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            request.getSession().setAttribute("student_id", rs.getInt("student_id"));
            return "redirect:/courses";
        } else {
            request.setAttribute("error", "Invalid login!");
            return "login";
        }
    }
}