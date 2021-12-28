package com.adamcardoso.workshopmongo.resources;

import com.adamcardoso.workshopmongo.domain.Post;
import com.adamcardoso.workshopmongo.domain.User;
import com.adamcardoso.workshopmongo.dto.UserDTO;
import com.adamcardoso.workshopmongo.repository.util.URL;
import com.adamcardoso.workshopmongo.services.PostService;
import com.adamcardoso.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);

        return ResponseEntity.ok().body(obj); // retorna as respostas http
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);

        return ResponseEntity.ok().body(list); // retorna as respostas http
    }
}
