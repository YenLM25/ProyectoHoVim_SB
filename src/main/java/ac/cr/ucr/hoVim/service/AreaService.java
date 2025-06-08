package ac.cr.ucr.hoVim.service;

import ac.cr.ucr.hoVim.model.Area;
import ac.cr.ucr.hoVim.repository.AreaRegister;
import ac.cr.ucr.hoVim.repository.IAreaRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService implements IAreaRegister {

    @Autowired
    AreaRegister areaRegister;

    @Override
    public Area addArea(Area area) {

        return this.areaRegister.addArea(area);

    }

    @Override
    public List<Area> getAllAreas() {

        return this.areaRegister.getAllAreas();

    }

    @Override
    public Area getArea(Integer areaId) {

        return this.areaRegister.getArea(areaId);

    }

    @Override
    public Area deleteArea(Integer areaId) {

        return this.areaRegister.deleteArea(areaId);

    }

    @Override
    public Area editArea(Integer areaId, Area areaEdit) {
        return this.areaRegister.editArea(areaId, areaEdit);
    }

    @Override
    public Boolean existId(Integer areaId) {
        return this.areaRegister.existId(areaId);
    }

}
