package com.example;

public class UnitConverter {

    // Метод для конвертации километров в мили
    public static double kmToMiles(double km) {
        return km * 0.621371;
    }

    // Метод для конвертации сантиметров в дюймы
    public static double cmToInches(double cm) {
        return cm * 0.393701;
    }

    // Метод для конвертации килограммов в фунты
    public static double kgToPounds(double kg) {
        return kg * 2.20462;
    }

    // Метод для конвертации сантиметров в футы
    public static double cmToFeet(double cm) {
        return cm * 0.0328084;
    }

    // Метод для конвертации Цельсия в Фаренгейт
    public static String convertUnits(String unit, double value) {
        if (unit.equals("Цельсий в Фаренгейт")) {
            return value * 9/5 + 32 + " °F";
        }
        return "Unsupported conversion";
    }
}
