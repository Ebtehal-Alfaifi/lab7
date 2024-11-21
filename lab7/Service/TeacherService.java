package com.example.lab7.Service;

import com.example.lab7.Model.TeacherModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
     ArrayList<TeacherModel> teachers = new ArrayList<>();

    public void addTeacher(TeacherModel teacher) {
        teachers.add(teacher);
    }


    public ArrayList<TeacherModel> getTeachers() {
        return teachers;
    }


    public boolean updateTeacher(String id, TeacherModel updatedTeacher) {
        for (TeacherModel teacher : teachers) {
            if (teacher.getId().equals(id)) {
               int i=teachers.indexOf(teacher);
               teachers.set(i,updatedTeacher);
                return true;
            }
        }
        return false;
    }


    public boolean deleteTeacher(String id) {
        for (TeacherModel teacher : teachers) {
            if (teacher.getId().equals(id)) {
                int i = teachers.indexOf(teacher);
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }



//زيادة مجموع الدروس التي قدمها المعلم
    public boolean addLessons(String id, int lessons) {
        for (TeacherModel teacher : teachers) {
            if (teacher.getId().equals(id)) {
                teacher.setHowManyLissonGive(teacher.getHowManyLissonGive() + lessons);
                return true;
            }
        }
        return false;
    }

    // فلتر المعلمين حسب اللغة التي يدرسها
    public ArrayList<TeacherModel> getTeachersByLanguage(String language) {
        ArrayList<TeacherModel> result = new ArrayList<>();
        for (TeacherModel teacher : teachers) {
            if (teacher.getTeacherForWichLanguage().equalsIgnoreCase(language)) {
                result.add(teacher);
            }
        }
        return result;
    }

    // فلتر المعلمين الذين لديهم أكثر من 5 دروس
    public ArrayList<TeacherModel> getTeachersWithMoreThanFiveLessons() {
        ArrayList<TeacherModel> result = new ArrayList<>();
        for (TeacherModel teacher : teachers) {
            if (teacher.getHowManyLissonGive() > 5) {
                result.add(teacher);
            }
        }
        return result;
    }
}

