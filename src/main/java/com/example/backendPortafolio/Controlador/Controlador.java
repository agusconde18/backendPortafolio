package com.example.backendPortafolio.Controlador;

import com.example.backendPortafolio.JPA.*;
import com.example.backendPortafolio.User.UserData;
import com.example.backendPortafolio.User.UserTokenValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class Controlador {
    @Autowired
    CardsInterface tarjetas;

    @Autowired
    UserInterface usuarios;

    @Autowired
    UserTokenValid checkTok;

    @Autowired
    TiposInterface tipoCard;


    @GetMapping("cards")
    List<Card> getAllCards(){
        return tarjetas.findAll();
    }

    @PostMapping("card")
    String postCard(
            @RequestParam String titulo,
            @RequestParam String descripcion,
            @RequestParam  String imgSrc,
            @RequestParam  Long  usrId,
            @RequestParam (defaultValue = "") String catNueva,
            @RequestParam String token){
        if(checkTok.checkUser(usrId,token)) {
            TipoCard tc=tipoCard.findByDescripcion(catNueva);
            if(tc==null){
                tc =new TipoCard(null,catNueva);
               tipoCard.save(tc);
               tc= tipoCard.findByDescripcion(catNueva);
            }
            tarjetas.save(
                    new Card(
                            null,
                            titulo,
                            descripcion,
                            imgSrc,
                            usuarios.getById(usrId),
                            tc
                    )
            );
            return "OK" ;
        }
        return "ERR";
    }


    @DeleteMapping("card")
    String deleteCard(
            @RequestParam Long cardId,
            @RequestParam  Long  usrId,
            @RequestParam String token
    ){
        if(checkTok.checkUser(usrId,token)) {
            tarjetas.deleteById(cardId);
            return "OK";
        }
        return "err";
    }


    @PostMapping("login")
    UserData loginUser(
            @RequestParam String email,
            @RequestParam String password
    ){
        User user=usuarios.getByEmailAndPassword(email,password);
        return (user!=null)?checkTok.addUser(user.getId()): new UserData( -1L,"error");
    }

    @GetMapping("tipos")
    List<TipoCard> tiposCard(){
        return tipoCard.findAll();
    }

    @PostMapping("tipo")
    String tiposCard(@RequestParam String nuevoTipo,
                             @RequestParam  Long  usrId,
                             @RequestParam String token){
        if(checkTok.checkUser(usrId,token)) {
            tipoCard.save(new TipoCard(null,nuevoTipo));
            return "OK";
        }
        return "err";
    }


}
