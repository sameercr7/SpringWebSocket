package org.example.hello1.Controller;

import org.example.hello1.Entity.Employee;
import org.example.hello1.Service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/user")
public class userController {

    @Autowired
    private employeeService empService;

    @GetMapping(path = "registration")
    public String firstMethod(Model model){

        List<Employee>  allEmployeeData=empService.findAllData();
        model.addAttribute("allEmployeeData",allEmployeeData);
        return "Forms/forms";

    }

    @PostMapping(path = "formSubmission")
    public String formSubmission(@ModelAttribute Employee employee){

empService.saveFormDetail(employee);
        return "redirect:/user/registration";

    }

    @GetMapping(path = "employees/{id}")
    public String getEmployeeById(@PathVariable Long id, Model model) {
        Employee employee;
        employee = empService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employeeDetail";
    }

    @PostMapping(path = "/updateformSubmission")
    public String updateEmployee( @ModelAttribute Employee employeeDetails) {

        empService.updateEmployee( employeeDetails);
        return "redirect:/user/registration";
    }



    @GetMapping(path = "delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id) {
        empService.deleteEmployee(id);
//        Redirect ka mtlb hota h ki usi same page pe pnchana jaise tera home page ka end point dkho kya h (ye h registration)
//        Get mapping Post mapping do hoti h ....dkho data dono mein hi le jaaskte h okay

        return "redirect:/user/registration";
    }


}


