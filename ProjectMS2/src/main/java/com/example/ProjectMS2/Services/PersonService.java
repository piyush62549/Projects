package com.example.ProjectMS2.Services;

import com.example.ProjectMS2.Dto.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.http.parser.HttpHeaderParser;
//import org.apache.tomcat.util.http.parser.MediaType; - was causing error for mediatype json
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;

@Service
public class PersonService {

    //can use interface here

    //Step to make communication
    //1. Take the url
    @Value("${api.personById}")
    String personUrlById;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ObjectMapper objectMapper;

    public Person PersonData(int personId) {

        //2. Set Urivariable

        HashMap<String,Integer> uriVariable = new HashMap<String, Integer>();
        uriVariable.put("personId",personId);

        //3. set headers
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        //4. set Entity
        HttpEntity<String> entity = new HttpEntity<>(header);

        //5.Making call to another microservice
        ResponseEntity <String> exchange = restTemplate.exchange(this.personUrlById,
                HttpMethod.GET,
                entity,
                String.class,
                uriVariable);
        String body = exchange.getBody();

        //6.Parsing the data to Json
        Person readValue = null;
        try{
            readValue = objectMapper.readValue(body, Person.class);
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return readValue;
    }
}
