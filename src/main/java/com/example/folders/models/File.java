package com.example.folders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "folders")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "extension")
    private String extension;

    @Column(name = "size")
    private int size;

    @ManyToOne
    @JoinColumn(name = "folder_id")
    @JsonIgnoreProperties({"files"})
    private Folder folder;

    public File(String title, String extension, int size, Folder folder){
        this.title = title;
        this.extension = extension;
        this.size = size;
        this.folder = folder;

    }

    public File(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}
