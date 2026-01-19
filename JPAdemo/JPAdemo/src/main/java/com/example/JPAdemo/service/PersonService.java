package com.example.JPAdemo.service;

import com.example.JPAdemo.model.Person;
import com.example.JPAdemo.repository.IPersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService{

    private final IPersonRepository personRepository;

    public PersonService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getPersons() {
        List<Person> listaPersonas = personRepository.findAll();
        return listaPersonas;
    }

    @Override
    public Person findPerson(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person updatePerson(Long id, Person datosNuevos) {
        Person personaExistente = personRepository.findById(id).orElse(null);

        if (personaExistente == null){
            return null; //nbo existe
        }

        //Actualizar solo los campos que vienen con valor
        if(datosNuevos.getName() != null){
            personaExistente.setName(datosNuevos.getName());
        }
        if(datosNuevos.getLastName() != null){
            personaExistente.setLastName(datosNuevos.getLastName());
        }
        if(datosNuevos.getAge() != null){
            personaExistente.setAge(datosNuevos.getAge());
        }

        //Guardar y retornar
        return personRepository.save(personaExistente);
    }
}
