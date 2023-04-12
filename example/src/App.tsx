import * as React from 'react';

import { StyleSheet, View, Text, Button } from 'react-native';
import { checkTime, checkZone } from 'react-native-system-time';

export default function App() {
  const [isTimeAuto, setIsTimeAuto] = React.useState<string>('');
  const [isZoneAuto, setIsZoneAuto] = React.useState<string>('');

  function _checkTime() {
    checkTime()
      .then((result: string | boolean) => {
        setIsTimeAuto(result);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  function _checkZone() {
    checkZone()
      .then((result: string | boolean) => {
        setIsZoneAuto(result);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  return (
    <View style={styles.container}>
      <Text>Time Auto: {isTimeAuto.toString()}</Text>
      <Button title="Check Time" onPress={() => _checkTime()} />
      <Text>Zone Auto: {isZoneAuto.toString()}</Text>
      <Button title="Check Zone" onPress={() => _checkZone()}></Button>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
