package com.company.inventory.controller;

import com.company.inventory.model.Category;
import com.company.inventory.response.CategoryResponseRest;
import com.company.inventory.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController  //controller tipo rest
@RequestMapping("/api/v1") //uri de todos los endpoints
public class CategoryRestController {
     @Autowired //inyecta la interfaz para tener disponible todos sus metodos
    private ICategoryService service;
   //este metodo va a ser el punto de entrada para obtener todas las categorias

    /**
     * get all the categories
     * @return
     */
    @GetMapping("/categories") //complete la uri del endpoint categorias e ingresa al siguiente metodo
    public ResponseEntity<CategoryResponseRest> searchCategories(){
      ResponseEntity<CategoryResponseRest>response=service.search();
      return response;
    }

    /**
     * get categories by id
     * @param id
     * @return
     */
    @GetMapping("/categories/{id}") //complete la uri del endpoint categorias e ingresa al siguiente metodo
    public ResponseEntity<CategoryResponseRest> searchCategoriesById(@PathVariable Long id){
        ResponseEntity<CategoryResponseRest>response=service.searchById(id);
        return response;
    }
    /**
     * save categories
     * @param
     * @return
     */
    @PostMapping("/categories") //complete la uri del endpoint categorias e ingresa al siguiente metodo
    public ResponseEntity<CategoryResponseRest> saveCategories(@RequestBody Category category){
        ResponseEntity<CategoryResponseRest>response=service.save(category);
        return response;
    }
}
