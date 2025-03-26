# Project JAVA

## Description


1️⃣ Run the following command from the root directory ( **my-chatbot/**)

```
mvn clean compile
```


2️⃣ Execute the main class using Maven
```
mvn clean compile exec:java -Dexec.mainClass="com.miammi.chatbot.Main"
```

3️⃣



4️⃣












| :memo:        | Membres du groupe       |
|---------------|:------------------------|
> **Amina ADDI** , **Anaïs ASSOGANE** , **Yasmine GAOUI** , **Kilian MEDDAS**




## Architecture du Projet

```plaintext
my-chatbot
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── MiamMIa/
│   │   │           ├── model/
│   │   │               ├── App.java
│   │   │               ├── MenuItem.java
│   │   │               ├── Order.class
│   │   │               ├── Order.java
│   │   │               ├── Reservation.class
│   │   │               ├── Reservation.java
│   │   │               ├── Review.class
│   │   │               └── Review.java
│   │   │           ├── service/
│   │   │               ├── OrderManager.java
│   │   │               ├── ReservationManager.java
│   │   │               └── service.java
│   │   │           └── util/
│   │   │               ├── JsonRead.java
│   │   │               ├── JsonWrite.java
│   │   │               ├── OrderJsonUtil.java
│   │   │               └── ReservationJsonUtil.java
│   └── Main.java
│    
│
└── pom.xml


