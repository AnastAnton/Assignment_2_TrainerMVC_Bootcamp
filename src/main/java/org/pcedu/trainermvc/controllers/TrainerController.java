package org.pcedu.trainermvc.controllers;

import java.util.List;
import javax.validation.Valid;
import org.pcedu.trainermvc.services.ITrainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class TrainerController {

    private String listUrl = "list";
    private String editUrl = "edit";
    private String deleteUrl = "delete";
    private String updateUrl = "update";

    @Autowired
    ITrainer trainerService;
    
    // get list of all trainers
    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listAllTrainers(ModelMap view, @RequestParam(required = false) String msg) {
        List<org.pcedu.trainermvc.entities.Trainer> trainers = trainerService.findAllTrainers();
        view.addAttribute("trainers", trainers);
        view.addAttribute("editurl", editUrl);
        view.addAttribute("deleteurl", deleteUrl);
        view.addAttribute("msg", msg);
        return ("trainerlist");
    }

    // get form for new trainer
    @GetMapping("/new")
    public String newTrainer(ModelMap view, @RequestParam(required=false) String msg, 
                                            @RequestParam(required=false) String color) {
        org.pcedu.trainermvc.entities.Trainer trainer = new org.pcedu.trainermvc.entities.Trainer();
        view.addAttribute("trainer", trainer);
        view.addAttribute("listurl", listUrl);
        view.addAttribute("message", msg);
        view.addAttribute("color", color);
        return ("newtrainer");
    }

    // post form for new trainer
    @PostMapping("/new")
    public String saveTrainer(ModelMap view,
            @Valid org.pcedu.trainermvc.entities.Trainer trainer,
            BindingResult bindingResult) {
        String msg;
        String color;
        if (bindingResult.hasErrors()) {
            msg = "Invalid inputs at the form!";
            color = "red";
        } else {
            if (trainerService.save(trainer)) {
                msg = "New Trainer get registered!";
                color = "green";
            } else {
                msg = "Something went wrong!";
                color = "red";
            }
        }
        view.addAttribute("listurl", listUrl);
        return ("redirect:/new?msg=" + msg + "&color=" + color);
    }

    // delete for an existing trainer
    @GetMapping("/delete/{id}")
    public String deleteTrainer(ModelMap view, @PathVariable int id) {
        if (trainerService.delete(id)) {
            view.addAttribute("msg", new String("Deleted Successfully!"));
        } else {
            view.addAttribute("msg", new String("Not Deleted!"));
        }
        return ("redirect:/list");
    }

    // show edit / update for an existing trainer
    @GetMapping("/edit/{id}")
    public String editTrainer(ModelMap view, @PathVariable int id, @RequestParam(required=false) String msg) {
        org.pcedu.trainermvc.entities.Trainer trainer = trainerService.findById(id);
        view.addAttribute("trainer", trainer);
        view.addAttribute("updateurl", updateUrl);
        view.addAttribute("listurl", listUrl);
        view.addAttribute("error", msg);
        return ("edittrainer");
    }

    // store edit / update for an existing trainer
    @PostMapping("/update")
    public String updateTrainer(ModelMap view,
            @Valid org.pcedu.trainermvc.entities.Trainer trainer,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String error = "Invalid inputs at the form!";
            return ("redirect:/edit/" + trainer.getId() + "?msg=" + error);
        } else {
            if (trainerService.update(trainer)) {
                view.addAttribute("msg", new String("Updated successfully!"));
            } else {
                view.addAttribute("msg", new String("Something went wrong!"));
            }
            return ("redirect:/list");
        }
    }
}
