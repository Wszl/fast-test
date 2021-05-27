package org.xdove.webtest.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xdove.webtest.entity.Example;
import org.xdove.webtest.repository.ExampleRepository;

import java.util.List;

@RestController
@RequestMapping("/example")
public class ExampleRestController  {

    @Autowired
    private ExampleRepository exampleRepository;

    @GetMapping("/{id}")
    public Example get(@PathVariable Long id) {
        return exampleRepository.getOne(id);
    }

    @PutMapping
    public void create(@RequestBody Example example) {
        exampleRepository.save(example);
    }

    @PostMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Example example) {
        final Example one = exampleRepository.getOne(id);
        BeanUtils.copyProperties(example, one);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        exampleRepository.deleteById(id);
    }

    @GetMapping
    public List<Example> list() {
        return exampleRepository.findAll();
    }
}
