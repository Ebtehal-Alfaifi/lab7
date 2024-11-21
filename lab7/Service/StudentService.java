package com.example.lab7.Service;

import com.example.lab7.Model.StudentModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<StudentModel> studentList = new ArrayList<>();


    //display Student
    public ArrayList<StudentModel> getStudent() {
        return studentList;
    }


    //Add student
    public void addStudent(StudentModel student) {
        studentList.add(student);
    }

    //update Student
    public boolean updateStudent(String id, StudentModel student) {
        for (StudentModel iD : studentList) {
            if (iD.getId().equals(id)) {
                int i = studentList.indexOf(iD);
                studentList.set(i, student);
                return true;
            }
        }

        return false;
    }


    //delete student
    public boolean deleteStudent(String id) {
        for (StudentModel iD : studentList) {
            if (iD.getId().equals(id)) {
                int i = studentList.indexOf(iD);
                studentList.remove(i);
                return true;
            }
        }
        return false;
    }


    //add lessons
    public boolean addLessons(String id, int additionalLessons) {
        for (StudentModel student : studentList) {
            if (student.getId().equals(id)) {

                int updatedLessons = student.getLesion() + additionalLessons;
                student.setLesion(updatedLessons);

                if (updatedLessons >= 30) {
                    student.setFinish(true);  //اغير اذا الطالب تم انتهائه او لا
                } else if (updatedLessons >= 15) {
                    student.setStudentLevel("intermediate");
                } else {
                    student.setStudentLevel("beginner");
                }

                return true;
            }
        }
        return false;
    }



//range
    public ArrayList<StudentModel> getRangeofAge(){
        ArrayList<StudentModel>range=new ArrayList<>();
        for (StudentModel rangeAge:studentList){
            if (rangeAge.getAge() >= 15 && rangeAge.getAge() <= 18) {
                range.add(rangeAge);
            }
        }


    return range;



    }
// get gender
    public ArrayList<StudentModel> getStudentsByGender(String gender) {
        ArrayList<StudentModel> filterGender = new ArrayList<>();
        for (StudentModel student : studentList) {
            if (student.getGender().equalsIgnoreCase(gender)) {
                filterGender.add(student);
            }
        }
        return filterGender;
    }



//



}


































