## **Prerequisites**

- A Mac computer running macOS.
- Administrator access to install software.

---

## **1. General Setup**

### **1.1 Install Homebrew (Package Manager)**

Homebrew simplifies the installation of software on macOS.

**Install Homebrew:**

Open the Terminal app and run:

```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

**Update Homebrew:**

```bash
brew update
```

### **1.2 Install Git**

Check if Git is installed:

```bash
git --version
```

If not installed, install Git:

```bash
brew install git
```

---

## **2. Backend Setup (Java with Spring Boot)**

### **2.1 Install Java Development Kit (JDK)**

**Install OpenJDK 17 (LTS version):**

```bash
brew install openjdk@17
```

**Set up the Java environment:**

Add the following to your shell profile (`~/.zshrc`, `~/.bash_profile`, or `~/.bashrc`):

```bash
export PATH="/usr/local/opt/openjdk@17/bin:$PATH"
export JAVA_HOME=$(/usr/libexec/java_home -v17)
```

Reload your shell profile:

```bash
source ~/.zshrc  # or the appropriate file
```

**Verify Java installation:**

```bash
java -version
```

### **2.2 Install Maven**

```bash
brew install maven
```

**Verify Maven installation:**

```bash
mvn -version
```

### **2.3 Install an IDE (Integrated Development Environment)**

**Download IntelliJ IDEA Community Edition:**

- Go to [JetBrains IntelliJ IDEA Download Page](https://www.jetbrains.com/idea/download/#section=mac).
- Download and install the macOS version.

### **2.4 Install a Database**

You can use PostgreSQL for your relational database.

**Install PostgreSQL:**

```bash
brew install postgresql
```

**Start PostgreSQL service:**

```bash
brew services start postgresql
```

**Initialize PostgreSQL (if required):**

```bash
initdb /usr/local/var/postgres
```

**Create a new database user (optional):**

```bash
createuser your_username -P --interactive
```

**Create a new database:**

```bash
createdb your_database_name
```

### **2.5 Install Postman for API Testing**

**Download Postman:**

- Visit [Postman Download Page](https://www.postman.com/downloads/).
- Download and install the macOS app.

---

## **3. Web Frontend Setup (React.js)**

### **3.1 Install Node.js and npm**

**Install Node.js (includes npm):**

```bash
brew install node
```

**Verify installations:**

```bash
node -v
npm -v
```

### **3.2 Install Yarn (Optional but recommended)**

```bash
brew install yarn
```

### **3.3 Install an Editor**

**Download Visual Studio Code:**

- Visit [VS Code Download Page](https://code.visualstudio.com/Download).
- Download and install the macOS version.

### **3.4 Install Create React App**

**Install globally (optional):**

```bash
npm install -g create-react-app
```

---

## **4. Mobile App Setup (React Native)**

### **4.1 Install Watchman**

Watchman watches files and triggers actions when they change.

```bash
brew install watchman
```

### **4.2 Install React Native CLI or Expo CLI**

**Option 1: React Native CLI**

```bash
npm install -g react-native-cli
```

**Option 2: Expo CLI (Recommended for easier setup)**

```bash
npm install -g expo-cli
```

### **4.3 Install Xcode (For iOS development)**

- Open the **App Store** on your Mac.
- Search for **Xcode** and install it.
- After installation, open Xcode and accept the license agreement.
- Install additional components if prompted.

**Install Xcode Command Line Tools:**

```bash
xcode-select --install
```

### **4.4 (Optional) Set Up Android Development Environment**

If you plan to develop for Android:

**Download Android Studio:**

- Visit [Android Studio Download Page](https://developer.android.com/studio).
- Download and install the macOS version.

**Set up Android SDK:**

- Open Android Studio.
- Follow the setup wizard to install SDKs and tools.
- Set environment variables in your shell profile (`~/.zshrc`, `~/.bash_profile`, or `~/.bashrc`):

  ```bash
  export ANDROID_HOME=$HOME/Library/Android/sdk
  export PATH=$PATH:$ANDROID_HOME/emulator
  export PATH=$PATH:$ANDROID_HOME/tools
  export PATH=$PATH:$ANDROID_HOME/tools/bin
  export PATH=$PATH:$ANDROID_HOME/platform-tools
  ```

**Reload your shell profile:**

```bash
source ~/.zshrc  # or the appropriate file
```

---

## **5. Version Control Setup**

### **5.1 Configure Git**

**Set your Git username and email:**

```bash
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"
```

---

## **6. Additional Tools**

### **6.1 Install Docker (Optional for Containerization)**

If you plan to use Docker:

- Visit [Docker Desktop for Mac](https://www.docker.com/products/docker-desktop).
- Download and install Docker Desktop for macOS.

### **6.2 Install ESLint and Prettier (Code Quality Tools)**

**Globally install ESLint and Prettier:**

```bash
npm install -g eslint prettier
```

---

## **7. Project Initialization**

### **7.1 Backend Project Setup**

**Option 1: Using Spring Initializr Website**

1. Go to [Spring Initializr](https://start.spring.io/).
2. Configure the project:
   - **Project:** Maven Project
   - **Language:** Java
   - **Spring Boot:** Latest stable version
   - **Group:** com.yourapp
   - **Artifact:** backend
   - **Packaging:** Jar
   - **Java:** 17
3. Add Dependencies:
   - **Spring Web**
   - **Spring Data JPA**
   - **PostgreSQL Driver**
   - **Spring Security**
   - **Spring Boot DevTools** (optional)
4. Click **Generate** to download the project.
5. Unzip the project and open it in IntelliJ IDEA.

**Option 2: Using IntelliJ IDEA**

1. Open IntelliJ IDEA.
2. Click **New Project**.
3. Select **Spring Initializr**.
4. Configure the project as above.

### **7.2 Web Frontend Project Setup**

**Create a new React app:**

```bash
npx create-react-app your-web-app
```

**Navigate to the project directory:**

```bash
cd your-web-app
```

**Start the development server:**

```bash
npm start
```

### **7.3 Mobile App Project Setup**

**Option 1: Using React Native CLI**

```bash
npx react-native init YourMobileApp
```

**Navigate to the project directory:**

```bash
cd YourMobileApp
```

**Run the iOS app:**

```bash
npx react-native run-ios
```

**Option 2: Using Expo CLI (Recommended)**

```bash
expo init YourMobileApp
```

- Choose a template (e.g., blank managed workflow).
- Navigate to the project directory:

  ```bash
  cd YourMobileApp
  ```

- Start the development server:

  ```bash
  npx expo start
  ```

- Use the Expo app on your iOS device or simulator to run the app.

---

## **8. Configure Environment Variables**

### **8.1 Backend Environment Variables**

Create an `.env` file in your backend project to store environment variables like database credentials, API keys, etc.

**Example `.env` file:**

```properties
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/your_database_name
SPRING_DATASOURCE_USERNAME=your_username
SPRING_DATASOURCE_PASSWORD=your_password
JWT_SECRET=your_jwt_secret
TMDB_API_KEY=your_tmdb_api_key
```

### **8.2 Frontend Environment Variables**

Create a `.env` file in your React.js project root:

```env
REACT_APP_API_BASE_URL=http://localhost:8080/api
REACT_APP_TMDB_API_KEY=your_tmdb_api_key
```

---

## **9. Install Project Dependencies**

### **9.1 Backend Dependencies**

Add dependencies to your `pom.xml` or `build.gradle` as needed. Use Maven or Gradle commands to install them.

**Example (Maven):**

```xml
<dependencies>
    <!-- Spring Boot Starter Dependencies -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <!-- Add other dependencies -->
