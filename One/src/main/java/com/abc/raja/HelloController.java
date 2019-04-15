package com.abc.raja;

import org.springframework.web.bind.annotation.*;

/**
 * Hello world!
 */

@RestController
public class HelloController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Hello welcome to Spring boot!";
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public String getVal(@PathVariable("id") long id) {
        return "Multiplied value:" + (id * 1.22);
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String getStr(@RequestParam String str) {
        return "Multiplied value:" + str;
    }

}
