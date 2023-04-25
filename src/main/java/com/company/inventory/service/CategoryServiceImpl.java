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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> searchById(Long id) {
        CategoryResponseRest response =new CategoryResponseRest();
        List<Category>list=new ArrayList<>();
        try{
            Optional<Category> category=categoryDao.findById(id);
            if (category.isPresent()){
                list.add(category.get());
                response.getCategoryResponse().setCategory(list);
                response.setMetadata("Respuesta ok","00","categoria  encontrada");
            }else {
                response.setMetadata("Respuesta nok","-1","categoria no encontrada");
                return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            response.setMetadata("Respuesta nok","-1","error al consultar por id");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    }
}
