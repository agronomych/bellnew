package ru.bellintegrator.practice.user.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.user.service.UserService;
import ru.bellintegrator.practice.user.view.UserView;

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
    @PostMapping("/list")
    @ResponseBody
    public List<UserView> listUsers(@RequestBody List<UserView> users) {
        users = userService.users();
        return users;
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
    public void saveUser(@RequestBody UserView view) {
        userService.saveUser(view);
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
    public void updateUser(@RequestBody UserView view) {
        userService.updateUser(view);
    };

    /**
     * Блок для /{id}, возвращает данные пользователя по id
     * @param id
     */
    @ApiOperation(value = "id", nickname = "id",httpMethod = "GET")
    @GetMapping("/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody UserView get(@RequestParam() int id) {
        return userService.loadById(id);
    }
    public UserView loadById(){
        UserView user = null;

        return user;
    }
}
