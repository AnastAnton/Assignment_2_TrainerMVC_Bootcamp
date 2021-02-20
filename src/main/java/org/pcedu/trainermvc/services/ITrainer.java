package org.pcedu.trainermvc.services;

import java.util.List;
import org.pcedu.trainermvc.entities.Trainer;


public interface ITrainer {
    public List<Trainer> findAllTrainers();
    public Trainer findById(int id);
    public boolean save(Trainer trainer);
    public boolean delete(int id);
    public boolean update(Trainer trainer);
}
