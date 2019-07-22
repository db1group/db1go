export default class StockValue {
    start: number;
    end: number;

    constructor(obj: any) {
        this.start = obj.start || 0;
        this.end = obj.end || 0;
    }
}