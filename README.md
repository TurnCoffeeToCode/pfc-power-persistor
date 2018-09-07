# pfc-power-persistor
The pfc-power-peristor can be used to consume a Json posted to a Kafka topic and persists it into a Mongo  db.

## Run it
You can ran the application with executing the main of `PfcPowerPersistorApplication`. By default, it will run on `localhost:8082`.

## Kafka Consumes
The persistor consumes a JSON string posted into a Kafka topic. By default, this topic is `pfc-power-import`.

## Run Mongo with Docker

To run the Mongo db with Docker use the following
`docker-compose up --build` 
