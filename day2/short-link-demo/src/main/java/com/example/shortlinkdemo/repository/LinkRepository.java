package com.example.shortlinkdemo.repository;

import com.example.shortlinkdemo.models.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<LinkModel, String> {
    public LinkModel findByRealLink(String shortLink);
    public LinkModel findByShortLink(String ShortLink);
}
