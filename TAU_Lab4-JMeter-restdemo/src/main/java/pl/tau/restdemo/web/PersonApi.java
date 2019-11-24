package pl.tau.restdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.tau.restdemo.domain.Person;
import pl.tau.restdemo.service.PersonManager;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Simple web api demo -- try implementning post method
 * 
 * Created by tp on 24.04.17.
 */
@RestController
public class PersonApi {

    @Autowired
    PersonManager personManager;

    @RequestMapping("/")
    public String index() {
        return "This is non rest, just checking if everything works.";
    }

    @RequestMapping(value = "/person/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Person getPerson(@PathVariable("id") Long id) throws SQLException {
        return personManager.getPerson(id);
    }

    @RequestMapping(value = "/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Person> getPersons(@RequestParam(value = "filter", required = false) String f) throws SQLException {
        List<Person> persons = new LinkedList<Person>();
        for (Person p : personManager.getAllPersons()) {
            if (f == null) {
                persons.add(p);
            } else if (p.getName().contains(f)) {
                persons.add(p);
            }
        }
        return persons;
    }

    @RequestMapping(value = "/person",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Person addPerson(@RequestBody Person p) {
        if (personManager.addPerson(p) < 1) return null;
        return p;
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Long deletePerson(@PathVariable("id") Long id) throws SQLException {
        return new Long(personManager.deletePerson(personManager.getPerson(id)));
    }

//

    @RequestMapping(value = "/persons", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAllPersons() throws SQLException {
        personManager.deleteAll();
    }

    @RequestMapping(value = "/person",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person updatePerson(@RequestBody Person a) throws SQLException {
        if (personManager.updatePerson(a) < 1) return null;
        return a;
    }

}
