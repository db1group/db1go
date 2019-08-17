module.exports = {
    devServer: {
        port: 4200,
        proxy: {
            '^/stocks': {
                target: 'http://35.193.36.55:80',
                ws: true,
                changeOrigin: true
            }
        }
    }
}
