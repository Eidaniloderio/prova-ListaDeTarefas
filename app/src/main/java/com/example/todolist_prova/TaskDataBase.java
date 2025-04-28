package com.example.todolist_prova;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Task.class}, version = 1)


public abstract class TaskDataBase extends RoomDatabase {

    private static TaskDataBase instance;

    public abstract TaskDAO taskDAO();

    public static synchronized TaskDataBase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            TaskDataBase.class,
                            "task-database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
