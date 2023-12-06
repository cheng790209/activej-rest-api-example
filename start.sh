export JAVA_TOOL_OPTIONS='-javaagent:/tmp/opentelemetry-javaagent.jar' \
       OTEL_EXPORTER_OTLP_ENDPOINT='http://server:4318' \
       OTEL_EXPORTER_OTLP_HEADERS='authorization=<key>' \
       OTEL_EXPORTER_OTEL_PROTOCOL='http/protobuf' \
       OTEL_LOGS_EXPORTER=oltp \
       OTEL_SERVICE_NAME=activej_test \
       OTEL_METRICS_EXPORTER=otlp

java -jar activej-rest-api-example-5.4.3-with-dependencies.jar org.example.Main.class
       
