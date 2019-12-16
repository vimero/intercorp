package io.vimero.intercorp.api.controller;

import io.architecture.response.ResponseACK;
import io.vimero.intercorp.api.data.CustomerData;
import io.vimero.intercorp.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rony Villanueva <rony@vimero.io>
 * @since 15/12/2019
 */

@RestController
@RequestMapping("v1/customer-management/customers")
public class CustomerController {

    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable String id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CustomerData data){
        ResponseACK resource = service.save(data);
        return ResponseEntity.ok(resource);
    }

    @GetMapping("/kpi")
    public ResponseEntity getKPI(){
        return ResponseEntity.ok(service.getKPI());
    }

}
