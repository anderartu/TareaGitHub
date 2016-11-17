package py.edu.facitec.github;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by user on 27/10/2016.
 */
public interface UserService {

    @GET("/users/{login}")
    public void obtenerUsuario(@Path("login") String login, Callback<User> user);

    @GET("/users/{login}/repos")
    void obtenerRespotoriod(@Path("login") String login, Callback<List<Repository>> callback);

   // @GET("/users/{login}")
   // public void obtenerUsuario(@Path("login") String login);

}
