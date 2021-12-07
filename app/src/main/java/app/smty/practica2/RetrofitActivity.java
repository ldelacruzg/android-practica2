package app.smty.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import app.smty.practica2.Models.GorestResponseGeneral;
import app.smty.practica2.Services.GorestService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {
    TextView textViewUsers;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        textViewUsers = findViewById(R.id.textViewUsers);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gorest.co.in/public/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GorestService service = retrofit.create(GorestService.class);
        Call<GorestResponseGeneral> users = service.getUsers();
        users.enqueue(new Callback<GorestResponseGeneral>() {
            @Override
            public void onResponse(Call<GorestResponseGeneral> call, Response<GorestResponseGeneral> response) {
                GorestResponseGeneral data = response.body();
                data.getUserList().forEach(user -> {
                    result += user.toString() + "\n\n";
                });
                textViewUsers.setText(result);
            }

            @Override
            public void onFailure(Call<GorestResponseGeneral> call, Throwable t) {

            }
        });
    }
}