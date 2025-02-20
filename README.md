# React Native Project Setup Guide

## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Node.js**: Install Node.js (version 18 or higher) from [nodejs.org](https://nodejs.org/).
- **Yarn**: Install Yarn package manager from [yarnpkg.com](https://yarnpkg.com/).


## Setup Instructions

Follow these steps to set up and run the Android project:

1. **Install Dependencies**:
    ```sh
    yarn install
    ```

2. **Start Metro Bundler**:
    ```sh
    yarn start
    ```

4. **Run the Android Project**:
    - Open Android Studio.
    - Click on `File` > `Open` and select the `android` folder in the cloned repository.
    - Wait for Android Studio to sync the project.
    - Connect an Android device via USB or start an Android emulator.
    - Run the project by clicking the `Run` button or using the following command:
        ```sh
        yarn android
        ```

## Additional Information

- **Clearing Metro Bundler Cache**:
  If you encounter issues, try clearing the Metro Bundler cache:
    ```sh
    yarn start --reset-cache
    ```

- **Reinstalling Node Modules**:
  If dependencies are not installed correctly, delete the `node_modules` directory and reinstall:
    ```sh
    rm -rf node_modules
    yarn install
    ```

- **Metro Configuration**:
  Ensure your `metro.config.js` is correctly configured to handle assets and other settings.

- **Babel Configuration**:
  Check your `babel.config.js` for proper presets and plugins configuration.

## Troubleshooting

- **Common Issues**:
    - Ensure all prerequisites are installed and configured correctly.
    - Check for any error messages in the terminal and follow the suggested solutions.
    - Refer to the official React Native documentation for more detailed troubleshooting steps: [React Native Docs](https://reactnative.dev/docs/getting-started).
