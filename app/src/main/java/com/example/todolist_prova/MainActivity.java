package com.example.todolist_prova;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText txtNomeTask, txtDescricaoTask;

    private TaskDAO taskDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNomeTask = findViewById(R.id.txtNomeTask);
        txtDescricaoTask = findViewById(R.id.txtDescricaoTask);
        TextView textViewTasks = findViewById(R.id.textViewTasks);

        Button btnSalvar = findViewById(R.id.btnSalvar);

        TaskDataBase db = Room.databaseBuilder(getApplicationContext(), TaskDataBase.class, "task-database").allowMainThreadQueries().build();

        taskDAO = db.taskDAO();

        btnSalvar.setOnClickListener(v -> {
            Log.d("MainActivity", "Botão clicado com sucesso!");

            String nome = txtNomeTask.getText().toString();
            String descricao = txtDescricaoTask.getText().toString();


            if(nome.isEmpty() || descricao.isEmpty()){
                Log.d("MainActivity", "Erro: Campos obrigatórios não preenchidos");

                Toast.makeText(MainActivity.this, "Preencha os campos obrigatórios", Toast.LENGTH_SHORT).show();
            }
            else{
                Task task = new Task(nome, descricao);
                taskDAO.insert(task);

                List<Task> listaTask = taskDAO.getAllTasks();

                StringBuilder tasks =  new StringBuilder();

                for (Task item : listaTask){
                            tasks.append(item.getTitulo())
                            .append(":")
                            .append(item.getDescricao())
                            .append("\n\n");
                }

                textViewTasks.setText(tasks.toString());

            }
        });
    }
}