package com.company.inventory.service;

import com.company.inventory.dao.ICategoryDao;
import com.company.inventory.model.Category;
import com.company.inventory.response.CategoryResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Executable;
import java.util.List;

@Service     //indica que esta es una clase de servicio
public class CategoryServiceImpl implements ICategoryService {
    @Autowired      //inyecta objeto al contenedor de Spring
    private ICategoryDao categoryDao;
    @Override
    @Transactional(readOnly = true)  //declara este metodo como transaccional
    public ResponseEntity<CategoryResponseRest> search() {
      CategoryResponseRest response =new CategoryResponseRest();
      try{
         List<Category> category = (List<Category>) categoryDao.findAll();
         response.getCategoryResponse().setCategory(category);
         response.setMetadata("Respuesta ok","00","respuesata exitosa");
      }catch (Exception e){
          response.setMetadata("Respuesta nok","-1","error al consultar");
          e.getStackTrace();
          return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      }
      return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    }
}
