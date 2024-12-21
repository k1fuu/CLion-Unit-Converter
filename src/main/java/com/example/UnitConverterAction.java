package com.example;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;

public class UnitConverterAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // Текстовое сообщение для выбора конвертации (без "Метры в километры" и "Граммы в килограммы")
        String[] options = {
                "Цельсий в Фаренгейт",
                "Километры в мили",
                "Сантиметры в дюймы",
                "Метры в ярды",
                "Килограммы в фунты",
                "Сантиметры в футы"
        };

        // Показать диалог с вариантами для выбора
        int selectedOption = Messages.showDialog(
                "Выберите единицу измерения для конвертации:",
                "Unit Converter",
                options,
                0, // индекс кнопки по умолчанию
                Messages.getQuestionIcon()
        );

        if (selectedOption != -1) { // Если выбран вариант (не нажата кнопка Cancel)
            String selectedUnit = options[selectedOption]; // Определяем выбранную единицу измерения
            performConversion(selectedUnit);  // Вызов функции для конвертации
        }
    }

    // Основная функция, которая отвечает за выполнение конвертации
    private void performConversion(String selectedUnit) {
        // Запрашиваем ввод числа для конвертации
        String inputValue = Messages.showInputDialog(
                "Введите значение для конвертации:",
                "Введите число",
                Messages.getQuestionIcon()
        );

        if (inputValue != null && !inputValue.trim().isEmpty()) {
            try {
                double value = Double.parseDouble(inputValue);
                String result = convertUnits(selectedUnit, value);
                Messages.showInfoMessage(result, "Результат конвертации");
            } catch (NumberFormatException ex) {
                Messages.showErrorDialog("Ошибка ввода! Пожалуйста, введите корректное число.", "Invalid Input");
            }
        } else {
            Messages.showErrorDialog("Пожалуйста, введите значение.", "Invalid Input");
        }
    }

    // Метод для конвертации в зависимости от выбранной единицы измерения
    private String convertUnits(String selectedUnit, double value) {
        double result;
        String resultString;

        switch (selectedUnit) {
            case "Цельсий в Фаренгейт":
                result = (value * 9 / 5) + 32;
                resultString = value + " градусов Цельсия = " + result + " градусов Фаренгейта";
                break;
            case "Километры в мили":
                result = value * 0.621371;
                resultString = value + " километров = " + result + " миль";
                break;
            case "Сантиметры в дюймы":
                result = value * 0.393701;
                resultString = value + " сантиметров = " + result + " дюймов";
                break;
            case "Метры в ярды":
                result = value * 1.09361;
                resultString = value + " метров = " + result + " ярдов";
                break;
            case "Килограммы в фунты":
                result = value * 2.20462;
                resultString = value + " килограммов = " + result + " фунтов";
                break;
            case "Сантиметры в футы":
                result = value * 0.0328084;
                resultString = value + " сантиметров = " + result + " футов";
                break;
            default:
                resultString = "Неизвестная конвертация.";
                break;
        }
        return resultString;
    }
}
