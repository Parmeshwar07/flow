package com.workflow.web;

import com.workflow.model.Response;
import com.workflow.model.Workflow;
import com.workflow.services.EntryService;
import com.workflow.services.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    private EntryService entryService;

    @PutMapping
    public @ResponseBody
    Response create(@RequestBody Workflow body){
        Workflow workflow=entryService.add(body);
        if (workflow!=null) {
            return new Response("SUCCESS", 100, body);
        }
        else return new Response("FAIL", 101, body);
    }

    @PostMapping("/{id}")
    public @ResponseBody Response update(@PathVariable("id") int id,@RequestBody Workflow body){
        if (entryService.update(id,body)) {
            return new Response("SUCCESS", 100, body);
        }
        else return new Response("FAIL", 101, null);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody Response delete(@PathVariable("id") int id){
        if(entryService.delete(id)) {
            return new Response("SUCCESS", 100, null);
        }
        else return new Response("FAIL", 101, null);
    }

    @GetMapping("/{id}")
    public @ResponseBody Response get(@PathVariable("id") int id){
        Workflow workflow=entryService.get(id);
        return new Response("SUCCESS",100,workflow);
    }

    @GetMapping
    public @ResponseBody
    Response get(){
        Iterable<Workflow> list=entryService.list();
        return new Response("SUCCESS",100,list);
    }
}
