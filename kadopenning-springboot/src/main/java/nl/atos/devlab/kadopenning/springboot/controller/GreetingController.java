package nl.atos.devlab.kadopenning.springboot.controller;

import java.util.concurrent.atomic.AtomicLong;

import nl.atos.devlab.kadopenning.springboot.model.Greeting;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Gegroet %s !";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/greeting/{name}",method=RequestMethod.GET)
    public Greeting greeting(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
