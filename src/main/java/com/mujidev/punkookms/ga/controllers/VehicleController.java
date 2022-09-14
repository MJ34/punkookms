package com.mujidev.punkookms.ga.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mujidev.punkookms.ga.models.Vehicle;
import com.mujidev.punkookms.ga.services.VehicleMakeService;
import com.mujidev.punkookms.ga.services.VehicleModelService;
import com.mujidev.punkookms.ga.services.VehicleService;
import com.mujidev.punkookms.ga.services.VehicleStatusService;
import com.mujidev.punkookms.ga.services.VehicleTypeService;
import com.mujidev.punkookms.hr.services.EmployeeService;
import com.mujidev.punkookms.parameters.services.LocationService;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleTypeService vehicleTypeService;
    @Autowired
    private VehicleMakeService vehicleMakeService;
    @Autowired
    private VehicleModelService vehicleModelService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private VehicleStatusService vehicleStatusService;

    public Model addModelAttributes(Model model) {
        model.addAttribute("vehicles", vehicleService.findAll());
        model.addAttribute("vehicleTypes", vehicleTypeService.findAll());
        model.addAttribute("vehicleModels", vehicleModelService.findAll());
        model.addAttribute("vehicleMakes", vehicleMakeService.findAll());
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("vehicleStatuses", vehicleStatusService.findAll());
        return model;
    }

    // Get All Vehicles
    @GetMapping("/fleet/vehicles")
    public String findAll(Model model) {
        addModelAttributes(model);
        return "/ga/vehicles";
    }

    @GetMapping("/fleet/vehicleAdd")
    public String addVehicle(Model model) {
        addModelAttributes(model);
        return "ga/vehicleAdd";
    }

    // The op parameter is either Edit or Details
    @GetMapping("/fleet/vehicle/{op}/{id}")
    public String editVehicle(@PathVariable Integer id, @PathVariable String op, Model model) {
        Vehicle vehicle = vehicleService.findById(id);
        model.addAttribute("vehicle", vehicle);
        addModelAttributes(model);
        return "/ga/vehicle" + op; // returns vehicleEdit or vehicleDetails
    }

    // Add Vehicle
    @PostMapping("/fleet/vehicles")
    public String addNew(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/ga/vehicles";
    }

    @RequestMapping(value = "/fleet/vehicle/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String delete(@PathVariable Integer id) {
        vehicleService.delete(id);
        return "redirect:/ga/vehicles";
    }
}
