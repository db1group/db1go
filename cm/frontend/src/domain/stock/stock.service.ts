import axios from 'axios';
import Stock from './stock.entity'

export default class StockService {
    public static getAll(): Promise<Stock[]> {
        return axios
        .get('/stocks')
        .then(response => 
            response.data
            .map((stock: any) => new Stock(stock)));
    }

    public static save(stock: Stock): Promise<any> {
        return axios.post('/stocks', stock);
    }

    public static getOne(id: string): Promise<Stock> {
        return axios
        .get(`/stocks/${id}`)
        .then(response => new Stock(response.data));
    }

    public static update(id: string, stock: Stock): Promise<any> {
        return axios
                .put(`/stocks/${id}`, stock);
    }
}
