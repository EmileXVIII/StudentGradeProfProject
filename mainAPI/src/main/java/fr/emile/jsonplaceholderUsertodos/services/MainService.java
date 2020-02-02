package fr.emile.jsonplaceholderUsertodos.services;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import fr.emile.jsonplaceholderUsertodos.clients.ITodoClient;
import fr.emile.jsonplaceholderUsertodos.clients.IUserClient;
import fr.emile.jsonplaceholderUsertodos.clients.IUserTodosClient;
import fr.emile.jsonplaceholderUsertodos.entities.ToDo;
import fr.emile.jsonplaceholderUsertodos.entities.User;
import fr.emile.jsonplaceholderUsertodos.entities.UserTodosDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
@Setter
@Slf4j
public class MainService {
    private ITodoClient iTodoClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger())
            .logLevel(Logger.Level.FULL)
            .target(ITodoClient.class, "http://localhost:8080/todos")
            ;
    private IUserClient iUserClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger())
            .logLevel(Logger.Level.FULL)
            .target(IUserClient.class, "http://localhost:8081/users")
            ;
    private IUserTodosClient iUserTodosClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger())
            .logLevel(Logger.Level.FULL)
            .target(IUserTodosClient.class, "http://localhost:8082/userTodos")
            ;

    public ITodoClient getiTodoClient() {
        return iTodoClient;
    }

    public IUserClient getiUserClient() {
        return iUserClient;
    }

    public IUserTodosClient getiUserTodosClient() {
        return iUserTodosClient;
    }
}
