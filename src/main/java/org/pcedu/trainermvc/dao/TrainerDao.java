package org.pcedu.trainermvc.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.pcedu.trainermvc.entities.Trainer;
import org.springframework.stereotype.Repository;

@Repository 
public class TrainerDao extends AbstractDao<Integer, Trainer> implements ITrainerDao{

    public List<Trainer> findAllTrainers() {
        Criteria criteria = createEntityCriteria();
	return (criteria.list());
    }

    public Trainer findById(int id) {
        Trainer t = getByKey(id);
        if(t != null) {
            return t;
        }
        return null;
    }

    public boolean save(Trainer trainer) {
        boolean notSaved = persist(trainer);
        if(notSaved) return false;
        return true;
    }

    public boolean delete(int id) {
        Trainer t = getByKey(id);
        if(t != null) {
            delete(t);
            if(getByKey(id) == null) 
                return true;
        }
        return false;
    }

    public boolean update(Trainer trainer) {
        Trainer t = findById(trainer.getId());
        if(t != null){
            t.setFirstName(trainer.getFirstName());
            t.setLastName(trainer.getLastName());
            t.setSubject(trainer.getSubject());
            return save(t);
        }else{
            return (false);
        }
    }



}
