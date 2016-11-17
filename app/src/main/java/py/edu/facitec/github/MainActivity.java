package py.edu.facitec.github;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    EditText loginEditText;
    Button buscarButton;

    TextView nameTextView;
    TextView emailTextView;

    ImageView avatarImageView;
    ListView seguidoresListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginEditText = (EditText) findViewById(R.id.editTextLogin);
        buscarButton = (Button) findViewById(R.id.buttonBuscar);
        nameTextView = (TextView) findViewById(R.id.textViewName);
        emailTextView = (TextView) findViewById(R.id.textViewEmail);

        avatarImageView = (ImageView) findViewById(R.id.imageViewImagen);

        seguidoresListView = (ListView) findViewById(R.id.listViewSeguidores);

        buscarButton.setOnClickListener(new View.OnClickListener(){
          @Override
            public void onClick(View v){
              if(loginEditText.getText().toString().equals("")){
                  loginEditText.setError("Complete el login");
              }

              RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://api.github.com").build();
              UserService userService = restAdapter.create(UserService.class);

              userService.obtenerUsuario(loginEditText.getText().toString(), new Callback<User>() {

                  @Override
                  public void success(User user, Response response) {
                      Log.i("RESULTADO", user.toString());
                    /* if(user.getName()==nul) {
                          nameTextView.setText(user.getName());
                          emailTextView.setError(user.getEmail());
                     }*/
                      nameTextView.setText(user.getName()!=null ? user.getName():"");
                      emailTextView.setError(user.getEmail());
                      Picasso.with(getApplicationContext()).load(user.getAvatar_url()).into(avatarImageView);

                  }


                  @Override
                  public void failure(RetrofitError error) {
                      Log.e("RESULTADO", error.getMessage());
                  }
              });

              userService.obtenerRespotoriod(loginEditText.getText().toString(), new Callback<List<Repository>>() {
                  @Override
                  public void success(List<Repository> repositories, Response response) {
                      Log.i("REPOSITORIOS", repositories.toString());
                  }

                  @Override
                  public void failure(RetrofitError error) {
                      Log.e("REPOSITORIOS", error.getMessage());

                  }
              });


          }
            //Consultar tarea
        });

        
    }

}
