package com.example.lab7.Controller;

import com.example.lab7.ApiResponse.Api;
import com.example.lab7.Model.LanguageModel;
import com.example.lab7.Service.LanguageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/language")
public class LanguageController {
    private final LanguageService languageService;



    @GetMapping("/get")
    public ResponseEntity getLanguages() {
        ArrayList<LanguageModel> languageList = languageService.getLanguages();
        return ResponseEntity.status(200).body(languageList);
    }

    // Add Language
    @PostMapping("/add")
    public ResponseEntity addLanguage(@RequestBody @Valid LanguageModel language, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        languageService.addLanguage(language);
        return ResponseEntity.status(200).body(new Api("Add successful"));
    }

    // Update Language
    @PutMapping("/update/{languageName}")
    public ResponseEntity updateLanguage(@PathVariable String languageName, @RequestBody @Valid LanguageModel language, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = languageService.updateLanguage(languageName, language);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new Api("Update successful"));
        }
        return ResponseEntity.status(400).body(new Api("Language not found"));
    }

    // Delete Language
    @DeleteMapping("/delete/{languageName}")
    public ResponseEntity deleteLanguage(@PathVariable String languageName) {
        boolean isDeleted = languageService.deleteLanguage(languageName);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new Api("Delete successful"));
        }
        return ResponseEntity.status(400).body(new Api("Language not found"));
    }





    // Get Languages by Level
    @GetMapping("/level/{level}")
    public ResponseEntity<ArrayList<LanguageModel>> getLanguagesByLevel(@PathVariable String level) {
        ArrayList<LanguageModel> languagesByLevel = languageService.getLanguagesByLevel(level);
        return ResponseEntity.status(200).body(languagesByLevel);
    }

    @GetMapping("/get/{languageName}")
    public ResponseEntity<LanguageModel> getLanguageByName(@PathVariable String languageName) {
        LanguageModel language = languageService.getLanguageByName(languageName);
        if (language != null) {
            return ResponseEntity.status(200).body(language);
        }
        return ResponseEntity.status(404).body(null); // إذا لم يتم العثور على اللغة
    }


}
