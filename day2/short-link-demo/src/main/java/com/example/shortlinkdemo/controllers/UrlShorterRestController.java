package com.example.shortlinkdemo.controllers;

import java.io.IOException;
import java.net.MalformedURLException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.example.shortlinkdemo.models.Formulario;
import com.example.shortlinkdemo.repository.LinkModel;
import com.example.shortlinkdemo.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlShorterRestController {

    @Autowired
    LinkRepository linkRepositoty;
    @RequestMapping(value = "/shortenurl", method = RequestMethod.POST)
    public ResponseEntity<Object> getShortenUrl(@RequestBody Formulario shortenUrl) throws MalformedURLException {
        System.out.println(shortenUrl.getRealLink());
        LinkModel p1 = linkRepositoty.findByRealLink(shortenUrl.getRealLink());
        System.out.println(p1.getShortLink());
        if (!p1.getShortLink().isEmpty())
            return new ResponseEntity<Object>(p1,HttpStatus.OK);
        String randomChar = getRandomChars();
        setShortUrl(randomChar, shortenUrl);
        return new ResponseEntity<Object>(shortenUrl, HttpStatus.OK);
    }

    //    @RequestMapping(value="/link", method=RequestMethod.POST)
//    public LinkModel saveLink(@RequestBody String realLink) {
//        String randomChar = getRandomChars();
//        LinkModel linkModel = new LinkModel();
////        if (linkModel.getRealLink(realLink) != null)
////            return;
//        linkModel.setRealLink(realLink);
//        setShortUrl(randomChar, linkModel);
//        return linkRepositoty.save(linkModel);
//    }

    @RequestMapping(value = "/s/{randomstring}", method = RequestMethod.GET)
    public void getFullUrl(HttpServletResponse response, @PathVariable("randomstring") String randomString) throws IOException {

        response.sendRedirect(linkRepositoty.findByShortLink("http://localhost:8080/s/" + randomString).getRealLink());
        System.out.println(linkRepositoty.findByShortLink("http://localhost:8080/s/" + randomString).getRealLink());
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<LinkModel> getList() {
        return linkRepositoty.findAll();
    }

    private void setShortUrl(String randomChar, Formulario shortenUrl) {
        LinkModel linkModel = new LinkModel();
        shortenUrl.setShortLink("http://localhost:8080/s/" + randomChar);
        linkModel.setShortLink(shortenUrl.getShortLink());
        linkModel.setRealLink(shortenUrl.getRealLink());
        linkRepositoty.save(linkModel);
    }

//    private void setShortUrl(String randomChar, LinkModel linkModel) throws MalformedURLException {
//        linkModel.setShortLink("http://localhost:8080/s/"+randomChar);
//    }

    private String getRandomChars() {
        String randomStr = "";
        String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < 5; i++)
            randomStr += possibleChars.charAt((int) Math.floor(Math.random() * possibleChars.length()));
        return randomStr;
    }

}