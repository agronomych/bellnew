package ru.bellintegrator.practice.office.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.office.view.OfficeView;

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
    @PostMapping("/list")
    public void listOffices(@RequestBody List<OfficeView> offices) {
        offices = officeService.offices();
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
    @PostMapping("/save")
    public void saveOffice(@RequestBody OfficeView view) {
        officeService.saveOffice(view);
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
    public void updateOffice(@RequestBody OfficeView view) {
        officeService.updateOffice(view);
    };

    /**
     * Блок для /{id}, возвращает данные офиса по id
     * @param id
     */
    @ApiOperation(value = "id", nickname = "id",httpMethod = "GET")
    @GetMapping("/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody OfficeView get(@RequestParam() int id) {
        return officeService.loadById(id);
    }
    public OfficeView loadById(){
        OfficeView office = null;

        return office;
    }
}
