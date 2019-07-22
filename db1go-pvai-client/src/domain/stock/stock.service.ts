import axios from 'axios';
import Stock from './stock.entity';

export default class StockService {
  public static save(stock: Stock): Promise<any> {
    return axios.post('/api/v1/stock', stock);
  }

  public static getAll(): Promise<Stock[]> {
    return axios
      .get('/api/v1/stock')
      .then(response => response.data.map((stock: any) => new Stock(stock)));
  }
}
