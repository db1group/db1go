export default class DateHandler {
  public static toDate(value: string): Date {
    let valueToDate = this.removeMask(value);
    return new Date(`${valueToDate.slice(2, 4)} ${valueToDate.slice(0, 2)} ${valueToDate.slice(4, 8)}`);
  }

  public static toString(date: Date): string {
    if (date) {
      return `${this.getDay(date)}/${this.getMonth(date)}/${this.getYear(date)}`;
    }
    return "";
  }

  public static getDay(date: Date): string {
    return date ? this.toStringAndAddZeroIfNecessary(date.getDate()) : "";
  }

  public static getMonth(date: Date) {
    return date ? this.toStringAndAddZeroIfNecessary(date.getMonth() + 1) : "";
  }

  public static getYear(date: Date) {
    return date ? date.getFullYear() : "";
  }

  public static isValid(value: string): boolean {     
      console.log() 
    return !!value && this.removeMask(value).length === 8 && !!this.toDate(value).getDate();
  }

  public static removeMask(value: string): string {
      return value.replace('/', '').replace('/', '');
  }
  private static toStringAndAddZeroIfNecessary(value: number) {
    if (value && value < 10) {
      return `0${value}`;
    }
    return value ? value.toString() : "";
  }
}
