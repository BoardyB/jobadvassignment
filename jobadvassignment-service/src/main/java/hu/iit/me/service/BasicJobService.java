package hu.iit.me.service;

import hu.iit.me.model.Job;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class BasicJobService implements JobService {

    @Override
    public Collection<Job> listAllJobs() {
        List<Job> list = new ArrayList<>();
        int jobNumber = ThreadLocalRandom.current().nextInt(1, 10);
        list.add(new Job(UUID.randomUUID().toString(), "Job " + String.valueOf(jobNumber), "This is a job", new Date(), "Random company", "this@that.com", 400000));
        return list;
    }
}
