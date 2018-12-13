package io.github.com.springmongodemo.repository;

import io.github.com.springmongodemo.model.Contact;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {
    Contact findBy_id(ObjectId _id);
}
