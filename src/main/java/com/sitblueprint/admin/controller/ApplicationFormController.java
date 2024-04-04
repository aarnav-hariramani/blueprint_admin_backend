package com.sitblueprint.admin.controller;

import com.sitblueprint.admin.model.applications.ApplicationForm;
import com.sitblueprint.admin.service.applications.ApplicationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/applications/")
public class ApplicationFormController {
    @Autowired
    ApplicationFormService applicationFormService;

    @GetMapping
    public List<ApplicationForm> getApplicationForms() {
        return applicationFormService.getApplicationForms();
    }

    @GetMapping
    public ApplicationForm getApplicationFormById(@Param("applicationFormId") String applicationFormId) {
        return applicationFormService.getApplicationFormById(Long.parseLong(applicationFormId));
    }

    @PostMapping("/submit")
    public ApplicationForm submitApplicationForm(@RequestBody ApplicationForm applicationForm) {
        return applicationFormService.createApplicationForm(applicationForm);
    }

    @PutMapping
    public ApplicationForm updateApplicationForm(@RequestBody ApplicationForm applicationForm) {
        return applicationFormService.updateApplicationForm(applicationForm);
    }
}
