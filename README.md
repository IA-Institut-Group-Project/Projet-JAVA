# 🍽️ MiamMIa - Chatbot de Restaurant (Projet JAVA)

## 📌 Description

**MiamMIa** est une application Java en ligne de commande simulant un chatbot de gestion de restaurant.  
Elle permet de gérer les **commandes**, **réservations** et **avis clients** de manière simple et interactive.

---

## 🛠️ Technologies utilisées

- Java 17
- Maven
- JSON (pour la gestion des données)
- Terminal / CLI (interface)

---

## ▶️ Lancer le projet

1. Depuis le répertoire racine `my-chatbot/`, compilez le projet avec Maven :

   ```bash
   mvn clean compile
   ```

2. Exécutez la classe principale avec Maven :

   ```bash
   mvn exec:java "-Dexec.mainClass=com.miammi.chatbot.Main"
   ```

---

## 🖥️ Exemple d'utilisation

```plaintext
Bienvenue chez MiamMIa !
1. Donner un avis
2. Passer une commande
3. Faire une réservation de table
4. Quitter

Choix : 2
=== Passer une commande ===
Numéro de table : 45
Ajouter un produit (ou 'fin' pour terminer) : pizza
pizza ajouté !
Ajouter un produit (ou 'fin' pour terminer) : fin
Commande ajoutée !
Table: 45
Produits: [pizza]
Erreur lors de la lecture du fichier orders : orders.json (The system cannot find the file specified)
Fichier orders sauvegardé avec succès à : C:\Users\kilia\Desktop\IA-B2\JAVA\Projet-JAVA\my-chatbot\orders.json
Commande enregistrée avec succès !
```

---

## 🚀 Améliorations futures

- Ajout d’une interface graphique (Swing ou JavaFX)
- Statistiques des commandes/réservations
- Sauvegarde dans une base de données (ex: SQLite)

---

## 🧩 Installation

1. Cloner le dépôt :

   ```bash
   git clone https://github.com/ton-compte/mon-projet.git
   ```

2. Aller dans le dossier du projet :

   ```bash
   cd my-chatbot
   ```

3. Compiler et exécuter :

   ```bash
   mvn clean compile
   mvn exec:java "-Dexec.mainClass=com.miammi.chatbot.Main"
   ```

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

| Nom               |
|-------------------|
| **Amina ADDI**    |
| **Anaïs ASSOGANE**|
| **Yasmine GAOUI** |
| **Kilian MEDDAS** |

