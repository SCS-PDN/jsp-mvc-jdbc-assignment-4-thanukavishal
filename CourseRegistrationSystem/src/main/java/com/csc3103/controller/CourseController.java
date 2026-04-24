package com.csc3103.controller;

import java.sql.*;
import java.util.*;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.sql.DataSource;

@Controller
public class CourseController {

    @Autowired
    DataSource dataSource;

    @GetMapping("/courses")
    public String showCourses(HttpServletRequest request) throws Exception {

        Connection con = dataSource.getConnection();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM courses");

        List<Map<String, Object>> courses = new ArrayList<>();

        while (rs.next()) {
            Map<String, Object> c = new HashMap<>();
            c.put("id", rs.getInt("course_id"));
            c.put("name", rs.getString("name"));
            c.put("instructor", rs.getString("instructor"));
            c.put("credits", rs.getInt("credits"));
            courses.add(c);
        }

        request.setAttribute("courses", courses);
        return "courses";
        
    }
    
    @PostMapping("/register/{id}")
    public String register(@PathVariable("id") int courseId,
                           HttpServletRequest request) throws Exception {

        int studentId = (int) request.getSession().getAttribute("student_id");

        Connection con = dataSource.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO registrations (student_id, course_id, date) VALUES (?, ?, CURDATE())"
        );

        ps.setInt(1, studentId);
        ps.setInt(2, courseId);

        ps.executeUpdate();

        return "success";
    }
}