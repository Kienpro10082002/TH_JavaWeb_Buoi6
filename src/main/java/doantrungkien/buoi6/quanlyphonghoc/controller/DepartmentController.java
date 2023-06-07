package doantrungkien.buoi6.quanlyphonghoc.controller;

import doantrungkien.buoi6.quanlyphonghoc.model.Department;
import doantrungkien.buoi6.quanlyphonghoc.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/view")
    public String viewDepartment(Model model) {
        model.addAttribute("listDepartment", departmentService.getAllDepartments());
        return "view_department";
    }

    @GetMapping("/add")
    public String showNewDepartmentPage(Model model) {
        Department department = new Department();
        model.addAttribute("department", department);
        return "create_department";
    }

    @PostMapping("/save")
    public String saveDepartment(@ModelAttribute("department") Department department, Model model) {
        departmentService.createDepartment(department);
        return "redirect:/department/view";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Department department = departmentService.getDepartmentById(id);
        model.addAttribute("department", department);
        return "update_department";
    }

    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable("id") long id) {
        departmentService.deleteDepartment(id);
        return "redirect:/department/view";
    }
}
