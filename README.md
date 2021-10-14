# Learning Spring Websocket

- This code here is following tutorial from ([this](https://www.youtube.com/watch?v=U4lqTmFmbAM)) Youtube video, not the exact match because I explored some minor configuration. You can check his [github](https://github.com/ShaneLee) account too
- It is a simple messaging apps using **spring-websocket**, **Stomp**, **SockJS**
- **client** is the module for the front end apps
- **server** is the module for the back end apps
- To run this apps, you need to run the client (which running on port 8080). And then run the server (which running on port 8090), or vice versa by execute command `mvn spring-boot:run`
- If you run this app on linux os, you can use this command to run the client & service paralelly on separate terminal
   ```bash
   gnome-terminal -e "mvn spring-boot:run -pl client" && gnome-terminal -e "mvn spring-boot:run -pl server"
   ```
- Feel free to use this repository for learning purposes, thank you for visiting my github repo!