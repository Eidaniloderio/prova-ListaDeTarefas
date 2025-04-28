package com.example.todolist_prova;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Task {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String titulo;
    private String descricao;


    public Task(String titulo, String descricao){
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public int getId() { return id; }
    // Define o ID do usuário (usado pelo Room para preencher automaticamente)
    public void setId(int id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }

}
