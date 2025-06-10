package ac.cr.ucr.hoVim.service;

import ac.cr.ucr.hoVim.model.Area;
import ac.cr.ucr.hoVim.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {

    @Autowired
    AreaRepository areaRepository;

    public Area saveArea(Area area) {

        return this.areaRepository.save(area);

    }

    public List<Area> findAllAreas() {

        return this.areaRepository.findAll();

    }

    public Optional<Area> findAreaById(Integer areaId) {

        return this.areaRepository.findById(areaId);

    }

    public void deleteArea(Integer areaId) {

        this.areaRepository.deleteById(areaId);

    }

    public Area editArea(Integer areaId, Area areaEdit) {

        Optional<Area> areaOp= this.areaRepository.findById(areaId);

        if(areaOp.isPresent()) {

            Area area= areaOp.get();
            area = areaEdit;
            return this.areaRepository.save(area);

        }

        return null;    }


}
