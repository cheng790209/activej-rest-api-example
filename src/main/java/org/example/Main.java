package org.example;

import io.activej.http.AsyncServlet;
import static io.activej.http.HttpMethod.GET;
import static io.activej.http.HttpMethod.POST;
import io.activej.http.HttpResponse;
import io.activej.http.RoutingServlet;
import io.activej.inject.annotation.Provides;
import io.activej.launcher.Launcher;
import io.activej.launchers.http.HttpServerLauncher;
import netscape.javascript.JSObject;

import java.util.ArrayList;

public class Main extends HttpServerLauncher {
    ArrayList<String> messages = new ArrayList<>();
    @Provides
    AsyncServlet servlet() {
        return RoutingServlet.create()
                .map(GET, "/", request -> HttpResponse.ok200()
                        .withJson("{ message: \"Hi, this is an Activej Rest API\", availableEndpoints: [\"/addMessage\", \"/getAllMessages\"], author: \"Raul Armas\" }"))

                .map(GET, "/getAllMessages", request -> {
                    String stringedMessages = "";

                    for (int i = 0; i < messages.size(); i++) {
                        if (i == 0) {
                            stringedMessages += "[\"" + messages.get(i) + "\"";
                        }
                        else if (i == messages.size() -1) {
                            stringedMessages += "\"" + messages.get(i) + "\"]";
                        } else {
                            stringedMessages += ",\"" + messages.get(i) + "\",";
                        }
                    }

                    return HttpResponse.ok200()
                            .withJson("{ messages: " + stringedMessages + " }");
                })

                .map(POST, "/addMessage", request -> {
                    //obtener request.body
                    messages.add("A");

                    return HttpResponse.ok200()
                            .withJson("{ status: \"OK\" }");
                });
    }

    public static void main(String[] args) throws Exception {
        Launcher launcher = new Main();
        launcher.launch(args);
    }
}
