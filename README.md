# pfc-power-persistor

Consumer

As default the kafka consumer tries to connect to a topic "pfc-power-import"

The consumer runs on port 8082 by default

Run Mongo with Docker

Run:   docker-compose -f stack.yml up
Stop:  docker-compose -f stack.yml down

It comes with Mongo-Express so you can view the mongo db via http://localhost:8181/