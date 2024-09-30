package com.example.inicial1.controllers;
import com.example.inicial1.entities.Autor;
import com.example.inicial1.services.AutorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/autores")
@CrossOrigin(origins = "*")
public class AutorController extends BaseControllerImpl<Autor, AutorServiceImpl>{
    @Autowired
    AutorServiceImpl autorServiceImpl;


}