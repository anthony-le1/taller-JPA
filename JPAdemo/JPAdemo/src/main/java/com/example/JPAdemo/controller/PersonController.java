package com.example.JPAdemo.controller;

import com.example.JPAdemo.model.Person;
import com.example.JPAdemo.service.IPersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demoJPA")
public class PersonController {

    private final IPersonService personService;

    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<Person> getAll(){return personService.getPersons();}

    @GetMapping("/persons/{id}")
    public Person getById(@PathVariable long id){return personService.findPerson(id);}

    @PostMapping("/persons")
    public String save(@RequestBody Person person){
        personService.savePerson(person);
        return "La persona fue creada correctamente";
    }

    @PatchMapping("/{id}")
    public Person update(@PathVariable Long id, @RequestBody Person person){
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("/persons/{id}")
    public String delete(@PathVariable Long id){
        personService.deletePerson(id);
        return "Persona eliminada correctamente";
    }
}
