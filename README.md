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

### `POST /ask`

**Request**

```json
{
  "message": "Wat is AI?"
}
```

**Response**

```json
{
  "message": "AI is ...",
  "latency": 120,
  "timestamp": 1710000000000
}
```

De response bevat het modelantwoord, de verwerkingstijd (ms) en een timestamp.
