import StockValue from './stock-value.entity'
import DateHandler from '@/shared/date/date-handler';
export default class Stock {

    id: string;
    name: string;
    date: string;
    value: StockValue;

    constructor(obj: any) {
        this.id = obj.id;
        this.name = obj.name || '';
        this.date = obj.date || '';
        this.value = new StockValue(obj.value || {})
    }

    get dateFormated() {        
        return DateHandler.toDatePtBr(this.date);
    }

    set dateFormated(value: string) {        
        this.date = DateHandler.toDateEn(value);
    }
}