</dependencies>
```

**Install dependencies:**

```bash
mvn clean install
```

### **9.2 Web Frontend Dependencies**

Navigate to your React.js project directory.

**Install required packages:**

```bash
npm install axios redux react-redux @material-ui/core @material-ui/icons react-router-dom
```

### **9.3 Mobile App Dependencies**

Navigate to your React Native project directory.

**Install required packages:**

```bash
npm install axios redux react-redux @react-navigation/native @react-navigation/stack react-native-elements
```

**Install React Navigation dependencies:**

```bash
expo install react-native-gesture-handler react-native-reanimated react-native-screens react-native-safe-area-context @react-native-community/masked-view
```

---

## **10. Verify the Setup**

### **10.1 Backend**

- Run your Spring Boot application from IntelliJ IDEA.
- Check the console for any errors.
- Access `http://localhost:8080` to verify it's running.

### **10.2 Web Frontend**

- In your React.js project directory, start the app:

  ```bash
  npm start
  ```

- The app should open in your default browser at `http://localhost:3000`.

### **10.3 Mobile App**

- Start the development server:

  ```bash
  expo start
  ```

- Use the iOS simulator or Expo app on your device to run the app.

---

## **11. Set Up Linting and Formatting**

### **11.1 ESLint and Prettier for Web and Mobile**

**Install ESLint and Prettier in your projects:**

```bash
npm install --save-dev eslint prettier eslint-plugin-react eslint-config-prettier eslint-plugin-prettier
```

**Create `.eslintrc.js` file:**

```javascript
module.exports = {
  parser: 'babel-eslint',
  extends: ['plugin:react/recommended', 'prettier'],
  plugins: ['react', 'prettier'],
  rules: {
    'prettier/prettier': 'error',
  },
};
```

**Create `.prettierrc` file:**

```json
{
  "singleQuote": true,
  "trailingComma": "all"
}
```

### **11.2 Configure IDE Extensions**

- Install ESLint and Prettier extensions in VS Code.
- Enable format on save in VS Code settings.

---

## **12. Optional: Install Testing Tools**

### **12.1 Backend Testing**

- Add JUnit and Mockito dependencies to your `pom.xml`.

### **12.2 Frontend Testing**

**Install testing libraries:**

```bash
npm install --save-dev jest @testing-library/react @testing-library/jest-dom
```

---

## **13. Obtain API Keys**

### **13.1 TMDb API Key**

- Sign up at [TMDb](https://www.themoviedb.org/).
- Obtain an API key from your account settings.
- Add the API key to your backend and frontend `.env` files.

---

## **14. Summary**

You have now:

- Installed all necessary tools and software on your macOS system.
- Set up the backend development environment with Java and Spring Boot.
- Set up the web frontend environment with React.js.
- Set up the mobile app environment with React Native.
- Initialized your projects and verified that they run successfully.

---

## **Next Steps**

- **Start coding your backend API endpoints and services.**
- **Develop your React.js frontend components and pages.**
- **Build your React Native mobile app screens and navigation.**
- **Implement authentication, database interactions, and API integrations.**
