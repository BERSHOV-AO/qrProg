package ru.nak.ied.qrprog.data.entities;

import java.time.LocalDate;
import java.util.List;

/**
 * List<String> list = new ArrayList<>();
 * // Добавляем элементы в список
 * list.add("первый");
 * list.add("второй");
 * list.add("третий");
 *
 * // Получаем последний элемент
 * String lastElement = list.get(list.size() - 1);
 * System.out.println(lastElement); // Выведет "третий"
 *
 * List<String> list = new ArrayList<>();
 * // Добавляем элементы в список
 * list.add("первый");
 * list.add("второй");
 * list.add("третий");
 *
 * // Получаем последний элемент
 * String lastElement = list.stream().reduce((first, second) -> second).orElse(null);
 * System.out.println(lastElement); // Выведет "третий"
 */
public class Equipment {
    private int qrCode;
    private String name; //тип
    private int serialNumber; // инвент ном
    private List<ServiceInfo> serviceInfoList;

    public Equipment() {
    }

    public Equipment(int qrCode, String name, int serialNumber, List<LocalDate> serviceDate) {
        this.qrCode = qrCode;
        this.name = name;
        this.serialNumber = serialNumber;
       // this.serviceDate = serviceDate;
    }

    public int getQrCode() {
        return qrCode;
    }

    public void setQrCode(int qrCode) {
        this.qrCode = qrCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

//    public List<LocalDate> getServiceDate() {
//        return serviceDate;
//    }
//
//    public void setServiceDate(List<LocalDate> serviceDate) {
//        this.serviceDate = serviceDate;
//    }

    @Override
    public String toString() {
        return "Equipment{" +
                "qrCode=" + qrCode +
                ", name='" + name + '\'' +
                ", serialNumber=" + serialNumber +
         //       ", serviceDate=" + serviceDate +
                '}';
    }
}
