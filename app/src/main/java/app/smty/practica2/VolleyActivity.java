package app.smty.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import app.smty.practica2.Models.GorestResponseGeneral;

public class VolleyActivity extends AppCompatActivity {
    TextView textViewUsers;
    RequestQueue requestQueue;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        // init components UI
        textViewUsers = findViewById(R.id.textViewUsers);

        // volley
        Gson gson = new Gson();
        String url = "https://gorest.co.in/public/v1/users";
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GorestResponseGeneral data = gson.fromJson(response, GorestResponseGeneral.class);
                data.getUserList().forEach(user -> {
                    result += user.toString() + "\n\n";
                });
                textViewUsers.setText(result);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VolleyActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // init variables
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}