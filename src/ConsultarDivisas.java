import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarDivisas {

    public  Divisa buscaDivisa(String divisa){
        URI api = URI.create("https://v6.exchangerate-api.com/v6/2d6de6e910a63b8244320953/latest/" + divisa);

        HttpClient usuario =HttpClient.newHttpClient();
        HttpRequest requerimiento = HttpRequest.newBuilder()
                .uri(api)
                .build();

        try{
            HttpResponse<String> respuesta = usuario
                    .send(requerimiento, HttpResponse.BodyHandlers.ofString());
            //System.out.println("Respuesta api: "+ respuesta.body());
            return new Gson().fromJson(respuesta.body(), Divisa.class);

        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Divisa no encontrada");
        }
    }
}
