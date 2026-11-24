# BartExchanger_bot

Telegram bot for displaying currency exchange information. The project is written in Java and uses Maven.

## Requirements

- JDK 8 or newer (the project targets Java 8)
- Maven
- A Telegram bot token from [@BotFather](https://t.me/BotFather)

## Configuration

Set the bot token as an environment variable before starting the application. Do not commit the token to Git.

macOS / Linux:

```bash
export TELEGRAM_BOT_TOKEN="YOUR_NEW_BOT_TOKEN"
```

## Build

```bash
mvn clean package
```

## Run

```bash
mvn exec:java
```

