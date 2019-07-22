import StockValue from "./stock-value.entity";
import DateHandler from "@/shared/date.handler";

export default class Stock {
  name: string = "";

  value: StockValue = new StockValue({});
  
  date!: Date;

  constructor(obj: any) {
    this.name = obj.name || '';
    this.value = new StockValue(obj.value || {});
    obj.date && (this.date = obj.date);
  }

  set formatedDate(value: string) {
    value && value.length === 8 && (this.date = DateHandler.toDate(value));
  }

  get formatedDate(): string {
    return DateHandler.toString(this.date);
  }
}
