export default class DateHandler {
  static toDatePtBr(date: string): string {
    if (date && date.length === 10) {
      const dateSplited = date.split('-');
      return `${dateSplited[2]}/${dateSplited[1]}/${dateSplited[0]}`;
    }
    return '';
  }

  static toDateEn(date: string) {
    if (date && date.length === 10) {
      const dateSplited = date.split('/');
      return `${dateSplited[2]}-${dateSplited[1]}-${dateSplited[0]}`;
    }
    return '';
  }

  static isPtBrValidDate(date: string) {
    return !!date && date.length === 10 && !!new Date(this.toDateEn(date)).getDate();
  }
}
