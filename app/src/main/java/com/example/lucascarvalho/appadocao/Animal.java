package com.example.lucascarvalho.appadocao;

/**
 * Created by Lucas Carvalho on 16/10/2017.
 */

public class Animal {
    private int id;
    private String name;
    private String descricao;
    private byte[] image;

    public Animal(int id, String name, String descricao, byte[] image) {
        this.id = id;
        this.name = name;
        this.descricao = descricao;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
