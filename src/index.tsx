import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-system-time' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const SystemTime = NativeModules.SystemTime
  ? NativeModules.SystemTime
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function checkTime(): Promise<string> {
  return new Promise((resolve, reject) => {
    SystemTime.checkTime(
      (error: any) => {
        reject(error);
      },
      (result: string) => {
        resolve(result);
      }
    );
  });
}

export function checkZone(): Promise<string> {
  return new Promise((resolve, reject) => {
    SystemTime.checkZone(
      (error: any) => {
        reject(error);
      },
      (result: string) => {
        resolve(result);
      }
    );
  });
}
