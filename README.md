# Cognitive Processor

Eenvoudige Spring Boot REST-service die via Spring AI een lokaal Ollama-model aanspreekt en het gegenereerde antwoord retourneert met latency.

Het gebruikte model is **`adam`**, gebaseerd op **Llama 3 8B**, aangemaakt met een eigen Ollama *Modelfile*.

---

## Vereisten

* Java 17+
* Maven
* Ollama draaiend op `http://localhost:11434`
* Model `adam` beschikbaar in Ollama

---

## Model installatie (Ollama)

Volg deze stappen om het model lokaal te installeren en te gebruiken.

### 1. Ollama installeren
Zorg dat **Ollama** geïnstalleerd is op je systeem.  
Installatie-instructies: https://ollama.com

Controleer daarna of het werkt:

```bash
ollama --version
```

### 2. Het model lokaal installeren

```bash
ollama pull llama3:8b
```

### 3. Adam aanmaken
Om Adam aan te maken is er een Modelfile nodig. Deze staat in de root van de git directory.

```bash
ollama create adam -f <Locatie van Modelfile> Modelfile
```

## Starten

```bash
mvn spring-boot:run
```

Applicatie draait standaard op:

```
http://localhost:8080
```

---

## Endpoint

### `POST /ask` (http://localhost:8080/ask)

**Request**

```json
{
  "conversationId": "123"
  "message": "I see a person looking at me and smiling"
}
```

**Response**

```json
{
  "message": "I think: ... I do: ... I say: ...",
  "latency": 120,
  "timestamp": 1710000000000
}
```

De response bevat het modelantwoord, de verwerkingstijd (ms) en een timestamp.
