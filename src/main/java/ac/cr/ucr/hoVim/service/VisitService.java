package ac.cr.ucr.hoVim.service;

import ac.cr.ucr.hoVim.model.Visit;
import ac.cr.ucr.hoVim.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    public Visit saveVisit (Visit visit){
        return this.visitRepository.save(visit);
    }

    public List<Visit> findAllVisits(){
        return this.visitRepository.findAll();
    }

    public Optional<Visit> findByIdVisit(Integer visitId) {

        return this.visitRepository.findById(visitId);
    }

    public void deleteVisit(Integer visitId) {

        this.visitRepository.deleteById(visitId);
    }

    public Visit editVisit(Integer visitId, Visit visitEdited) {
        Optional<Visit> visitOp = this.visitRepository.findById(visitId);
        if (visitOp.isPresent()) {
            Visit visit = visitOp.get();

            visit.setPatientId(visitEdited.getPatientId());
            visit.setStatus(visitEdited.getStatus());
            visit.setDate(visitEdited.getDate());

            return this.visitRepository.save(visit);
        }

        return null;
    }





}//End of class
