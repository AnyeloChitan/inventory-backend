package com.company.inventory.controller;

import com.company.inventory.response.CategoryResponseRest;
import com.company.inventory.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //controller tipo rest
@RequestMapping("/api/v1") //uri de todos los endpoints
public class CategoryRestController {
     @Autowired //inyecta la interfaz para tener disponible todos sus metodos
    private ICategoryService service;
   //este metodo va a ser el punto de entrada para obtener todas las categorias
    @GetMapping("/categories") //complete la uri del endpoint categorias e ingresa al siguiente metodo
    public ResponseEntity<CategoryResponseRest> searchCategories(){
      ResponseEntity<CategoryResponseRest>response=service.search();
      return response;
    }
}
