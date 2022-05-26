package com.hrd.basic.myprojectapi.controller;

import com.hrd.basic.myprojectapi.dto.payload.ErrorPayload;
import com.hrd.basic.myprojectapi.dto.request.RegisterRequest;
import com.hrd.basic.myprojectapi.dto.response.*;
import com.hrd.basic.myprojectapi.model.ERole;
import com.hrd.basic.myprojectapi.model.Role;
import com.hrd.basic.myprojectapi.model.User;
import com.hrd.basic.myprojectapi.repository.UserRoleRepository;
import com.hrd.basic.myprojectapi.service.UserService;
import com.hrd.basic.myprojectapi.utilities.CustomMessage;
import com.hrd.basic.myprojectapi.utilities.Pagination;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRoleRepository userRoleRepository;

//    private final PasswordEncoder encoder;



    @Operation(operationId = "getAll",description = "Return A List Of users.",summary = "FindAllUser")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200",description = "Users have retrieved successfully",content = @Content(schema = @Schema(implementation = AllUserResponse.class))),
            @ApiResponse(responseCode = "404",description = CustomMessage.NOT_FOUND,content = @Content(schema = @Schema(implementation = SingleErrorResponse.class)))
    })
    @GetMapping()
    public ResponseEntity<Object> findAllUser(HttpServletRequest request, @RequestParam("page") String page, @RequestParam("limit") String limit) {
        Date requestTime =  new Date();
        List<User> userList;

        if ( Integer.parseInt(page) <= 0 || Integer.parseInt(limit) <= 0){
            return new ResponseEntity<>(new SingleErrorResponse(400, CustomMessage.BAD_REQUEST, requestTime, "page and limit must be greater than 0"), HttpStatus.BAD_REQUEST);
        }
        Pagination pagination =  new Pagination(Integer.parseInt(page),Integer.parseInt(limit));
        try{
            userList  = userService.findAll(pagination);

            if (userList.isEmpty()){
                throw new NoSuchElementException("User Not Found!");
            }

        }catch(NoSuchElementException ex){
            return new ResponseEntity<>(new SingleErrorResponse(404, CustomMessage.NOT_FOUND, requestTime, ex.getMessage()), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new AllUserResponse(200,"Users have retrieved successfully ",requestTime,userList, pagination), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Object> findByEmail(@RequestParam String email){
        Date requestDate = new Date();
        User user = new User();
        try {
            user = userService.findByEmail(email).get();

        }catch (NoSuchElementException e){
            return new ResponseEntity<>(new SingleErrorResponse(404, CustomMessage.NOT_FOUND, requestDate, e.getMessage()),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new FindOneUseresponse(200,"User has retrieved successfully", requestDate,user),HttpStatus.OK);




    }


    @PostMapping()
    public ResponseEntity<Object> registerUser(@Valid @RequestBody RegisterRequest registerRequest, BindingResult bindingResult) {
        Date requestTime = new Date();
        AtomicBoolean isAExistingUser = new AtomicBoolean(false);
        List<ErrorPayload> errors = new ArrayList<>();
        if (bindingResult.hasErrors()){
            userService.findByEmail(registerRequest.getUsername()).ifPresent(name ->errors.add(new ErrorPayload("Email","email already exist!")));
            bindingResult.getFieldErrors().forEach(fieldError -> errors.add(new ErrorPayload(fieldError.getField(),fieldError.getDefaultMessage())));
            return  new ResponseEntity<>(new ErrorResponse(406, CustomMessage.VALIDATION_ERROR,requestTime,errors),HttpStatus.BAD_REQUEST);
        }
        userService.findByEmail(registerRequest.getUsername()).ifPresent(name ->{
            errors.add(new ErrorPayload("email","email already exist!"));
            isAExistingUser.set(true);
        });
        if (isAExistingUser.get()){
            return  new ResponseEntity<>(new ErrorResponse(406, CustomMessage.VALIDATION_ERROR,requestTime,errors),HttpStatus.BAD_REQUEST);
        }
        try {
            User user = new User(
                    registerRequest.getUsername(),registerRequest.getPassword());
            Set<String> strRoles;
            if (registerRequest.getRoles().isEmpty()){
                strRoles = null;
            }else {
                strRoles = registerRequest.getRoles();
            }
            Set<Role> roles = new HashSet<>();
            if (strRoles == null) {
                Role userRole = new Role();
                userRole.setName(ERole.ROLE_USER);
//                userRole.setId("t12eqw");
                roles.add(userRole);
            } else {
                strRoles.forEach(role -> {
                    if ("ROLE_ADMIN".equals(role)) {
                        Role adminRole = new Role();
                        adminRole.setName(ERole.ROLE_ADMIN);
//                        adminRole.setId("t11eqw");
                        roles.add(adminRole);
                    }
                });
            }
            User u = new User();
            u.setEmail(registerRequest.getEmail());
            u.setUsername(registerRequest.getUsername());
            u.setPassword(registerRequest.getPassword());
//            u.setCreateAt(new Date());
            u.setStatus(true);

            userService.create(u);
            roles.forEach(role -> userRoleRepository.save(user.getId(),role.getId()));
            return new ResponseEntity<>(new SuccessResponse(HttpStatus.CREATED.value(),"user successfully created",requestTime),HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(new AuthRegisterResponse(400,ex.getMessage(),requestTime,registerRequest),HttpStatus.BAD_REQUEST);
        }
    }}
