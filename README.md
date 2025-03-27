# 🍽️ MiamMIa - Chatbot de Restaurant (Projet JAVA)

## 📌 Description

**MiamMIa** est une application Java en ligne de commande simulant un chatbot de gestion de restaurant.  
Elle permet de gérer les **commandes**, **réservations** et **avis clients** de manière simple et interactive.

---

## ▶️ Lancer le projet

1️⃣ Depuis le répertoire racine `my-chatbot/`, compilez le projet avec Maven :

```bash
mvn clean compile
```

2️⃣ Exécutez la classe principale avec Maven :

```bash
mvn exec:java -Dexec.mainClass="com.miammi.chatbot.Main"
```

---

## 🧠 Fonctionnalités

- 📦 Prise de **commandes**
- 📅 Gestion des **réservations**
- ⭐ Enregistrement et consultation des **avis clients**
- 💾 Sauvegarde/lecture des données au format **JSON**

---

## 🧱 Architecture du projet

```plaintext
my-chatbot
│
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── miammi/
│                   ├── model/
│                   │   ├── App.java
│                   │   ├── MenuItem.java
│                   │   ├── Order.java
│                   │   ├── Reservation.java
│                   │   └── Review.java
│                   ├── service/
│                   │   ├── OrderManager.java
│                   │   ├── ReservationManager.java
│                   │   └── Service.java
│                   └── util/
│                       ├── JsonRead.java
│                       ├── JsonWrite.java
│                       ├── OrderJsonUtil.java
│                       ├── ReservationJsonUtil.java
│                       └── ReviewJsonUtil.java
├── Main.java
└── pom.xml
```

---

## 👥 Membres du groupe

| Nom |
|-----|
| **Amina ADDI** |
| **Anaïs ASSOGANE** |
| **Yasmine GAOUI** |
| **Kilian MEDDAS** |

