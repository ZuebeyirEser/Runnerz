package live.zubeyireser.runnerz.run;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

/*
    //here we are requestting mapping for /home in our localhost:8080
    @RequestMapping("/hello")
    String home() {
        return "Hello, runnerz!";
 */
    private final RunRepository runRepository;
    //our dependency injection
    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }
    @GetMapping ("")
    List<Run> findAll() {
        return runRepository.findAll();
    }
    // dynamically creating url whenever valid id is inserted it will create id accordingly
    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty()) {
            throw new RunNotFoundException();
        }
        return run.get();
    }
    // post
    @RequestMapping("")
    @ResponseStatus(HttpStatus.CREATED)// code: 201
    void create(@Valid @RequestBody Run run) {
        runRepository.create(run);
    }
    // put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Run run,@PathVariable Integer id) {
        runRepository.update(run,id);
    }
    // delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        runRepository.delete(id);
    }

}
