# 🔐 Secure Data Hiding in Image Using Steganography

A powerful, cleanly structured Java-based tool to **hide and extract secret messages inside PNG images** using the **Least Significant Bit (LSB)** technique with optional passcode protection.

---

## 🚀 Features

- 🔏 Hide secret text in a PNG image using LSB steganography
- 🔐 Decode hidden messages with passcode validation
- 🧪 Simple and modular codebase (Java 21)
- 🖼️ Encoded images saved as `encryptedImage.png`
- ✅ Clean structure with separated frontend and backend

---

## 🛠️ Tech Stack

| Tool/Technology | Description                              |
|------------------|------------------------------------------|
| **Java 21**       | Backend logic for encoding & decoding    |
| **HTML/CSS/JS**   | Frontend interface                      |
| **Maven**         | Java dependency management              |
| **Git + GitHub**  | Version control and repo hosting        |
| **Command Line**  | For compiling and running the backend   |

---

## 📁 Project Structure

Secure-DataHiding-Stego-Java/
├── backend/
│   ├── pom.xml
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/example/stegoproject/
│   │   │   │       ├── StegoApplication.java
│   │   │   │       ├── controller/
│   │   │   │       │   └── StegoController.java
│   │   │   │       └── service/
│   │   │   │           ├── EncoderService.java
│   │   │   │           └── DecoderService.java
│   │   │   └── resources/
│   │   │       └── application.properties
│   └── target/
│       └── stego-app-1.0.jar
│
├── frontend/
│   ├── index.html
│   ├── script.js
│   ├── style.css
│   └── images/
│       ├── background.jpeg
│       └── favicon.png
│
└── README.md
---

## 🧑‍💻 How to Run the Project

> ⚠️ Java 21 and Maven must be installed.

### 🔧 Backend (Java Spring Boot)

1. Navigate to the backend:
```bash
cd backend
````

2. Run the app with Maven:

```bash
mvn spring-boot:run
```

> This starts the backend server on `http://localhost:8080`

---

### 🌐 Frontend (Static HTML/JS)

1. Open `frontend/index.html` in your browser

2. Interact with the UI to encode/decode messages

---

## 📦 Requirements

* Java JDK 21+
* Maven 3.6+
* PNG image file (`input.png`)
* Terminal or command prompt

---

## 🧠 Notes

* Use only **PNG images** (JPEG is lossy and may corrupt hidden data)
* Avoid editing the image in editors after encoding
* Image should be large enough to store the hidden message

---

## 🔮 Future Enhancements

* 🔒 AES encryption before embedding
* 🖼️ Support for JPEG, BMP, and GIF
* 🔐 Multi-user login and authentication
* 🧬 Support multiple messages per image
* 🖥️ GUI using JavaFX or React
* 📊 Digital watermarking support

---

## 👨‍💻 Author

**Chella Kumar**
GitHub: [@chellakumar007](https://github.com/chellakumar007)
