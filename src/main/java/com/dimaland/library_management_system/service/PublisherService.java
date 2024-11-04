package com.dimaland.library_management_system.service;

import com.dimaland.library_management_system.entity.Publisher;
import com.dimaland.library_management_system.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher getByName(String name) {
        return publisherRepository.findByName(name);
    }

    public List<Publisher> getAllPublishers(){
        return publisherRepository.findAll();
    }

    public Publisher getPublisherById(int id){
        return publisherRepository.findById(id).orElse(null);
    }

    public void savePublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public void deletePublisherById(int id){
        publisherRepository.deleteById(id);
    }
}
