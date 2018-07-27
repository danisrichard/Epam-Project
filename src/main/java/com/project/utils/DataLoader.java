package com.project.utils;

import com.project.model.cinemaproject.equipment.Equipment;
import com.project.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DataLoader {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public void loadCinemaEquipmentToRepository(){

        Equipment equipmentFloorAre = new Equipment();
        equipmentFloorAre.setName("+1m\u200B\n" +
                "2\u200Balapterület");
        equipmentFloorAre.setEquipmentDesc("1 m2 szabad\u200Bterülettel bővül a termünk");
        equipmentFloorAre.setPrice(200);

        Equipment equipmentNewSeat = new Equipment();
        equipmentNewSeat.setName("+1 ülőhely ");
        equipmentNewSeat.setEquipmentDesc("1 ülőhely. 1 m2 szabad \u200Bterületet igényel");
        equipmentNewSeat.setPrice(50);

        Equipment equipmentCanvas = new Equipment();
        equipmentCanvas.setName("Vetítővászon");
        equipmentCanvas.setEquipmentDesc("5 m2 szabad\u200Bterület szükséges a tétel megvásárlásához");
        equipmentCanvas.setPrice(1000);

        Equipment equipmentTwoD = new Equipment();
        equipmentTwoD.setName("2D vetítőgép*");
        equipmentTwoD.setEquipmentDesc("2 m2 szabad\u200Bterület szükséges a tétel megvásárlásához,\n" +
                "ennek segítségével vetíthető 2D filmeket.\n");
        equipmentTwoD.setPrice(5000);

        Equipment equipmentThreeD = new Equipment();
        equipmentThreeD.setName("3D vetítőgép*");
        equipmentThreeD.setEquipmentDesc("4 m2 szabad\u200Bterület szükséges a tétel megvásárlásához,\n" +
                "ennek segítségével vetíthetünk 2D és 3D filmeket\n" +
                "egyaránt");
        equipmentThreeD.setPrice(9000);

        equipmentRepository.save(equipmentCanvas);
        equipmentRepository.save(equipmentFloorAre);
        equipmentRepository.save(equipmentNewSeat);
        equipmentRepository.save(equipmentThreeD);
        equipmentRepository.save(equipmentTwoD);

    }
}
