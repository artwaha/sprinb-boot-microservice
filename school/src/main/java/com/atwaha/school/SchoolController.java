package com.atwaha.school;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school) {
        schoolService.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> getAllSchools() {
        return ResponseEntity.ok(schoolService.getAllSchools());
    }

    @GetMapping("with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> getAllSchoolsWithStudents(@PathVariable("school-id") Integer schoolId) {
        return ResponseEntity.ok(schoolService.getSchoolsWithStudents(schoolId));
    }
}
