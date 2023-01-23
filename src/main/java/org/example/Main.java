package org.example;

import io.activej.http.AsyncServlet;
import static io.activej.http.HttpMethod.GET;
import io.activej.http.HttpResponse;
import io.activej.http.RoutingServlet;
import io.activej.inject.annotation.Provides;
import io.activej.launcher.Launcher;
import io.activej.launchers.http.HttpServerLauncher;
import io.activej.promise.Promise;

public class Main extends HttpServerLauncher {
    @Provides
    AsyncServlet servlet() {
        return RoutingServlet.create()
                .map(GET, "/", request -> HttpResponse.ok200()
                        .withJson("{ message: \"It was sent from an Activej Rest API\", author: \"Raul Armas\" }"))
                .map(GET, "/login", request -> HttpResponse.ok200()
                        .withJson("{ message: \"Use your email and password to log in\" }"));
    }

    public static void main(String[] args) throws Exception {
        Launcher launcher = new Main();
        launcher.launch(args);
    }
}
