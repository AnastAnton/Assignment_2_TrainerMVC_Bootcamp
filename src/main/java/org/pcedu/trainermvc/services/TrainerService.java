package org.pcedu.trainermvc.services;

import java.util.List;
import org.pcedu.trainermvc.dao.ITrainerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service 
@Transactional
public class TrainerService implements ITrainer{
    @Autowired
    ITrainerDao dao;

    public List<org.pcedu.trainermvc.entities.Trainer> findAllTrainers() {
        List<org.pcedu.trainermvc.entities.Trainer> trainers = dao.findAllTrainers();
        return(trainers);
    }

    public org.pcedu.trainermvc.entities.Trainer findById(int id) {
        return(dao.findById(id));
    }

    public boolean save(org.pcedu.trainermvc.entities.Trainer trainer) {
        return(dao.save(trainer));
    }

    public boolean delete(int id) {
        return(dao.delete(id));
    }

    public boolean update(org.pcedu.trainermvc.entities.Trainer trainer) {
        dao.update(trainer);
        return (true);
    }

    protected String convertTextToUpper(String text) {
        return text.toUpperCase();
    }

}
