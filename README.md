Overview




•	Login Screen: Users authenticate with a username and password.


•	Dashboard Screen: Displays a list of entities using data retrieved from the API.


•	Details Screen: Shows detailed information about a selected entity.
API Endpoints


•	Base URL: https://vu-nit3213-api.onrender.com


•	Authentication Endpoint: /sydney/auth (for obtaining the keypass)


•	Dashboard Endpoint: /dashboard/{keypass} (replace {keypass} with the actual keypass received after login)
Setup Instructions
1. Clone the Repository
To get a local copy of the project, you'll need to clone the repository. Open a terminal or command prompt and run:
git clone <repository_url>
Replace <repository_url> with the actual URL of your Git repository.
2. Open the Project
1.	Open Android Studio: Launch Android Studio on your computer.
2.	Open Project:
o	Click on "Open" from the Welcome screen or go to File > Open if you have another project already open.
o	Navigate to the directory where you cloned the repository and select the project folder.
3. Add Dependencies
Your project requires several dependencies for various functionalities. You'll need to add these to your build.gradle files.
1.	Project-Level build.gradle:
o	Open build.gradle in the root of your project (Project level).
o	Add the Kotlin and Hilt plugin dependencies under the dependencies section.
2.	Module-Level build.gradle:
o	Open build.gradle in the app module (Module level).
o	Add all necessary dependencies for Kotlin, Hilt, Retrofit, Moshi, and OkHttp under the dependencies section.
Here’s a summary of what to add to your build.gradle files:
•	Kotlin Plugin: For Kotlin language support.
•	Hilt Plugin: For dependency injection.
•	Retrofit: For network requests.
•	Moshi: For JSON parsing.
•	OkHttp: For HTTP client and logging.
4. Sync the Project
After adding the dependencies, you need to sync your project to download and integrate them:
1.	Sync Now: In Android Studio, you should see a prompt to "Sync Now" at the top of the editor. Click it.
2.	Manual Sync: If the prompt doesn’t appear, go to File > Sync Project with Gradle Files to manually start the synchronization.
5. Run the App
1.	Build the Project: Click on the “Build” menu and select “Rebuild Project” to ensure everything is set up correctly.
2.	Run the App:
o	Connect an Android device or start an emulator.
o	Click the green “Run” button (a triangle icon) or select Run > Run 'app' from the menu.
6. Login and Navigate
1.	Login Screen: Enter the credentials (first name as username and student ID as password) to log in.
2.	Dashboard Screen: Once logged in, you’ll be navigated to the Dashboard screen where a list of entities will be displayed.
3.	Details Screen: Click on any item in the list to view its detailed information on the Details screen.

![image](https://github.com/user-attachments/assets/34600c2e-80c3-4bda-9d3d-a2c98b542a42)
