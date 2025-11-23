package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import net.engineeringdigest.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.parser.Entity;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private  String apiKey;
    private static final String API ="https://api.weatherstack.com/current?access_key=949181760505f30515bf3607c4c797d8&query=CITY";
    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city){

        String finalapi = API.replace("CITY", city).replace("API_KEY", apiKey);
       /* HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("key","value");
        User user = User.builder().username("Vipul").password("Vipul").build();
        HttpEntity<User>httpEntity=new HttpEntity<>(user);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalapi, HttpMethod.POST, httpEntity, WeatherResponse.class);*/
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalapi, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
    }
}
