package com.example.lab7.Controller;

import com.example.lab7.ApiResponse.Api;
import com.example.lab7.Model.StudentModel;
import com.example.lab7.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;


    //get Student List
    @GetMapping("/get")
    public ResponseEntity getStudent(){
        ArrayList<StudentModel>studentList=studentService.getStudent();
        return ResponseEntity.status(200).body(studentList);
    }

    //add Student
@PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid StudentModel studentList, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
       studentService.addStudent(studentList);

return ResponseEntity.status(200).body(new Api("Add successful"));
    }


    //update Student
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable String id,@RequestBody @Valid StudentModel student,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated=studentService.updateStudent(id,student);
        if (isUpdated){
            return ResponseEntity.status(200).body(new Api(" update successful"));
        }
        return ResponseEntity.status(400).body(new Api(" Id not found"));
    }



    //Delete Student
    @DeleteMapping("/delete")
    public ResponseEntity deletStudent(String id){
        boolean isDeleted=studentService.deleteStudent(id);
        if (isDeleted){
            return ResponseEntity.status(200).body(new Api(" deleted successful"));
        }

        return ResponseEntity.status(400).body(new Api(" id not found"));

    }




//add lesson
    @PostMapping("/lessons/{id}")
public ResponseEntity addLesiion(@PathVariable String id,@RequestParam int lessons ){
        boolean isFounded=studentService.addLessons(id,lessons);
        if (isFounded){
            return ResponseEntity.status(200).body("lessons add successful");
        }
        return ResponseEntity.status(400).body(new Api("ID NOT found"));
}



//range
@GetMapping("/students/age")
public ResponseEntity<ArrayList<StudentModel>> getStudentsByAgeRange() {
    ArrayList<StudentModel> studentsByAge = studentService.getRangeofAge();
    return ResponseEntity.status(200).body(studentsByAge);
}



//get by range
    @GetMapping("/students/gender/{gender}")
    public ResponseEntity<ArrayList<StudentModel>> getStudentsByGender(@PathVariable String gender) {
        ArrayList<StudentModel> studentsByGender = studentService.getStudentsByGender(gender);
        return ResponseEntity.ok(studentsByGender);
    }





    //




















}
