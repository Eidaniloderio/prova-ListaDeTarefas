package com.example.todolist_prova;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface TaskDAO {
    @Insert
    void insert(Task task);

    @Query("SELECT * FROM task")
    List<Task> getAllTasks();

}
