package com.mujidev.punkookms.hr.controllers;

import java.io.File;
import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mujidev.punkookms.hr.models.Employee;
import com.mujidev.punkookms.hr.services.EmployeeService;
import com.mujidev.punkookms.hr.services.EmployeeTypeService;
import com.mujidev.punkookms.hr.services.JobTitleService;
import com.mujidev.punkookms.parameters.services.CountryService;
import com.mujidev.punkookms.parameters.services.StateService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private StateService stateService;
    @Autowired
    private JobTitleService jobTitleService;
    @Autowired
    private EmployeeTypeService employeeTypeService;
    @Autowired
    private CountryService countryService;

    public Model addModelAttributes(Model model) {
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states", stateService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("jobTitles", jobTitleService.findAll());
        model.addAttribute("employeeTypes", employeeTypeService.findAll());
        return model;
    }

    // Get All Employees
    @GetMapping("hr/employees")
    public String findAll(Model model) {
        addModelAttributes(model);
        return "/hr/employees";
    }

    @GetMapping("/hr/employeeAdd")
    public String addEmployee(Model model) {
        addModelAttributes(model);
        return "/hr/employeeAdd";
    }

    // The op parameter is either Edit or Details
    @GetMapping("/hr/employee/{op}/{id}")
    public String editEmployee(@PathVariable Integer id, @PathVariable String op, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        addModelAttributes(model);
        return "/hr/employee" + op; // returns employeeEdit or employeeDetails
    }

    // Add Employee
    @PostMapping("/hr/employees")
    public String addNew(Employee employee) {
        employeeService.save(employee);
        return "redirect:/hr/employees";
    }

    @RequestMapping(value = "/hr/employee/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String delete(@PathVariable Integer id) {
        employeeService.delete(id);
        return "redirect:/hr/employees";
    }

    /* @RequestMapping(value = "/employees/uploadPhoto", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        File newFile = new File("//Users//MSII//Documents//project//punkookms//uploads" + file.getOriginalFilename());
        newFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(newFile);
        fout.write(file.getBytes());
        fout.close();
        return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
    } */

    @PostMapping("/employees/uploadPhoto")
    public String uploadFile2(@RequestParam("file") MultipartFile file, Principal principal)
            throws IllegalStateException, IOException {
        String baseDirectory = "//Users//MSII//Documents//project//punkookms//src//main//resources//static//img//photos//";
        file.transferTo(new File(baseDirectory + principal.getName() + ".jpg"));
        return "redirect:/employees";
    }

    /* @PostMapping("/employees/uploadPhoto3")
	public String uploadFile3(@RequestParam("file") MultipartFile file, Principal principal)
			throws IllegalStateException, IOException {
		String photosDir = "/Users/MSII/Documents/project/punkookms/src/main/resources/static/img/photos/";
		file.transferTo(new File(photosDir + principal.getName() + ".jpg"));
		return "redirect:/employees";
	} */

    @RequestMapping(value = "/employee/profile")
    public String profile(Model model, Principal principal) {
        String un = principal.getName();
        addModelAttributes(model);
        model.addAttribute("employee", employeeService.findByUsername(un));
        return "profile";
    }
}
