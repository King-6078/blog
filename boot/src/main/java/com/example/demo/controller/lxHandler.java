package com.example.demo.controller;



import com.example.demo.entity.lx;
import com.example.demo.repository.LxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/lx")
public class lxHandler {

    @Autowired
    private LxRepository lxRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<lx> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable= PageRequest.of(page-1,size);
        return lxRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody lx lx){
        lx result=lxRepository.save(lx);
        if(result!=null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public lx findById(@PathVariable("id") Integer id){
        return lxRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody lx lx){
        lx result=lxRepository.save(lx);
        if(result!=null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        lxRepository.deleteById(id);
    }

}
