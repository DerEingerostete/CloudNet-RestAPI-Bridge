# CloudNet-RestAPI-Bridge
Die CloudNet RestAPI Bridge ist eine Schnittstelle zwischen Java und der RestAPI von CloudNet v2.

## Zusammenfassung

Die Zusammenfassung ist der erste Ort um die API kennenzulernen.

1. [Einführung](#API-benutzen)
2. [Beispiele](#Beispiele)   
3. [Entwickler](#entwickler)

## API benutzen

Die API besteht aus einer großen Klasse, die alles verwaltet.
Diese lautet RestAPIBridge. Sie beinhaltet alle notwendigen Methoden, um Daten an die RestAPI
zu senden oder zu erhalten.

Um diese Methoden zu nutzen ist es notwendig sich [anzumelden](#Anmelden).

## Beispiele

### Anmelden

````java
String user = "USER";
String token = "TOKEN";
String url = "https://yourdomain.com:1420";
RestAPIBridge.login(user, token, url);
````

Der Token sowie der User sind bei CloudNet in der users.json gespeichert. 
Diese befindet sich im »Master« Ordner.

### Abmelden

````java
RestAPIBridge.logout();
````

Diese API bietet eine logout Methode, welche jedoch nicht genutzt werden muss.
Wenn diese Methode aufgerufen wird, werden nur die Authentifizierungsinformationen durch null ersetzt.

### Aktive Server bekommen

```java
try {
    List<Server> servers = RestAPIBridge.getServers();    
} catch (Exception exception) {
    exception.printStackTrace();
}
```

**Es gilt zu Beachten:**
- Diese Methode benötigt eine Try/Catch Klammer

### Einen Server starten

```java
try {
    String groupName = "Lobby";
    boolean success = RestAPIBridge.startServer(groupName);
} catch (Exception exception) {
    exception.printStackTrace();
}
```

**Es gilt zu Beachten:**
 - Sie gibt je nachdem, ob die Aufgabe erfolgreich war ein true oder false zurück
 - Diese Methode benötigt eine Try/Catch Klammer

## Entwickler

Aktuelle Entwickler sind:
- DerEingerostete
