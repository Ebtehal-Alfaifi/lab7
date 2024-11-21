package com.example.lab7.Service;

import com.example.lab7.Model.LanguageModel;
import com.example.lab7.Model.StudentModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LanguageService {

    ArrayList<LanguageModel> languages = new ArrayList<>();

    //GET ALL language
    public ArrayList<LanguageModel> getLanguages() {
        return languages;
    }

    //add language
    public void addLanguage(LanguageModel language) {
        languages.add(language);
    }

//update
    public boolean updateLanguage(String languageName, LanguageModel updatedLanguage) {
        for (LanguageModel language : languages) {
            if (language.getLanguageName().equals(languageName)) {
                int index = languages.indexOf(language);
                languages.set(index, updatedLanguage);
                return true;
            }
        }
        return false;
    }


// يحذف
    public boolean deleteLanguage(String languageName) {
        for (int i = 0; i < languages.size(); i++) {
            if (languages.get(i).getLanguageName().equals(languageName)) {
                languages.remove(i);
                return true;
            }
        }
        return false;
    }

    // يبحث بواسطة الاسم
    public LanguageModel getLanguageByName(String languageName) {
        for (LanguageModel language : languages) {
            if (language.getLanguageName().equalsIgnoreCase(languageName)) {
                return language;
            }
        }
        return null;
    }


    // يبحث عن اللغة بواسطة المستوى
    public ArrayList<LanguageModel> getLanguagesByLevel(String level) {
        ArrayList<LanguageModel> result = new ArrayList<>();
        for (LanguageModel language : languages) {
            if (language.getLanguageLevel().equalsIgnoreCase(level)) {
                result.add(language);
            }
        }
        return result;
    }



}
