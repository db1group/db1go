module.exports = {
    devServer: {
        port: 4200,
        proxy: {
            '^/stocks': {
                target: 'http://localhost:8080',
                ws: true,
                changeOrigin: true
            }
        }
    }
}