package com.backenwebmail.modelo;

import org.springframework.stereotype.Component;


public class CuerpoDeCorreo2 {

    private String subject;
    private String content;
    private String categoria;
    private byte[] fileToAttach;


    public CuerpoDeCorreo2() {
    }

    public byte[] getFileToAttach() {
        return fileToAttach;
    }

    public void setFileToAttach(byte[] fileToAttach) {
        this.fileToAttach = fileToAttach;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategoria() { return categoria; }

    public void setCategoria(String categoria) { this.categoria = categoria;}

    @Override
    public String toString() {
        return "CuerpoDeCorreo2{" +
                "subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", categoria='" + categoria + '\'' +
                ", fileToAttach='" + fileToAttach + '\'' +
                '}';
    }
}
