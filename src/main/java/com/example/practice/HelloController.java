package com.example.practice;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import jssc.SerialPort;
import jssc.SerialPortException;

import java.net.URL;
import java.util.ResourceBundle;
public class HelloController {

    static SerialPort serialPort;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button but1;

    @FXML
    private Button but2;

    @FXML
    private Text text;

    @FXML
    void initialize() {

        but1.setOnAction(event -> {
            serialPort = new SerialPort("COM1");
            try {
                // открытие порта
                serialPort.openPort();
                // установка параметров
                serialPort.setParams(SerialPort.BAUDRATE_9600,
                            SerialPort.DATABITS_8,
                            SerialPort.STOPBITS_1,
                            SerialPort.PARITY_NONE);
                // вкл управления потоком
                serialPort.addEventListener(new PortReader(), SerialPort.MASK_RXCHAR);
                //Отправляем запрос устройству
                serialPort.writeString(text.getText() + "3");
            } catch (SerialPortException ex) {
                System.out.println(ex);
            }
        });

        but2.setOnAction(event -> {
            serialPort = new SerialPort("COM1");
            try {
                // открытие порта
                serialPort.openPort();
                // установка параметров
                serialPort.setParams(SerialPort.BAUDRATE_9600,
                        SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1,
                        SerialPort.PARITY_NONE);
                // вкл управления потоком
                serialPort.addEventListener(new PortReader(), SerialPort.MASK_RXCHAR);
                //Отправляем запрос устройству
                serialPort.writeString(text.getText() + "3");
            } catch (SerialPortException ex) {
                System.out.println(ex);
            }
        });
    }
}
