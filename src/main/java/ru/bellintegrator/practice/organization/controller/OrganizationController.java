package ru.bellintegrator.practice.organization.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.sql.SQLException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/** Контроллер для объекта Organization
 * включает в себя следующее api:
 * /list - возвращает список всех существующих организаций
 * /save - сохраняет новую организацию
 * /update - обновляет данные организации, обязательный параметр id
 * /{id} - возвращает данные об организации по его id
 */
@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService organizationService;

    /**
     * Создаём объект OrganizationService, который будет обрабатывать запросы
     * @param organizationService
     */
    @Autowired
    public OrganizationController(OrganizationService organizationService){
        this.organizationService = organizationService;
    }

    /**
     * Блок для /list, возвращает список организаций List<Organization>
     */
    @ApiOperation(value = "getOrganizations", nickname = "getOrganizations", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping(value = "/list", consumes = APPLICATION_JSON_VALUE)
    public Object listUsers() {
        List<OrganizationView> views;
        try {
            views = organizationService.organizations();
        }
        catch (SQLException e){
            return "{\"error\":"+"{Ошибка при получении списка организаций "+e.getMessage()+"}";
        }
        if (views == null) return "{\"error\":\"Список организаций пустой\"}";
        return views;
    };

    /**
     * Блок для /save, сохраняет данные новой организации
     * @param view
     */
    @ApiOperation(value = "saveOrganization", nickname = "saveOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public Object saveOrganization(@RequestBody OrganizationView view) {
        try{
            organizationService.saveOrganization(view);
        }
        catch (SQLException e){
            return  "{\"error\":"+"{Ошибка при сохранении организации "+e.getMessage()+"}";
        }
        return "{\"result\":\"success\"}";
    };

    /**
     * Блок для /update, обновляет данные организации
     * @param view
     */
    @ApiOperation(value = "updateOrganization", nickname = "updateOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    public Object updateOrganization(@RequestBody OrganizationView view) {
        try{
            organizationService.updateOrganization(view);
        }
        catch (SQLException e){
            return  "{\"error\":"+"{Ошибка при обновлении данных организации "+e.getMessage()+"}";
        }
        return "{\"result\":\"success\"";
    };

    /**
     * Блок для /{id}, возвращает данные организации по id
     * @param id
     */
    @ApiOperation(value = "id", nickname = "id",httpMethod = "GET")
    @GetMapping("/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody Object get(@RequestParam() int id) {
        OrganizationView organizationView;
        try{
            organizationView = organizationService.loadById(id);
        }
        catch (SQLException e){
            return  "{\"error\":"+"{Ошибка при получении организации по id="+id+" "+e.getMessage()+"}";
        }
        if (organizationView == null) return "{\"error\":\"Организация с id="+id+" не найдена\"}";
        return organizationView;
    }


}
