package com.company.inventory.response;

import jakarta.persistence.SecondaryTable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponseRest extends ResponseRest {
    private CategoryResponse categoryResponse= new CategoryResponse();

}
