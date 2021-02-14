package Test1;

import java.util.List;
public class RomanArabConvrt {

    public static int romanToArabic(String input) {
        String romanNumeral = input.toUpperCase();
        int result = 0;

        List<RomArabNumerals> romanNumerals = RomArabNumerals.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomArabNumerals symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }
        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(" Ошибка, число" + input + " не может быть конвертирован в Римскую цифру");
        }
        System.out.println(result);
        return result;
    }

    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 100)) {
            System.out.println("Ошибка, " + number + " число вне допустимых значений (0,100)");
            throw new IllegalArgumentException();
        }

        List<RomArabNumerals> romanNumerals = RomArabNumerals.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while (number > 0 && i < romanNumerals.size()) {
            RomArabNumerals currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}