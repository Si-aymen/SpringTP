package com.example.foyer.Control;

import com.example.foyer.Entity.Bloc;
import com.example.foyer.Entity.Chambre;
import com.example.foyer.Entity.Universite;
import com.example.foyer.IService.IBlocService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {

    IBlocService blocService;

    // http://localhost:8089/tpfoyer/cloc/retrieve-all-bloc
    @GetMapping("/retrieve-all-bloc")
    public List<Bloc> getBlocs() {
        List<Bloc> listBlocs = blocService.retrieveAllBlocs();
        return listBlocs;
    }
    // http://localhost:8089/tpfoyer/Bloc/retrieve-Bloc/8
    @GetMapping("/retrieve-Bloc/{Bloc-id}")
    public Bloc retrieveBloc(@PathVariable("Bloc-id") Long chId) {
        Bloc Bloc = blocService.retrieveBloc(chId);
        return Bloc;
    }
    //http://localhost:8089/tpfoyer/Bloc/add-Bloc
    @PostMapping("/add-Bloc")
    public Bloc addBloc(@RequestBody Bloc c) {
        Bloc Bloc = blocService.addBloc(c);
        return Bloc;
    }

    // http://localhost:8089/tpfoyer/Bloc/remove-Bloc/{Bloc-id}
    @DeleteMapping("/remove-Bloc/{Bloc-id}")
    public void removeBloc(@PathVariable("Bloc-id") Long chId) {
        blocService.removeBloc(chId);
    }

    // http://localhost:8089/tpfoyer/Bloc/modify-Bloc
    @PutMapping("/modify-Bloc")
    public Bloc modifyBloc(@RequestBody Bloc c) {
        Bloc Bloc = blocService.modifyBloc(c);
        return Bloc;
    }

    // http://localhost:8089/tpfoyer/Bloc/Affecter-Chambres-a-Bloc/1
    @PutMapping("/affecter-chambres-To-bloc/{Bloc-id}")
    public Bloc affecterChambresABloc (@RequestBody List<Long> chambres, @PathVariable("Bloc-id") Long blocID) {
        Bloc bloc = blocService.affecterChambresABloc(chambres,blocID);
        return  bloc ;

    }

}
