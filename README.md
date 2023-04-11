# react-native-system-time

THIS PACKAGE IS ONLY FOR ANDROID
react-native-system-time is a package for React Native that provides a simple and easy-to-use API for checking whether the system time and time zone are set to automatic or not. The package uses Kotlin to access the Android system settings and retrieve the current settings for the system time and time zone.

## Installation

```sh
npm install react-native-system-time
```

## Usage

```js
import { checkTime, checkZone } from 'react-native-system-time';
function _checkTime() {
  checkTime()
    .then((result) => {
      console.log(result);
    })
    .catch((error) => {
      console.error(error);
    });
}

function _checkZone() {
  checkZone()
    .then((result) => {
      console.log(result);
    })
    .catch((error) => {
      console.error(error);
    });
}
// ...
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
