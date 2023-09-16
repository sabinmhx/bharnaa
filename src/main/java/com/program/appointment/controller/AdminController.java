package com.program.appointment.controller;

import com.program.appointment.entity.Appointment;
import com.program.appointment.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @Autowired
    AppointmentService appointmentService;
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }

    @GetMapping("/admin/appointmentList")
    public String getAllAppointments(Model model){
        model.addAttribute("appointmentList", appointmentService.getAllAppointments());
        return "appointmentList";
    }
    @GetMapping("/403")
    public String loadAccessDeniedPage(){
        return "403";
    }
}
