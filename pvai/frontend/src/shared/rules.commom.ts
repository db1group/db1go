import DateHandler from './date.handler';

export default class Rules {
    readonly name = [
        (value: string) => !!value || 'Nome é obrigatório.',
        (value: string) => !!value && value.length > 3 || 'Nome deve ter mais que que 3 caracteres.',
    ]
    readonly number = [
        (value: number) => !!value || 'Valor é obrigatório.',
        (value: number) => !!value && value > 0 || 'Valor tem que ser maior que "0".',
    ]
    readonly date = [
        (value: string) => !!value || 'Data é obrigatório',
        (value: string) => DateHandler.isValid(value) || 'Data Inválida',
    ]
}
