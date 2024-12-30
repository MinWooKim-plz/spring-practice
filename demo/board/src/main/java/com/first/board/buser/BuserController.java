package com.first.board.buser;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/buser")
public class BuserController {
    private final BuserService buserService;

    @Autowired
    public BuserController(BuserService buserService) {
        this.buserService = buserService;
    }

    @GetMapping
    public List<Buser> getBusers() {
        return buserService.getBusers();
    }

    @GetMapping(path = "{buser_id}")
    public Buser getBuser(@PathVariable(name = "buser_id") Integer id) {
        return buserService.getBuser(id);
    }

    @PostMapping
    public void addBuser(@RequestBody Buser buser) { // @RequestBody를 쓰면 객체 바인딩(->JSON)
        buserService.addBuser(buser);
    }

    @DeleteMapping(path = "{buser_id}")
    public void deleteBuser(@PathVariable(name = "buser_id") Integer id) {
        buserService.deleteBuser(id);
    }

    @PutMapping(path = "{buser_id}")
    public void updateBuser(@PathVariable(name = "buser_id") Integer id, @RequestBody Buser buser) {
        buserService.updateBuser(id, buser.getName(), buser.getEmail());
    }
}
