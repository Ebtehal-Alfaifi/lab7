package com.example.lab7.Controller;

import com.example.lab7.ApiResponse.Api;
import com.example.lab7.Model.TeacherModel;
import com.example.lab7.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeachers() {
        ArrayList<TeacherModel> teacherList = teacherService.getTeachers();
        return ResponseEntity.status(200).body(teacherList);
    }


    // Add Teacher
    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid TeacherModel teacher, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new Api("Add successful"));
    }


    // Update Teacher
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable String id, @RequestBody @Valid TeacherModel teacher, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = teacherService.updateTeacher(id, teacher);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new Api("Update successful"));
        }
        return ResponseEntity.status(400).body(new Api("ID not found"));
    }


    // Delete Teacher
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable String id) {
        boolean isDeleted = teacherService.deleteTeacher(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new Api("Delete successful"));
        }
        return ResponseEntity.status(400).body(new Api("ID not found"));
    }

    //اضافة دروس
    @PostMapping("/addLessons/{id}")
    public ResponseEntity addLessons(@PathVariable String id, @RequestParam int lessons) {
        boolean isUpdated = teacherService.addLessons(id, lessons);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new Api("Lessons added successfully"));
        }
        return ResponseEntity.status(400).body(new Api("Teacher ID not found"));
    }


// اصنف المعلم حسب اللغة الي يدرسها
    @GetMapping("/filterByLanguage/{language}")
    public ResponseEntity getTeachersByLanguage(@PathVariable String language) {
        ArrayList<TeacherModel> teachers = teacherService.getTeachersByLanguage(language);
        return ResponseEntity.status(200).body(teachers);
    }


    //يعرض المعلمين الي قد درسو اكثر من 5 حصص
    @GetMapping("/filterLessons")
    public ResponseEntity getTeachersWithMoreThanFiveLessons() {
        ArrayList<TeacherModel> teachers = teacherService.getTeachersWithMoreThanFiveLessons();
        return ResponseEntity.status(200).body(teachers);
    }



}


















