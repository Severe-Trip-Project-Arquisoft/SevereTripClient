package com.user.web.controller;


import com.user.web.service.FavoriteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;

@Api(value="Favorites Management Service", description="Operations pertaining to customer favorites.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/favorites")
@CrossOrigin(origins = "*")
public class FavoriteController {

    private FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @ApiOperation(value = "See all user favorites.",response = List.class)
    @GetMapping("/{clientId}")
    public ResponseEntity<List<String>> getFavorites(@PathVariable String clientId){
        return new ResponseEntity<>(new LinkedList<>(favoriteService.getFavorites(clientId)), HttpStatus.OK);
    }

    @ApiOperation(value = "Add a new favorite for a given user.",response = String.class)
    @PostMapping(path ="/{clientId}/insert/{postId}")
    public ResponseEntity addFavorite(@PathVariable String clientId, @PathVariable String postId) {
        try {
            if( favoriteService.addFavorite(clientId,postId)) return new ResponseEntity(HttpStatus.ACCEPTED);
            else return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }

    @ApiOperation(value = "Remove a favorite of a given user.",response = String.class)
    @PostMapping(path ="/{clientId}/remove/{postId}")
    public ResponseEntity removeFavorite(@PathVariable String clientId, @PathVariable String postId) {
        try {
            if( favoriteService.removeFavorite(clientId,postId)) return new ResponseEntity(HttpStatus.ACCEPTED);
            else return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }







}
