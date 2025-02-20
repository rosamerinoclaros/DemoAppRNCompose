import React from 'react';
import {
    View,
    Text,
    StyleSheet,
    ScrollView,
    FlatList
} from 'react-native';
import { AppRegistry } from 'react-native';

const data = Array.from({ length: 100 }, (_, i) => `Item ${i + 1}`);

const renderItem = ({ item }) => (
    <View style={styles.item}>
        <Text>{item}</Text>
    </View>
);

const renderHeader = () => (
    <View style={styles.header}>
        <Text>Sticky Header</Text>
    </View>
);

const ScrollingLists = () => {
    return (
        <ScrollView horizontal style={styles.container} nestedScrollEnabled>
            <View style={styles.listContainer}>
                <FlatList
                    data={data}
                    renderItem={renderItem}
                    keyExtractor={(item) => item}
                    ListHeaderComponent={renderHeader}
                    stickyHeaderIndices={[0]}
                    nestedScrollEnabled
                />
            </View>
            <View style={styles.listContainer}>
                <FlatList
                    data={data}
                    renderItem={renderItem}
                    keyExtractor={(item) => item}
                    ListHeaderComponent={renderHeader}
                    stickyHeaderIndices={[0]}
                    nestedScrollEnabled
                />
            </View>
        </ScrollView>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: 'white',
    },
    listContainer: {
        borderWidth: 1,
        borderColor: 'black',
        margin: 10,
        padding: 10,
    },
    item: {
        width: 500,
        borderWidth: 1,
        borderColor: 'gray',
        padding: 10,
        marginVertical: 5,
    },
    header: {
        backgroundColor: 'lightgray',
        padding: 10,
        borderBottomWidth: 1,
        borderBottomColor: 'gray',
    },
});

AppRegistry.registerComponent("RnComposeIncompatibility", () => ScrollingLists);