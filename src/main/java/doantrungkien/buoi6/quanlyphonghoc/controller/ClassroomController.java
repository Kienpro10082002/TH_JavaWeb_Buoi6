package doantrungkien.buoi6.quanlyphonghoc.controller;

import doantrungkien.buoi6.quanlyphonghoc.model.Classroom;
import doantrungkien.buoi6.quanlyphonghoc.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @GetMapping("/view")
    public String viewClassroom(Model model) {
        model.addAttribute("listClassroom", classroomService.getAllClassrooms());
        return "view_classroom";
    }

    @GetMapping("/add")
    public String showNewClassroomPage(Model model) {
        Classroom classroom = new Classroom();
        model.addAttribute("classroom", classroom);
        return "create_classroom";
    }

    @PostMapping("/save")
    public String saveClassroom(@ModelAttribute("classroom") Classroom classroom, Model model) {
        classroomService.createClassroom(classroom);
        return "redirect:/classroom/view";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Classroom classroom = classroomService.getClassroomById(id);
        model.addAttribute("classroom", classroom);
        return "update_classroom";
    }

    @GetMapping("/delete/{id}")
    public String deleteClassroom(@PathVariable("id") long id) {
        classroomService.deleteClassroom(id);
        return "redirect:/classroom/view";
    }
}
