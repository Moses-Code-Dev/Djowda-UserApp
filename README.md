# Djowda-UserApp (Work in progress...)

The official user-facing app for Djowda, allowing customers to browse nearby stores, view product availability, place orders, and track delivery status. Designed for a seamless e-grocery shopping experience.

## Introduction

### Brief Overview of the User App: Its Purpose and Role in the Djowda Platform

The User App in the Djowda platform is designed to serve as the primary interface for end-users to interact with the system. Its main purpose is to provide users with access to various fresh food-related data and services. This app allows users to browse, order, and receive fresh food products such as vegetables, fruits, and possibly fish from different sources such as restaurants, stores, and farmers. It integrates with other apps within the Djowda ecosystem to ensure a seamless experience for users, from placing an order to delivery.

### High-Level Benefits and Features for Users

* **Convenience:** Users can easily browse and order fresh food from multiple sources through a single app.
* **Variety:** Access to a wide range of fresh food products including vegetables, fruits, and fish.
* **Real-Time Updates:** Users receive real-time updates on their orders, including delivery status.
* **Personalization:** The app can provide personalized recommendations based on user preferences and past orders.
* **Integration:** Seamless integration with other apps in the Djowda platform ensures efficient order processing and delivery.
* **Food Support Requests:** Users can request free food assistance. When a request is made, all stockholders receive a notification, and a random individual or entity from a pool of volunteers is assigned to provide the necessary help.
* **AI Assistance:** The app includes AI-driven chat and voice assistance to help users with their queries and provide support throughout their experience.
* **Educational Content:** The app provides educational content about healthy eating and nutrition to encourage better food choices.
* **Community Support:** Users can engage with the community, including selling, donating, and exchanging food from their gardens.

## Setup Instructions

### Prerequisites

- **Android Studio:** Version that supports Android API level 36 (Android 16). Download from [developer.android.com](https://developer.android.com/studio).
- **Java Development Kit (JDK):** Version 17 or higher. Ensure it's set in Android Studio.
- **Android SDK:** Will be installed via Android Studio.

### Installation

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/Moses-Code-Dev/Djowda-UserApp.git
   cd Djowda-UserApp
   ```

2. **Open in Android Studio:**
   - Launch Android Studio.
   - Select "Open an existing Android Studio project".
   - Navigate to the cloned directory and select it.

3. **Sync Gradle:**
   - Android Studio should automatically sync the project. If not, click "Sync Project with Gradle Files" from the toolbar.

4. **Configure SDK:**
   - Ensure the project SDK is set to API 36.
   - Go to File > Project Structure > Project SDK.

### Building and Running

1. **Build the Project:**
   - From the menu, select Build > Make Project.

2. **Run on Emulator or Device:**
   - Create an Android Virtual Device (AVD) if running on emulator.
   - Connect a physical device with USB debugging enabled.
   - Click the Run button (green play icon) or select Run > Run 'app'.

### Additional Notes

- The app uses Gradle with Kotlin DSL for build configuration.
- Some features (e.g., Firebase integration) are commented out in the build files and may require additional setup if enabled.
- For development, ensure you have the necessary permissions for location services as the app requires location access.

## User App Interactions with Other Apps

### User App Interactions with Other Apps

| App                  | Direct Interaction with User App? | Indirect Interaction with User App? |
|----------------------|:---------------------------------:|:-----------------------------------:|
| <img src="src/Store_App.png" alt="Store App" width="50" height="40"> Store App            | X                                 |                                     |
| <img src="src/Farmer_App.png" alt="Farmer App" width="50" height="40"> Farmer App           | X                                 |                                     |
| <img src="src/Delivery_Men_App.png" alt="Delivery Men App" width="50" height="40"> Delivery Men App     | X                                 |                                     |
| <img src="src/Store_Admin_App.png" alt="Store Admin App" width="50" height="40"> Store Admin App      | X                                 |                                     |
| <img src="src/Restaurants_App.png" alt="Restaurants App" width="50" height="40"> Restaurants App      | X                                 |                                     |
| <img src="src/App_for_Seed_Providers.png" alt="App for Seed Providers" width="50" height="40"> App for Seed Providers | X                               |                                     |
| <img src="src/User_App.png" alt="User App" width="50" height="40"> User App             | X                                 |                                     |
| <img src="src/Ai.png" alt="AI Assistance" width="40" height="40"> AI Assistance        | X                                 |                                     |
| <img src="src/Transport_App.png" alt="Transport App" width="50" height="40"> Transport App        |                                   | X                                   |
| <img src="src/Factory_App.png" alt="Factory App" width="50" height="40"> Factory App          |                                   | X                                   |
| <img src="src/Whole_Seller_App.png" alt="Whole Seller App" width="50" height="40"> Whole Seller App     |                                   | X                                   |


![User App Interactions](src/user_app_interactions.gif)



