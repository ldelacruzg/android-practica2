package app.smty.practica2.Services;

import java.util.List;

import app.smty.practica2.Models.GorestResponseGeneral;
import app.smty.practica2.Models.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GorestService {
    @GET("users")
    Call<GorestResponseGeneral> getUsers();
}
