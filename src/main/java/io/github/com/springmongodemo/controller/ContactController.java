package io.github.com.springmongodemo.controller;

import io.github.com.springmongodemo.model.Contact;
import io.github.com.springmongodemo.repository.ContactRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Contact getContactById(@PathVariable("id") ObjectId id) {
        return contactRepository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyContactById(@PathVariable("id") ObjectId id, @Valid @RequestBody Contact contact) {
        contact.set_id(id);
        contactRepository.save(contact);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Contact createContact(@Valid @RequestBody Contact contact) {
        contact.set_id(ObjectId.get());
        contactRepository.save(contact);
        return contact;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteContact(@PathVariable ObjectId id) {
        contactRepository.delete(contactRepository.findBy_id(id));
    }
}
