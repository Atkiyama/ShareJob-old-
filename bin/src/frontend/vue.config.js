// vue.config.js
module.exports = {
    // https://cli.vuejs.org/config/#devserver-proxy
    devServer: {
        port: 3000,
        proxy: {
            '/index': {
                target: 'http://localhost:8080',
                
            }
        }
    }
}