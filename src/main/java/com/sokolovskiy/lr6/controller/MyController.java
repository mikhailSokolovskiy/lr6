package com.sokolovskiy.lr6.controller;


import com.sokolovskiy.lr6.entity.Discipline;
import com.sokolovskiy.lr6.entity.Student;
import com.sokolovskiy.lr6.service.DisciplineService;
import com.sokolovskiy.lr6.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private DisciplineService disciplineService;

    @GetMapping("/students")
    public ApiResponse<List<Student>>allStudents() {
        try {
            return new ApiResponse<>(true, "Запрос успешно выполнен", studentService.getAllStudents());
        } catch (Exception e) {
            return new ApiResponse<>(false, "Ошибка при выполнении запроса", null);
        }
    }

    @GetMapping("/students/{id}")
    public ApiResponse<Student> getStudent(@PathVariable("id") int id) {
        try {
            return new ApiResponse<>(true, "Запрос успешно выполнен", studentService.getStudent(id));
        } catch (Exception e) {
            return new ApiResponse<>(false, "Ошибка при выполнении запроса", null);
        }
    }

    @PostMapping("/students")
    public ApiResponse<Student> saveStudent(@RequestBody Student student) {
        try {
            return new ApiResponse<>(true, "Объект успешно создан", studentService.saveStudent(student));
        } catch (Exception e) {
            return new ApiResponse<>(false, "Ошибка при выполнении запроса", null);
        }
    }

    @PutMapping("/students")
    public ApiResponse <Student> updateStudent(@RequestBody Student student) {
        try {
            return new ApiResponse<>(true, "Объект успешно обновлен", studentService.saveStudent(student));
        } catch (Exception e) {
            return new ApiResponse<>(false, "Ошибка при выполнении запроса", null);
        }
    }

    @DeleteMapping("/students/{id}")
    public ApiResponse<Integer> deleteStudent(@PathVariable("id") int id) {
        try {
            studentService.deleteStudent(id);
            return new ApiResponse<>(true, "Объект успешно удален", id);
        } catch (Exception e) {
            return new ApiResponse<>(false, "Ошибка при выполнении запроса", null);
        }
    }

    @GetMapping("/disciplines")
    public ApiResponse<List<Discipline>>allDisciplines() {
        try {
            return new ApiResponse<>(true, "Запрос успешно выполнен", disciplineService.getAllDisciplines());
        } catch (Exception e) {
            return new ApiResponse<>(false, "Ошибка при выполнении запроса", null);
        }
    }

    @PostMapping("/disciplines")
    public ApiResponse<Discipline> saveDiscipline(@RequestBody Discipline discipline) {
        try {

            return new ApiResponse<>(true, "Объект успешно создан", disciplineService.saveDiscipline(discipline));
        } catch (Exception e) {
            return new ApiResponse<>(false, "Ошибка при выполнении запроса", null);
        }
    }

}
