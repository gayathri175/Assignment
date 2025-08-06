package com.example.resttemplate_consumer.service;

import com.example.resttemplate_consumer.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    private static final String API_URL = "https://jsonplaceholder.typicode.com/posts";

    @Autowired
    private RestTemplate restTemplate;

    // GET request to retrieve all posts
    public List<Post> getAllPosts() {
        ResponseEntity<Post[]> response = restTemplate.exchange(API_URL, HttpMethod.GET, null, Post[].class);
        return Arrays.asList(response.getBody());
    }

    // GET request to retrieve a single post by ID
    public Post getPostById(int id) {
        String url = API_URL + "/" + id;
        return restTemplate.getForObject(url, Post.class);
    }

    // POST request to create a new post
    public Post createPost(Post post) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Post> entity = new HttpEntity<>(post, headers);
        return restTemplate.postForObject(API_URL, entity, Post.class);
    }

    // PUT request to update a post
    public Post updatePost(int id, Post post) {
        String url = API_URL + "/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Post> entity = new HttpEntity<>(post, headers);
        restTemplate.put(url, entity);
        return post;
    }

    // DELETE request to delete a post by ID
    public void deletePost(int id) {
        String url = API_URL + "/" + id;
        restTemplate.delete(url);
    }
}
