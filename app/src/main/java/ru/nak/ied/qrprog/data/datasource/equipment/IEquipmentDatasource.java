package ru.nak.ied.qrprog.data.datasource.equipment;

import java.util.Map;

import ru.nak.ied.qrprog.data.entities.Equipment;

public interface IEquipmentDatasource {

    public void addEquipment(Integer qrCodeNum, Equipment equipment);
    public void deleteEquipment(Integer qrCodeNum);
    public Map<Integer, Equipment> getEquipment();
    public void setEquipment(Map<Integer, Equipment> equipmentMap);
}
