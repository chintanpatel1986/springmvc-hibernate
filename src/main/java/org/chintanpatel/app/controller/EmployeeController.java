package org.chintanpatel.app.controller;

import jakarta.validation.Valid;
import org.chintanpatel.app.model.Employee;
import org.chintanpatel.app.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getEmployee")
    public String getEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("employeeList", employeeService.getAllEmployeeList());
        return "employee-form";
    }

    @GetMapping("/saveOrUpdateEmployee")
    public String saveOrUpdateEmployee(@Valid @ModelAttribute("employee")Employee employee, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("employeeList", employeeService.getAllEmployeeList());
            return "employee-form";
        }
        if (employee.getEmployeeId() != null) {
            employee.setEmployeeId(employee.getEmployeeId());
            employeeService.editEmployee(employee);
        } else {
            employeeService.addEmployee(employee);
        }
        return "redirect:/employee/getEmployee";
    }

    @GetMapping("/manageEmployee")
    public String manageEmployee(@RequestParam("employeeId")Long employeeId, Model model){
        if (employeeId != null) {
            model.addAttribute("employee", employeeService.getEmployeeById(employeeId));
            model.addAttribute("employeeList", employeeService.getAllEmployeeList());
        }
        return "employee-form";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId")Long employeeId){
        if (employeeId != null) {
            employeeService.deleteEmployeeById(employeeId);
        }
        return "redirect:/employee/getEmployee";
    }
}
