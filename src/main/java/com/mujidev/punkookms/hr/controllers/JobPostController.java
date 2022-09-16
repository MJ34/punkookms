package com.mujidev.punkookms.hr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobPostController {


    @GetMapping("hr/jobPost")
    public String findAll() {
        return "/hr/jobPost";
    }

    @GetMapping("/hr/jobPostAdd")
    public String addJobPost() {
        return "/hr/jobPostAdd";
    }
    
}
