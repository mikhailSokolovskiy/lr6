package com.sokolovskiy.lr6.dao;

import com.sokolovskiy.lr6.entity.Discipline;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineDAO {
    List<Discipline> getAllDisciplines();

    Discipline getDiscipline(int id);

    void deleteDiscipline(int id);

    Discipline saveDiscipline(Discipline discipline);
}
