package com.cardgameproject.cardgame.controller;
import com.cardgameproject.cardgame.entity.OriginalCard;
import com.cardgameproject.cardgame.repository.OriginalCardRepository;
import com.cardgameproject.cardgame.service.OriginalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = {"https://fast-dusk-75315.herokuapp.com" , "http://localhost:3000"},
        methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
        , allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class InformationController {
    private final OriginalCardService originalCardService;
    private final OriginalCardRepository originalCardRepository;

    @Autowired
    public InformationController(OriginalCardService originalCardService, OriginalCardRepository originalCardRepository) {
        this.originalCardService = originalCardService;
        this.originalCardRepository = originalCardRepository;
    }

    @GetMapping(value = "/originalcards")
    public Page<OriginalCard> getOriginalCards(@RequestParam int page, @RequestParam int size){
        PageRequest pageRequest = PageRequest.of(page,size);
        return originalCardRepository.findAll(pageRequest);
    }
}
