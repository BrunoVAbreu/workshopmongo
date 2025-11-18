package com.brunovaz.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunovaz.workshopmongo.domain.Post;
import com.brunovaz.workshopmongo.repository.PostRepository;
import com.brunovaz.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
