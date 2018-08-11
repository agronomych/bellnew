package ru.bellintegrator.practice.organization.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationView;

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
    @PostMapping("/list")
    public void listUsers(@RequestBody List<OrganizationView> organizations) {
        organizations = organizationService.organizations();
    };

    /**
     * Блок для /save, сохраняет данные нового офиса
     * @param view
     */
    @ApiOperation(value = "saveOrganization", nickname = "saveOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public void saveOrganization(@RequestBody OrganizationView view) {
        organizationService.saveOrganization(view);
    };

    /**
     * Блок для /update, обновляет данные нового офиса
     * @param view
     */
    @ApiOperation(value = "updateOrganization", nickname = "updateOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    public void updateOrganization(@RequestBody OrganizationView view) {
        organizationService.updateOrganization(view);
    };

    /**
     * Блок для /{id}, возвращает данные офиса по id
     * @param id
     */
    @ApiOperation(value = "id", nickname = "id",httpMethod = "GET")
    @GetMapping("/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody OrganizationView get(@RequestParam() int id) {
        return organizationService.loadById(id);
    }
    public OrganizationView loadById(){
        OrganizationView organization = null;

        return organization;
    }
}
