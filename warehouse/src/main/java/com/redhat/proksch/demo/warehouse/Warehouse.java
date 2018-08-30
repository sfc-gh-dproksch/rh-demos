package com.redhat.proksch.demo.warehouse;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
public class Warehouse extends AbstractVerticle {
    @Override
    public void start(Future<Void> fut) {
        vertx
            .createHttpServer()
            .requestHandler(r ->
                r.response()
                 .end(" <h1>Hello from Warehouse!</h1> "))
            .listen(8080, result -> {
                if (result.succeeded()) {
                    fut.complete();
                } else {
                    fut.fail(result.cause());
                }
            });
    }
}
