package com.example.demo.repository;

import com.example.demo.entity.lx;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class LxRepositoryTest {

    @Autowired
    private  LxRepository lxRepository;

    @Test
    void findAll(){
        System.out.println(lxRepository.findAll());
    }

    @Test
    void findById(){
        lx lx= lxRepository.findById(1).get();
        System.out.println(lx);
    }

    @Test
    void update(){
        lx lx=new lx();
        lx.setId(1);
        lx.setName("测试");
        lx lx2= lxRepository.save(lx);
        System.out.println(lx2);
    }

    @Test
    void delete(){
        lxRepository.deleteById(203);
    }
}