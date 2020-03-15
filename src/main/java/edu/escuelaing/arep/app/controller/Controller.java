package edu.escuelaing.arep.app.controller;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.arep.app.DAO.DnDplayerDAO;
import edu.escuelaing.arep.app.entities.DnDplayer;


@RestController
@RequestMapping("/api")
public class Controller{

    @Autowired
    DnDplayerDAO dao;

    @RequestMapping(value = "/dnDplayers",method = RequestMethod.GET)
    public ResponseEntity<?> listAllDnDplayers(){
        try{
            return new ResponseEntity<>(dao.findAll(),HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/dnDplayers")
    public ResponseEntity<?> createDnDPlayer(@RequestBody DnDplayer dnDplayer){
        try{
            dao.insertPlayer(dnDplayer);
            return new ResponseEntity<>(dnDplayer, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>("Could not create character", HttpStatus.FORBIDDEN);
        }
    }
        
}