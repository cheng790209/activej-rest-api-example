export JAVA_TOOL_OPTIONS='-javaagent:/tmp/opentelemetry-javaagent.jar' \
       OTEL_EXPORTER_OTLP_ENDPOINT='http://server:4318' \
       OTEL_EXPORTER_OTLP_HEADERS='authorization=194f9b8d-314c-4057-9248-2851e1625316' \
       OTEL_EXPORTER_OTEL_PROTOCOL='http/protobuf' \
       OTEL_LOGS_EXPORTER=oltp \
       OTEL_SERVICE_NAME=activej_test \
       OTEL_METRICS_EXPORTER=otlp

java -jar activej-rest-api-example-5.4.3-with-dependencies.jar org.example.Main.class
       
