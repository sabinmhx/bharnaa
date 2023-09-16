package com.program.appointment.controller;

import com.program.appointment.dto.request.AppointmentRequestDto;
import com.program.appointment.dto.response.AppointmentResponseDto;
import com.program.appointment.entity.Appointment;
import com.program.appointment.services.AppointmentService;
import com.program.appointment.services.other.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final AppointmentService appointmentService;
    private final EmailService emailService;

    @GetMapping("/")
    public String home(Model model){
        return "index";
    }
    @GetMapping("/make-appointment")
    public String makeAppoitnment(Model model){
        model.addAttribute("appointment", new AppointmentRequestDto());
        return "makeappointment";
    }
    @PostMapping("/save-appointment")
    public String saveAppointment(Model model, @ModelAttribute("appointment")AppointmentRequestDto appointmentRequestDto
    , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "makeappointment";
        }
        appointmentService.saveAppointment(appointmentRequestDto);
        return "booked";
    }
    @PostMapping("/booked")
    public String getSignUp(@ModelAttribute AppointmentRequestDto dto , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "makeappointment";
        }

        //***------Sending the message of sgnup
        String receiverEmail = "ashishlamatamang789@gmail.com";
        String subject = "Welcome to our medical care centre";
        String message = "Your appointment has been booked";

        //Sending the email
        emailService.sendEmail(receiverEmail, subject, message);

        return "booked";
    }

}
