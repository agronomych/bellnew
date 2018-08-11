package ru.bellintegrator.practice.docs.controller;

import ru.bellintegrator.practice.docs.dao.DocDao;
import ru.bellintegrator.practice.docs.model.Doc;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.docs.service.DocService;

import java.util.LinkedList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/docs", produces = APPLICATION_JSON_VALUE)
public class DocController {

    @Autowired
    private DocService docService;

    @GetMapping("/list")
    public String docsList(){
        List list = docService.docs();
        return list.size()+"";
    }

    @ApiOperation(value = "id", nickname = "id",httpMethod = "GET")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody String get(@RequestParam() int id) {
        return docService.loadById(id).name;
    }

}
