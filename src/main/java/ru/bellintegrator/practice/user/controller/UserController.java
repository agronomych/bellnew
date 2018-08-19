package ru.bellintegrator.practice.user.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.user.service.UserService;
import ru.bellintegrator.practice.user.view.UserView;
import ru.bellintegrator.practice.user.view.UserViewList;

import static ru.bellintegrator.practice.MyUtilities.packToData;

import java.sql.SQLException;
import java.util.List;

import static org.springframework.http.MediaType.*;

/** Контроллер для объекта Office
 * включает в себя следующее api:
 * /list - возвращает список всех существующих офисов
 * /save - сохраняет новый офис
 * /update - обновляет данные офиса, обязательный параметр id
 * /{id} - возвращает данные об офисе по его id
 */
@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    /**
     * Создаём объект UserService, который будет обрабатывать запросы
     * @param userService
     */
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    /**
     * Блок для /list, возвращает список пользователей List<User>
     */
    @ApiOperation(value = "getUsers", nickname = "getUsers", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping(path = "/list", consumes = APPLICATION_JSON_VALUE)
    public Object listUsers() {
        List<UserViewList> views;
        try {
            views = userService.users();
        }
        catch (SQLException e){
            return "{\"error\":"+"{Ошибка при получении списка пользователей "+e.getMessage()+"}";
        }
        if (views == null) return "{\"error\":\"Список пользователей пуст\"}";
        return packToData(views);
    };


    /**
     * Блок для /save, сохраняет данные нового пользователя
     * @param view
     */
    @ApiOperation(value = "saveUser", nickname = "saveUser", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public Object saveUser(@RequestBody UserView view) {

        if (view.firstname == null | view.position == null){
            return "{\"error\":\"недостаточно параметров\"}";
        }

        try{
            userService.saveUser(view);
        }
        catch (SQLException e){
            return  "{\"error\":"+"{Ошибка при сохранении пользователя "+e.getMessage()+"}";
        }
        return "{\"result\":\"success\"}";
    };

    /**
     * Блок для /update, обновляет данные нового пользователя
     * @param view
     */
    @ApiOperation(value = "updateUser", nickname = "updateUser", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    public Object updateUser(@RequestBody UserView view) {

        if (view.id == null | view.firstname == null | view.position == null){
            return "{\"error\":\"недостаточно параметров\"}";
        }
        try{
            userService.updateUser(view);
        }
        catch (SQLException e){
            return  "{\"error\":"+"{Ошибка при обновлении данных пользователя "+e.getMessage()+"}";
        }
        return "{\"result\":\"success\"";
    };

    /**
     * Блок для /{id}, возвращает данные пользователя по id
     * @param id
     */
    @ApiOperation(value = "id", nickname = "id",httpMethod = "GET")
    @GetMapping("/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody Object get(@RequestParam() int id) {
        UserView userView;
        try{
            userView = userService.loadById(id);
        }
        catch (Exception e){
            return  "{\"error\":"+"{Ошибка при получении пользователя "+e.getMessage()+"}";
        }
        if (userView == null) return "{\"error\":\"Пользователь с id=\""+id+" не найден\"}";
        return packToData(userView);
    }


}
