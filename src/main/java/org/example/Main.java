package org.example;

import io.activej.http.AsyncServlet;
import io.activej.http.HttpResponse;
import io.activej.inject.annotation.Provides;
import io.activej.launcher.Launcher;
import io.activej.launchers.http.HttpServerLauncher;
import io.activej.promise.Promise;

public class Main extends HttpServerLauncher {
    @Provides
    AsyncServlet servlet() {
        return request -> Promise.of(
                HttpResponse.ok200()
                    .withJson("{ message: \"It was sent from an Activej API Rest\", author: \"Raul Armas\" }"));
    }

    public static void main(String[] args) throws Exception {
        Launcher launcher = new Main();
        launcher.launch(args);
    }
}
