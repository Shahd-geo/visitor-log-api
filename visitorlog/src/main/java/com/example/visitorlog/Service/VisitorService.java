package com.example.visitorlog.Service;

import com.example.visitorlog.model.Visitor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class VisitorService {
    private List<Visitor> visitors = new ArrayList<>();
    private AtomicLong counter = new AtomicLong();

    public List<Visitor> getAllVisitors() {
        return visitors;
    }
    public Visitor addVisitor(Visitor visitor) {
        visitor.setId(counter.incrementAndGet()); //TO GENERATE ID
        visitors.add(visitor); //TO ADD THE VISITOR TO THE LIST
        return visitor;
    }
    //TO CALCULATE VISITOR SIZE
    public int getVisitorsCount() {
        return visitors.size();
    }
    // TO SEARCH IN LIST TO THE VISITORS THAT HAVE THE SAME ID
    public Visitor getVisitorById(Long id) {
        for (Visitor visitor : visitors) {
            if (visitor.getId().equals(id)) {
                return visitor;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Visitor not found");
    }
    public void deleteVisitor(Long id) {
        Visitor visitor = getVisitorById(id); //ENSURE THE VISITOR THERE
        visitors.remove(visitor);
    }

    //Bonus 1: Update Visitor
    public Visitor updateVisitor(Long id, Visitor updatedVisitor) {
        Visitor visitor = getVisitorById(id);
        visitor.setName(updatedVisitor.getName());
        visitor.setCompany(updatedVisitor.getCompany());
        visitor.setPurpose(updatedVisitor.getPurpose());
        return visitor;
    }
    //Bonus 2: Filter By Purpose
    public List<Visitor> getVisitorsByPurpose(String purpose) {
        return visitors.stream().filter(visitor ->
                        visitor.getPurpose().equalsIgnoreCase(purpose))
                .collect(Collectors.toList());
    }
}
