# Learning Spring Websocket (Server)

- This code here is following tutorial from ([this](https://www.youtube.com/watch?v=U4lqTmFmbAM)) Youtube video, not the exact match because I explored some minor configuration. You can check his [github](https://github.com/ShaneLee) account too
- It is a simple messaging apps using **spring-websocket**, **Stomp**, **SockJS**
- To run this apps execute command `mvn spring-boot:run` or just simply run application via Intellij by open file `com.research.ovi.springwebsocketserver.SpringWebsocketAplication.java` and run the app
- This is running on port 8090, you can change to your preferences, simply check the `application.properties` inside this module
- If you change the port, you will need to change the code in module **client** too. You have to change variable **port** value in `/src/main/resources/static/js/script.js` line 15, into the port value that you choose.