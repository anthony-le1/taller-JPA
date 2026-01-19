package com.example.JPAdemo.service;

import com.example.JPAdemo.model.Person;

import java.util.List;

public interface IPersonService {
    //metodo para crear a todas las personas
    public List<Person> getPersons();

    //método para traer una persona en especifico
    public Person findPerson(Long id);

    //método para guardar personas
    public void savePerson(Person person);

    //método para eliminar personas
    public void deletePerson(Long id);

    //metodo para actualizar una persona
    public Person updatePerson(Long id, Person datosNuevos);


}
