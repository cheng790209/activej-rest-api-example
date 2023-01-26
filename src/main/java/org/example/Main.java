package org.example;

import com.google.gson.Gson;
import io.activej.http.AsyncServlet;
import static io.activej.http.HttpMethod.GET;
import static io.activej.http.HttpMethod.POST;
import io.activej.http.HttpResponse;
import io.activej.http.RoutingServlet;
import io.activej.inject.annotation.Provides;
import io.activej.launcher.Launcher;
import io.activej.launchers.http.HttpServerLauncher;
import models.Contact;
import models.Info;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main extends HttpServerLauncher {
    ArrayList<Contact> contacts = new ArrayList<>();
    Gson gson = new Gson();

    @Provides
    AsyncServlet servlet() {
        return RoutingServlet.create()
                .map(GET, "/", request -> {
                    Info info = new Info(
                            "Hi, this is an Activej Rest API",
                            new String[] { "/addContact", "/getAllContacts" },
                            "Raul Armas"
                    );

                    return HttpResponse.ok200()
                            .withJson(gson.toJson(info));
                })

                .map(GET, "/getAllContacts", request -> HttpResponse.ok200()
                            .withJson(gson.toJson(contacts)))

                .map(POST, "/addContact", request -> request.loadBody()
                        .map($ -> {
                            String body = request.getBody().asString(StandardCharsets.UTF_8);
                            Contact newContact = gson.fromJson(body, Contact.class);
                            contacts.add(newContact);

                            return HttpResponse.ok200().withJson("{ status: \"OK\" }");
                        })
                );
    }

    public static void main(String[] args) throws Exception {
        Launcher launcher = new Main();
        launcher.launch(args);
    }
}
