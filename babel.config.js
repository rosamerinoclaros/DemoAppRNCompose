module.exports = function (api) {
    api.cache(true);
    return {
        presets: ['module:@react-native/babel-preset', '@babel/typescript'],
        plugins: [
            ['@babel/plugin-proposal-decorators', { legacy: true }],
            [
                'module-resolver',
                {
                    root: ['./src'],
                    extensions: ['.js', '.ts', '.tsx', '.ios.js', '.android.js'],
                    alias: {
                        "@components": "./src/components",
                        "@screens": "./src/screens",
                        "@assets": "./src/assets"
                    }
                },
            ],
        ],
    };
};
