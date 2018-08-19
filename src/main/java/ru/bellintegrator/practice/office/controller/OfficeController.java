package ru.bellintegrator.practice.office.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.office.view.OfficeView;
import ru.bellintegrator.practice.office.view.OfficeViewList;

import static ru.bellintegrator.practice.MyUtilities.packToData;

import java.sql.SQLException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/** Контроллер для объекта Office
 * включает в себя следующее api:
 * /list - возвращает список всех существующих офисов
 * /save - сохраняет новый офис
 * /update - обновляет данные офиса, обязательный параметр id
 * /{id} - возвращает данные об офисе по его id
 */
@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeService officeService;

    /**
     * Создаём объект OfficeService, который будет обрабатывать запросы
     * @param officeService
     */
    @Autowired
    public OfficeController(OfficeService officeService){
        this.officeService = officeService;
    }

    /**
     * Блок для /list, возвращает список офисов List<Office>
     */
    @ApiOperation(value = "getOffices", nickname = "getOffices", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping(path="/list", consumes = APPLICATION_JSON_VALUE)
    public Object listOffices() {
        List<OfficeViewList>  views;
        try {
            views = officeService.offices();
        }
        catch (SQLException e){
            return "{\"error\":"+"{Ошибка при получении списка офисов "+e.getMessage()+"}";
        }
        if (views == null) return "{\"error\":\"Список офисов пустой\"}";
        return packToData(views);
    };

    /**
     * Блок для /save, сохраняет данные нового офиса
     * @param view
     */
    @ApiOperation(value = "saveOffice", nickname = "saveOffice", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping(value = "/save", consumes = APPLICATION_JSON_VALUE)

    public Object saveOffice(@RequestBody OfficeView view) {

        if (view.name == null | view.address == null){
            return "{\"error\":\"недостаточно параметров\"}";
        }

        try{
            officeService.saveOffice(view);
        }
        catch (SQLException e){
            return  "{\"error\":"+"{Ошибка при сохранении офиса "+e.getMessage()+"}";
        }
        return "{\"result\":\"success\"}";
    };

    /**
     * Блок для /update, обновляет данные нового офиса
     * @param view
     */
    @ApiOperation(value = "updateOffice", nickname = "updateOffice", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    public Object updateOffice(@RequestBody OfficeView view) {

        if (view.id == null | view.address == null | view.name == null){
            return "{\"error\":\"недостаточно параметров\"}";
        }
        try{
            officeService.updateOffice(view);
        }
        catch (SQLException e){
            return  "{\"error\":"+"{Ошибка при обновлении данных офиса "+e.getMessage()+"}";
        }
        return "{\"result\":\"success\"}";
    };

    /**
     * Блок для /{id}, возвращает данные офиса по id
     * @param id
     */
    @ApiOperation(value = "id", nickname = "id",httpMethod = "GET")
    @GetMapping("/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody Object getById(@RequestParam() int id) {
        OfficeView officeView;
        try{
            officeView = officeService.loadById(id);
        }
        catch (SQLException e){
            return  "{\"error\":"+"{Ошибка при получении данных офиса по id="+id+" "+e.getMessage()+"}";
        }
        if (officeView == null){
            return "{\"error\":\"Офис с id="+id+" не найден\"}";
        }
        return packToData(officeView);
    }

    /**
     * Блок для /list/{orgId}, возвращает список офисов по id организации
     * @param orgId
     */
    @ApiOperation(value = "orgId", nickname = "orgId", httpMethod = "POST")
    @PostMapping("/list/")
    @RequestMapping(value = "/list/", method = RequestMethod.POST)

    public @ResponseBody Object getByOrgId(@RequestParam() int orgId){

        List<OfficeViewList> views;
        try {
            views = officeService.loadByOrgId(orgId);
        }
        catch (SQLException e){
            return "{\"error\":\"Ошибка при получении данных по офисам с id организаций id="+orgId+"\"}";
        }
        if (views.isEmpty()){
            return "{\"error\":\"Офисов с id организации id="+orgId+" не найдено\"}";
        }
        return packToData(views);
    }

}
