package com.example.visitorlog.Controller;

import com.example.visitorlog.Service.VisitorService;
import com.example.visitorlog.model.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class VisitorController {
    @Autowired
    private VisitorService visitorService;

    // 1. GET /api/visitors
    @GetMapping("/visitors")
    public List<Visitor> getAllVisitors() {
        return visitorService.getAllVisitors();
    }
    // 2. GET /api/visitors/{id}
    @GetMapping("/visitors/{id}")
    public Visitor getVisitorById(@PathVariable Long id) {
        return visitorService.getVisitorById(id);
    }
    // 3. POST /api/visitors
    @PostMapping("/visitors")
    @ResponseStatus(HttpStatus.CREATED)
    public Visitor addVisitor(@RequestBody Visitor visitor) {
        return visitorService.addVisitor(visitor);
    }
    // 4. DELETE /api/visitors/{id}
    @DeleteMapping("/visitors/{id}")
    public void deleteVisitor(@PathVariable Long id) {
        visitorService.deleteVisitor(id);
    }
    // 5. GET /api/visitors/count
    @GetMapping("/visitors/count")
    public Map<String, Integer> getVisitorsCount() {
        Map<String, Integer> response = new HashMap<>();
        response.put("total", visitorService.getVisitorsCount());
        return response;
    }
    // 6. GET /api/health
    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("developer", "Shahd Al Abdali");
        return response;
    }
    // Bonus: PUT /api/visitors/{id}
    @PutMapping("/visitors/{id}")
    public Visitor updateVisitor(@PathVariable Long id, @RequestBody Visitor visitor) {

        return visitorService.updateVisitor(id, visitor);
    }

    // Bonus: GET /api/visitors/filter?purpose=meeting
    @GetMapping("/visitors/filter")
    public List<Visitor> getVisitorsByPurpose(@RequestParam String purpose) {
        return visitorService.getVisitorsByPurpose(purpose);
    }
}
