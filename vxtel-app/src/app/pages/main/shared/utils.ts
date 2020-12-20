export class Util {

  constructor() { }

    static formatRealWhitValueZero(value: string) {
        if (value == '0') {
            return 'R$ 0,00';
        }

        return 'R$ ' + this.formatReal(value);
    }

    static formatReal(value: string) {
        var tmp = value.replace('.', '');
        tmp = tmp.replace(/([0-9]{2})$/g, ",$1");
        if (tmp.length > 6)
            tmp = tmp.replace(/([0-9]{3}),([0-9]{2}$)/g, ".$1,$2");

        return tmp;
    }
}
