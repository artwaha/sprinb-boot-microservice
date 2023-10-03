package com.atwaha.school;

import com.atwaha.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }


    public FullSchoolResponse getSchoolsWithStudents(Integer schoolId) {
        var school = schoolRepository.findById(schoolId)
                .orElse(
                        School.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );

//        var school = schoolRepository.findById(schoolId)
//                .orElseThrow(() -> new EntityNotFoundException("Invalid School Id"));

        var students = studentClient.getAllStudentsBySchool(schoolId);

        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();

    }
}
