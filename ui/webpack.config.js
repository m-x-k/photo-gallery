var webpack = require('webpack');

var config = {
   entry: './main.js',
	
   output: {
      path:'./',
      filename: 'index.js',
   },
	
   devServer: {
      inline: true,
      port: 8080
   },

   plugins: [
      new webpack.DefinePlugin({
         'DEV_MODE': false,
         'APP_URL': JSON.stringify("http://192.168.99.100:8081/")
      })
   ],
	
   module: {
      loaders: [
         {
            test: /\.jsx?$/,
            exclude: /node_modules/,
            loader: 'babel',
				
            query: {
               presets: ['es2015', 'react']
            }
         }
      ]
   }
}

module.exports = config;