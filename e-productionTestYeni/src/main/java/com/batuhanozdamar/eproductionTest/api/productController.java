package com.batuhanozdamar.eproductionTest.api;

import com.batuhanozdamar.eproductionTest.dto.productDto;
import com.batuhanozdamar.eproductionTest.service.implementation.productServiceImpl;
import com.batuhanozdamar.eproductionTest.util.ApiPaths;
import com.batuhanozdamar.eproductionTest.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPaths.ProductCtrl.CTRL)
@Api(value = ApiPaths.ProductCtrl.CTRL, description = "Product APIs")
@Slf4j
@CrossOrigin("http://localhost:4200")
public class productController {

        private final productServiceImpl productServiceImpl;

        public productController(productServiceImpl productServiceImpl) {
            this.productServiceImpl = productServiceImpl;
        }

        @GetMapping("/pagination")
        @ApiOperation(value = "Get By Pagination Operation", response = productDto.class)
        public ResponseEntity<TPage<productDto>> getAllByPagination(Pageable pageable) {
            TPage<productDto> data = productServiceImpl.getAllPageable(pageable);
            return ResponseEntity.ok(data);
        }

        @GetMapping()
        @ApiOperation(value = "Get All Operation", response = productDto.class , responseContainer = "List")
        public ResponseEntity<List<productDto>> getAll() {
            List<productDto> data = productServiceImpl.getAll();
            return ResponseEntity.ok(data);
        }

        @GetMapping("/{id}")
        @ApiOperation(value = "Get By Id Operation", response = productDto.class)
        public ResponseEntity<productDto> getById(@PathVariable(value = "id", required = true) Long id) {
            log.info("ProductController-> GetByID ");
            log.debug("ProductController-> GetByID -> PARAM:" + id);
            productDto productDto = productServiceImpl.getById(id);
            return ResponseEntity.ok(productDto);
        }

        @PostMapping
        @ApiOperation(value = "Create Operation", response = productDto.class)
        public ResponseEntity<productDto> createProject(@Valid @RequestBody productDto product) {
            return ResponseEntity.ok(productServiceImpl.save(product));
        }

        @PutMapping("/{id}")
        @ApiOperation(value = "Update Operation", response = productDto.class)
        public ResponseEntity<productDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody productDto product) {
            return ResponseEntity.ok(productServiceImpl.update(id, product));
        }

        @DeleteMapping("/{id}")
        @ApiOperation(value = "Delete Operation", response = Boolean.class)
        public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
            return ResponseEntity.ok(productServiceImpl.delete(id));
        }


}
