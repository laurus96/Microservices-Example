package com.example.galleryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(path = "/gallery")
public class HomeController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @RequestMapping
    public String Home() {
        return "Hello from Gallery Service runnig at port: " + env.getProperty("local.server.port");
    }

    @RequestMapping(path = "/{id}")
    public Gallery getGallery(@PathVariable final int id){
        Gallery gallery = new Gallery();
        gallery.setId(id);

        List<Object> images = restTemplate.getForObject("http://image-service/image/all", List.class);
        gallery.setImages(images);

        return gallery;
    }

    @RequestMapping(path = "/admin")
    public String homeAdmin(){
        return "this is the admin area of Gallery Service running at port: " + env.getProperty("local.server.port");
    }
}
